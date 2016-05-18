package fi.palaute.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.palaute.bean.Kayttaja;

import fi.palaute.dao.KayttajaDAO;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {

	@Inject
	private KayttajaDAO dao;

	
	public KayttajaDAO getDao() {
		return dao;
	}

	public void setDao(KayttajaDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/oma", method = RequestMethod.GET)
	public String paasivu(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sposti = auth.getName();

	    Kayttaja kayttaja = dao.etsiSposti(sposti);
	    System.out.println(kayttaja.getTunnus());
	    
		model.addAttribute("henkilo", kayttaja);

		return "secure/kayttaja/naytaKayttaja";
		
	}
}