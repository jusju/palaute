package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.HenkiloImpl;
import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.bean.ProjektiImpl;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.HenkiloDAOSpringJdbcImpl;
import fi.tunnit.lila.dao.ProjektiDAO;
import fi.tunnit.lila.dao.ProjektiDAOSpringJdbcImpl;
import fi.tunnit.lila.dao.TunnitDAO;
import fi.tunnit.lila.dao.TunnitDAOSpringJdbcImpl;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {
	
	@Inject
	private TunnitDAO tdao;

	@Inject
	private HenkiloDAO dao;

	@Inject
	private ProjektiDAO pdao;
	
	
	public HenkiloDAO getDao() {
		return dao;
	}

	public void setDao(HenkiloDAO dao) {
		this.dao = dao;
	}

	public TunnitDAO getTdao() {
		return tdao;
	}

	public void setTdao(TunnitDAO tdao) {
		this.tdao = tdao;
	}

	public ProjektiDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProjektiDAO pdao) {
		this.pdao = pdao;
	}

	@RequestMapping(value = "/oma", method = RequestMethod.GET)
	public String paasivu(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sposti = auth.getName();
	    System.out.println(sposti);

	    Henkilo henkilo = dao.etsiSposti(sposti);
	    System.out.println(henkilo.getEtunimi());
	    
	    int id = henkilo.getId();
	    
		model.addAttribute("henkilo", henkilo);

		List<Tunnit> tunnit = new ArrayList<Tunnit>();
		tunnit = tdao.etsi(id);
		
		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();
		
		model.addAttribute("tunnit", tunnit);
		model.addAttribute("projektit", projektit);

		return "secure/kayttaja/naytaKayttaja";
		
	}
	
	@RequestMapping(value = "/oma/tunnit", method = RequestMethod.GET)
	public String paasivuT(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sposti = auth.getName();
	    System.out.println(sposti);

	    Henkilo henkilo = dao.etsiSposti(sposti);
	    System.out.println(henkilo.getEtunimi());
	    
	    int id = henkilo.getId();
	    
		model.addAttribute("henkilo", henkilo);

		List<Tunnit> tunnit = new ArrayList<Tunnit>();
		tunnit = tdao.etsi(id);
		
		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();
		
		model.addAttribute("tunnit", tunnit);
		model.addAttribute("projektit", projektit);

		return "secure/kayttaja/naytaTunnit";
		
	}
	
	@RequestMapping(value = "/oma/projektit", method = RequestMethod.GET)
	public String paasivuP(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sposti = auth.getName();
	    System.out.println(sposti);

	    Henkilo henkilo = dao.etsiSposti(sposti);
	    System.out.println(henkilo.getEtunimi());
	    
	    //int id = henkilo.getId();
	    
		model.addAttribute("henkilo", henkilo);
		
		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();

		model.addAttribute("projektit", projektit);

		return "secure/kayttaja/naytaProjektit";
		
	}

}
