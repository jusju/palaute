package fi.palaute.controller;


import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import fi.palaute.bean.Kysymys;
import fi.palaute.bean.PalautteenLinkkiImpl;
import fi.palaute.bean.Toteutus;
import fi.palaute.bean.PalautteenLinkki;
import fi.palaute.dao.KysymysDAO;
import fi.palaute.dao.PalauteDAO;
import fi.palaute.dao.ToteutusDAO;
import fi.palaute.util.SpostiLahetys;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {
	
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
	private KysymysDAO kdao;
	
	public KysymysDAO getKdao() {
		return kdao;
	}

	public void setKdao(KysymysDAO kdao) {
		this.kdao = kdao;
	}
	
	@Inject
	private PalauteDAO pdao;
	
	public PalauteDAO getPdao() {
		return pdao;
	}

	public void setPdao(PalauteDAO pdao) {
		this.pdao = pdao;
	}

	@RequestMapping(value = "/oma", method = RequestMethod.GET)
	public String toteutuksetSivu (Model model) {

		List<Toteutus> toteutukset = tdao.haeKaikki();
		model.addAttribute("toteutukset", toteutukset);
		
		return "secure/kayttaja/naytaToteutukset";
		
	}
	
	@RequestMapping(value = "/oma/luopalaute/{id}", method = RequestMethod.GET)
	public String palauteLuonti (@PathVariable Integer id, Model model) {

		Toteutus toteutus = tdao.etsi(id);
		
		List<Kysymys> kysymykset = kdao.haeKaikki();
		
		model.addAttribute("toteutus", toteutus);
		model.addAttribute("kysymykset", kysymykset);
		
		return "secure/kayttaja/luoPalautus";
		
	}
	
	@RequestMapping(value = "/oma/laheta/{id}", method = RequestMethod.GET)
	public String linkiLuonti (HttpServletRequest request, @PathVariable Integer id, Model model) {
		//Haetaan toteutus
		Toteutus toteutus = tdao.etsi(id);
		
		//Luodaan saajat linkki
		String saajat = toteutus.getToteutusTunnus()+"@myy.haaga-helia.fi";
		
		//Generoidaan satunnainen
		String satunnainen = UUID.randomUUID().toString();
		
		//Luodaan linkki palautteeseen
		PalautteenLinkki pl = new PalautteenLinkkiImpl();
		pl.setToteutusID(id);
		pl.setSatunnainen(satunnainen);
		
		//Linkki lähtee tietokantaan
		pdao.talletaLinkki(pl);
		
		//Lähetetään linkki toteutuksen palautteeseen kaikille osallistujille
		String url = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/"
				 + "palautetoteutukselle/" + satunnainen;
		
		String subject = "Anna palautetta toteutukselle "+toteutus.getToteutusTunnus();
		sposti.sendMail(saajat, subject, url);
		
		String ilmoitus = "Linkki toteutuksen palautteeseen lähetetty kurssin osallistujille";
	
		model.addAttribute("ilmoitus", ilmoitus);
		
		
		return "secure/kayttaja/linkkiLahetetty";
		
	}
}