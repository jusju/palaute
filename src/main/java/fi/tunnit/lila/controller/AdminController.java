package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.ProjektiDAO;
import fi.tunnit.lila.dao.TunnitDAO;

@Controller
@RequestMapping(value="/secure/admin/super")
public class AdminController {
	
	@Inject
	private TunnitDAO tdao;
	
	@Inject
	private HenkiloDAO dao;
	
	@Inject
	private ProjektiDAO pdao;
	
	public ProjektiDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProjektiDAO pdao) {
		this.pdao = pdao;
	}
	
	public TunnitDAO getTdao() {
		return tdao;
	}

	public void setTdao(TunnitDAO tdao) {
		this.tdao = tdao;
	}
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
	
	// HAE KAIKKI TUNNIT
	@RequestMapping(value = "/tuntilista", method = RequestMethod.GET)
	public String showLista(Model modelAll) {

		List<Tunnit> tunnit = new ArrayList<Tunnit>();
		tunnit = tdao.haeTunnit();
		
		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();

		modelAll.addAttribute("tunnit", tunnit);
		modelAll.addAttribute("projektit", projektit);

		return "secure/admin/super/naytaTunnit";
	}
}
