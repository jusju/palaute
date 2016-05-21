package fi.palaute.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
import fi.palaute.bean.Toteutus;
import fi.palaute.bean.Vastaus;
import fi.palaute.bean.VastausImpl;
import fi.palaute.dao.KysymysDAO;
import fi.palaute.dao.PalauteDAO;
import fi.palaute.dao.ToteutusDAO;

@Controller
@RequestMapping (value="/main")
public class MainController{
	
	@Inject
	private ToteutusDAO tdao;
	
	public ToteutusDAO getTdao() {
		return tdao;
	}

	public void setTdao(ToteutusDAO tdao) {
		this.tdao = tdao;
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
		List<Vastaus> vastaukset = new ArrayList<Vastaus>();
		Palaute palaute = new PalauteImpl();
		Vastaus vastaus = new VastausImpl();
		
		model.addAttribute("toteutus", toteutus);
		model.addAttribute("kysymykset", kysymykset);
		model.addAttribute("palaute", palaute);
		model.addAttribute("vastaus", vastaus);
		model.addAttribute("vastaukset", vastaukset);

		return "naytaKysely";
	}
	
	// K�YTT�J�N MUOKKAUS FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "palautetoteutukselle/{satunnainen}", method = RequestMethod.POST)
	public String getPalauteForm(@ModelAttribute(value="palaute")PalauteImpl palaute, @ModelAttribute(value="vastaus") VastausImpl vastaus) {

		System.out.println(palaute);
		
		return "redirect:/";
	
	}
	
	
}