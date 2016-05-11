package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.HenkiloImpl;
import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.bean.ProjektiImpl;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.bean.TunnitImpl;
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
		
		List<Tunnit> kaikkitunnit = new ArrayList<Tunnit>();
		kaikkitunnit = tdao.haeTunnit();
		
		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();
		
		model.addAttribute("tunnit", tunnit);
		model.addAttribute("kaikki", kaikkitunnit);
		model.addAttribute("projektit", projektit);

		return "secure/kayttaja/naytaKayttaja";
		
	}
	//K�ytt�j�n omat tunnit
	@RequestMapping(value = "/oma/tunnit", method = RequestMethod.GET)
	public String paasivuT(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sposti = auth.getName();
	    System.out.println(sposti);

	    Henkilo henkilo = dao.etsiSposti(sposti);
	    
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
	
	
	// Tunnin lis�ys
		@RequestMapping(value = "oma/uusi", method = RequestMethod.GET)
		public String getCreateFormTunnit(Model model) {
		
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String sposti = auth.getName();

		    Henkilo henkilo = dao.etsiSposti(sposti);
		    
		    int id = henkilo.getId();
		    
			model.addAttribute("henkilo", henkilo);
			
			List<Projekti> projektit = new ArrayList<Projekti>();
			projektit = pdao.haeKaikki();
			
			model.addAttribute("projektit", projektit);
			
			Tunnit uusiTunti = new TunnitImpl();
			uusiTunti.setKaytID(id);
			
			uusiTunti.setDate("");

			model.addAttribute("tunti", uusiTunti);
			return "secure/kayttaja/lisaaTunti";
		}

		// TUNNIN TIETOJEN VASTAANOTTO
		@RequestMapping(value = "oma/uusi", method = RequestMethod.POST)
		public String create(@ModelAttribute(value = "tunti") @Valid TunnitImpl tunti, BindingResult result, Model model) {
			if(result.hasErrors()){
				List<Projekti> projektit = new ArrayList<Projekti>();
				projektit = pdao.haeKaikki();
				
				model.addAttribute("projektit", projektit);
				return "secure/kayttaja/lisaaTunti";
			}else{
				tdao.talleta(tunti);
				return "redirect:/secure/oma/tunnit";
			}
		}
		
		// POISTA TUNTI
				@RequestMapping(value = "oma/tunnit/delete/{tuntiID}", method = RequestMethod.GET)
				public String getCreateForm(@PathVariable("tuntiID") Integer tuntiID,
						Model model) {
					tdao.poistaTunti(tuntiID);
					return "secure/kayttaja/poistaTuntiApu";
				}

}
