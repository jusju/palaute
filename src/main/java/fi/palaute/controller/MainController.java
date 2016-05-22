package fi.palaute.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.palaute.bean.Kysymys;
import fi.palaute.bean.Palaute;
import fi.palaute.bean.PalauteImpl;
import fi.palaute.bean.PalautteenLinkki;
import fi.palaute.bean.PalautteenLinkkiImpl;
import fi.palaute.bean.PalautteenVastaukset;
import fi.palaute.bean.Toteutus;
import fi.palaute.bean.VahvistusLinkki;
import fi.palaute.bean.VahvistusLinkkiImpl;
import fi.palaute.bean.Vastaus;
import fi.palaute.bean.VastausImpl;
import fi.palaute.dao.KysymysDAO;
import fi.palaute.dao.PalauteDAO;
import fi.palaute.dao.ToteutusDAO;
import fi.palaute.dao.VastausDAO;
import fi.palaute.util.SpostiLahetys;


@Controller
@RequestMapping (value="/main")
public class MainController{
	
	@Autowired
	private SpostiLahetys sposti;
	
	@Inject
	private ToteutusDAO tdao;
	
	public ToteutusDAO getTdao() {
		return tdao;
	}

	public void setTdao(ToteutusDAO tdao) {
		this.tdao = tdao;
	}
	
	@Inject
	private VastausDAO vdao;
	
	public VastausDAO getvdao() {
		return vdao;
	}

	public void setVdao(VastausDAO vdao) {
		this.vdao = vdao;
	}
	
	@Inject
	private PalauteDAO pdao;
	
	public PalauteDAO getPdao() {
		return pdao;
	}

	public void setPdao(PalauteDAO pdao) {
		this.pdao = pdao;
	}
	
	@Inject
	private KysymysDAO kdao;
	
	public KysymysDAO getKdao() {
		return kdao;
	}

	public void setKdao(KysymysDAO kdao) {
		this.kdao = kdao;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toteutuksetSivu (Model model) {

		List<Toteutus> toteutukset = tdao.haeKaikki();
		model.addAttribute("toteutukset", toteutukset);
		
		return "toteutukset";
		
	}
	
	//Palautteen linkin tarkastus
	@RequestMapping(value = "palautetoteutukselle/{satunnainen}", method = RequestMethod.GET)
	public String createPalauteForm(@PathVariable String satunnainen, Model model) {
		//Haetaan kaikki linkit tietokannasta
		List<PalautteenLinkki> pl = pdao.haeKaikkiLinkit();
		//Vertailu ja toteutuksen id etsiminen
		int toteutusid = 0;
		
		for(int i = 0; i<pl.size(); i++){
			if(pl.get(i).getSatunnainen().equals(satunnainen)){
				toteutusid = pl.get(i).getToteutusID();
			}
		}
		
		if(toteutusid == 0){
			String ilmoitus = "Linkki on vanhentunut, palautteen antaminen on mahdotonta.";
			model.addAttribute("ilmoitus", ilmoitus);
			return "vanhaLinkki";
		}
		
		Toteutus toteutus = tdao.etsi(toteutusid);
		List<Kysymys> kysymykset = kdao.haeKaikki();
		Palaute palaute = new PalauteImpl();
		Vastaus vastaus = new VastausImpl();
		List<Vastaus> vastaukset = new ArrayList<Vastaus>();
		
		model.addAttribute("toteutus", toteutus);
		model.addAttribute("kysymykset", kysymykset);
		model.addAttribute("palaute", palaute);
		model.addAttribute("vastaus", vastaus);
		model.addAttribute("vastaukset", vastaukset);

		return "naytaKysely";
	}
	
	// Palautteen tietojen vastaanotta ja vahvistuslinkin generointi ja lähetys
	@RequestMapping(value = "palautetoteutukselle/{satunnainen}", method = RequestMethod.POST)
	public String getPalauteForm(HttpServletRequest request, PalauteImpl palaute, VastausImpl vastaus, Model model) {
		
		String[] values = vastaus.getVastausteksti().split(",");
		ArrayList<Vastaus> vastaukset = new ArrayList<Vastaus>();
		int i=1;
		for(String v : values){
			Vastaus vast = new VastausImpl();
			vast.setKysymysID(i++);
			vast.setVastausteksti(v);
			vastaukset.add(vast);
		}
		
		for(int in=0;in<vastaukset.size();in++){
			System.out.println(vastaukset.get(in).getKysymysID() +" - "+vastaukset.get(in).getVastausteksti());
		}
		palaute.setVastaukset(vastaukset);
		
		System.out.println(palaute);
		
		pdao.talleta(palaute);
		
		Toteutus toteutus = tdao.etsi(palaute.getToteutusID());
		
		//----------------
		
		//Luodaan vahvistus linkki
		String saaja = palaute.getVastaaja()+"@myy.haaga-helia.fi";
		System.out.println(saaja);
		
		//Generoidaan satunnainen
		String satunnainen = UUID.randomUUID().toString();
		
		//Luodaan linkki palautteeseen
		VahvistusLinkki vl = new VahvistusLinkkiImpl();
		vl.setPalauteID(palaute.getPalauteID());
		vl.setSatunnainen(satunnainen);
		
		//Kaikki lähtee tietokantaan

		//paikka varattu
		pdao.talletaVahvistusLinkki(vl);
		
		//Lähetetään linkki toteutuksen palautteeseen kaikille osallistujille
		String url = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/main/"
				 + "vahvistus/" + satunnainen;
		
		String subject = "Vahvista annettu palaute toteutukselle "+toteutus.getToteutusTunnus();
		sposti.sendMail(saaja, subject, url);
		
		String ilmoitus = "Palautteen vahvistuslinkki lähetetty opiskelijalle"+palaute.getVastaaja();
		
		pdao.insertVastaukset(vastaukset);
	
		model.addAttribute("ilmoitus", ilmoitus);
		
		return "redirect:/";
	
	}
	
	//Vahvistus linkin tarkastus
		@RequestMapping(value = "vahvistus/{satunnainen}", method = RequestMethod.GET)
		public String vahvitettu(@PathVariable String satunnainen, Model model) {
			//Haetaan kaikki linkit tietokannasta
			List<VahvistusLinkki> vl = pdao.haeKaikkiVahvistukset();
			//Vertailu ja palautteen id etsiminen
			int palauteid = 0;
			
			for(int i = 0; i<vl.size(); i++){
				if(vl.get(i).getSatunnainen().equals(satunnainen)){
					palauteid = vl.get(i).getPalauteID();
				}
			}
			
			if(palauteid == 0){
				String ilmoitus = "Palautteesi on jo vahvistettu, kiitos.";
				model.addAttribute("ilmoitus", ilmoitus);
				return "kiitos";
			}else{
				String ilmoitus = "Palautteesi on vahvistettu, kiitos";
				Palaute palaute = pdao.etsiPalaute(palauteid);
				pdao.setVahvistus(palaute);
				pdao.poistaVahvistus(satunnainen);
				model.addAttribute("ilmoitus", ilmoitus);
				
			}
			return "kiitos";

		}
		
		@RequestMapping(value = "/toteutuksenpalautteet/{id}", method = RequestMethod.GET)
		public String getTunti(@PathVariable Integer id, Model model) {
			List<Palaute> palautteet = new ArrayList<Palaute>();
			palautteet = pdao.haeVahvistetut();
			
			List<Vastaus> vastaukset = new ArrayList<Vastaus>();
			vastaukset = vdao.haeKaikkiVastaukset();
			
			List<Kysymys> kysymykset = new ArrayList<Kysymys>();
			kysymykset = kdao.haeKaikki();
			
			List<PalautteenVastaukset> pv = new ArrayList<PalautteenVastaukset>();
			pv = pdao.haeKaikkiPalautteenVastaukset();
			
			Toteutus toteutus = tdao.etsi(id);
			
			model.addAttribute("palautteet", palautteet);
			model.addAttribute("vastaukset", vastaukset);
			model.addAttribute("kysymykset", kysymykset);
			model.addAttribute("pvastaukset", pv);
			model.addAttribute("toteutus", toteutus);

			return "palautteet";
		}
	
	
}