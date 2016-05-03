package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		List<Henkilo> henkilot = new ArrayList<Henkilo>();
		henkilot = dao.haeKaikki();

		modelAll.addAttribute("tunnit", tunnit);
		modelAll.addAttribute("projektit", projektit);
		modelAll.addAttribute("henkilot", henkilot);

		return "secure/admin/super/naytaTunnit";
	}
	

	@RequestMapping(value = "/ktunti/{id}", method = RequestMethod.GET)
	public String getTunti(@PathVariable Integer id, Model model) {
		List<Tunnit> tunnit = new ArrayList<Tunnit>();
		tunnit = tdao.etsi(id);
		
		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();
		
		model.addAttribute("tunnit", tunnit);
		model.addAttribute("projektit", projektit);
	
		return "secure/admin/super/naytaTunnitK";
	}
	
	// PROJEKTIN TIETOJEN LIS��MINEN
		@RequestMapping(value = "/ptunti/{projID}", method = RequestMethod.GET)
		public String getProj(@PathVariable Integer projID, Model model) {
			
			List<Tunnit> ptunnit = new ArrayList<Tunnit>();
			ptunnit = tdao.etsiPT(projID);
			List<Henkilo> henkilot = new ArrayList<Henkilo>();
			henkilot = dao.haeKaikki();
			List<Projekti> projektit = new ArrayList<Projekti>();
			projektit = pdao.haeKaikki();
			
			model.addAttribute("ptunnit", ptunnit);
			model.addAttribute("henkilot", henkilot);
			model.addAttribute("projektit", projektit);
			return "secure/admin/super/projektinTunnit";
		}
		
		
}
