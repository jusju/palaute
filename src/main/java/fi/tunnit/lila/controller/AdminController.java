package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.dao.HenkiloDAO;

@Controller
@RequestMapping(value="/secure/admin/super")
public class AdminController {
	
	@Inject
	private HenkiloDAO dao;
	
	public HenkiloDAO getDao() {
		return dao;
	}

	public void setDao(HenkiloDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public String paasivu(Model model) {

		
		List<Henkilo> henkilot = new ArrayList<Henkilo>();
		henkilot = dao.haeKaikki();

		model.addAttribute("henkilot", henkilot);
		
		
		return "secure/admin/super/tools";
	}
}
