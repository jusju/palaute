package fi.palaute.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import fi.palaute.bean.Kayttaja;
import fi.palaute.bean.KayttajaImpl;
import fi.palaute.bean.Poletti;
import fi.palaute.dao.KayttajaDAO;
import fi.palaute.dao.PolettiDAO;
import fi.palaute.util.SalasananKryptaaja;

@Controller
@RequestMapping(value = "/kayttaja")
public class KayttajaController {

	@Inject
	private KayttajaDAO dao;
	
	@Inject
	private PolettiDAO podao;
	
	
	public KayttajaDAO getDao() {
		return dao;
	}

	public void setDao(KayttajaDAO dao) {
		this.dao = dao;
	}
	
	public PolettiDAO getPodao() {
		return podao;
	}

	public void setPodao(PolettiDAO podao) {
		this.podao = podao;
	}

	// Uuden käyttäjän luonti
	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String createForm(Model model) {
		Kayttaja tyhjaKayttaja = new KayttajaImpl();
		

		model.addAttribute("kayttaja", tyhjaKayttaja);
		return "lisaaKayttaja";
	}

	// Uuden käyttäjänn luonnin tietojen vastaanotto
	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String getForm(@ModelAttribute(value = "kayttaja") @Validated(KayttajaImpl.uusiKayttaja.class) KayttajaImpl kayttaja, BindingResult result) {
		if(result.hasErrors()){
			return "/lisaaKayttaja";
		}else{
			SalasananKryptaaja sk = new SalasananKryptaaja();
			kayttaja.setSalasana(sk.kryptattuna(kayttaja.getSalasana()));
			kayttaja.setTunnus(kayttaja.getTunnus().toLowerCase());
			dao.talleta(kayttaja);
		return "redirect:/";
		}
	}

	
	
	// Käyttäjän salasanan päivitys
	@RequestMapping(value = "uusisalasana/{satunnainen}", method = RequestMethod.GET)
	public String getUusiSalasanaForm(@PathVariable String satunnainen, Model model) {
		
		//Etsitään kertakäyttöinen poletti
		List<Poletti> poletti = new ArrayList<Poletti>();
		poletti = podao.haeKaikki();
		
		int id = 0;
		
		for(int i = 0; i<poletti.size(); i++){
			if(poletti.get(i).getSatunnainen().equals(satunnainen)){
				id = poletti.get(i).getKaytID();
			}
		}
		//Poistetaan sen
		podao.poistaSatunnainen(satunnainen);
		//Tuodan sivulle käyttäjä, jonka poletti oli poistettu
		Kayttaja kayttaja = dao.etsi(id);
		model.addAttribute("kayttaja", kayttaja);
		
		Kayttaja kayttajaa = new KayttajaImpl();
		kayttajaa.setId(kayttaja.getId());
		kayttajaa.setTunnus(kayttaja.getTunnus());
		model.addAttribute("kayttaja", kayttajaa);
		return "lisaaSalasana";
	}
	
	// Käyttäjän salasanan päivitys formin vastaanotto
	@RequestMapping(value = "uusisalasana/{satunnainen}", method = RequestMethod.POST)
	public String uusiSalasana(@ModelAttribute(value = "kayttaja")@Validated(KayttajaImpl.uusiSalasana.class) KayttajaImpl kayttaja, BindingResult result) {
		if(result.hasErrors()){

				return "lisaaSalasana";

		}else{
		SalasananKryptaaja sk = new SalasananKryptaaja();
		kayttaja.setSalasana(sk.kryptattuna(kayttaja.getSalasana()));
		dao.uusiSalasana(kayttaja);
		return "redirect:/";
		}
	}



}
