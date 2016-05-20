package fi.palaute.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.palaute.bean.Toteutus;
import fi.palaute.dao.ToteutusDAO;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {
	
	@Inject
	private ToteutusDAO tdao;
	
	
	public ToteutusDAO getTdao() {
		return tdao;
	}

	public void setTdao(ToteutusDAO tdao) {
		this.tdao = tdao;
	}

	@RequestMapping(value = "/oma", method = RequestMethod.GET)
	public String paasivu(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		List<Toteutus> toteutukset = tdao.haeKaikki();
		model.addAttribute("toteutukset", toteutukset);
		
		
		return "secure/kayttaja/naytaToteutukset";
		
	}
}