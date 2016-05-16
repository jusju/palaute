package fi.tunnit.lila.controller;

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


import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.HenkiloImpl;
import fi.tunnit.lila.bean.Poletti;
import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.PolettiDAO;
import fi.tunnit.lila.dao.ProjektiDAO;
import fi.tunnit.lila.bean.Tunnit;

import fi.tunnit.lila.dao.TunnitDAO;
import fi.tunnit.lila.util.SalasananKryptaaja;

@Controller
@RequestMapping(value = "/henkilo")
public class HenkiloController {

	@Inject
	private TunnitDAO tdao;

	@Inject
	private HenkiloDAO dao;

	@Inject
	private ProjektiDAO pdao;
	
	@Inject
	private PolettiDAO podao;
	
	
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
	
	public PolettiDAO getPodao() {
		return podao;
	}

	public void setPodao(PolettiDAO podao) {
		this.podao = podao;
	}

	// Uuden käyttäjän luonti
	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String CreateForm(Model model) {
		Henkilo tyhjaHenkilo = new HenkiloImpl();
		

		model.addAttribute("henkilo", tyhjaHenkilo);
		return "lisaaKayttaja";
	}

	// Uuden käyttäjän luonnin tietojen vastaano
	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String getForm(@ModelAttribute(value = "henkilo") @Validated(HenkiloImpl.uusiHenkilo.class) HenkiloImpl henkilo, BindingResult result) {
		if(result.hasErrors()){
			return "/lisaaKayttaja";
		}else{
			SalasananKryptaaja sk = new SalasananKryptaaja();
			henkilo.setSalasana(sk.kryptattuna(henkilo.getSalasana()));
			dao.talleta(henkilo);
		return "redirect:/";
		}
	}

	
	
	// KÄYTTÄJÄN MUOKKAUS TEKEMINEN
	@RequestMapping(value = "uusisalasana/{satunnainen}", method = RequestMethod.GET)
	public String getUusiSalasanaForm(@PathVariable String satunnainen, Model model) {
		
		List<Poletti> poletti = new ArrayList<Poletti>();
		poletti = podao.haeKaikki();
		
		int id = 0;
		
		for(int i = 0; i<poletti.size(); i++){
			if(poletti.get(i).getSatunnainen().equals(satunnainen)){
				id = poletti.get(i).getKaytID();
			}
		}
		
		podao.poistaSatunnainen(satunnainen);
		
		Henkilo henkilo = dao.etsi(id);
		model.addAttribute("henkilo", henkilo);
		
		Henkilo henkiloa = new HenkiloImpl();
		henkiloa.setId(henkilo.getId());
		henkiloa.setEtunimi(henkilo.getEtunimi());
		henkiloa.setSukunimi(henkilo.getSukunimi());
		henkiloa.setSposti(henkilo.getSposti());
		model.addAttribute("henkilo", henkiloa);
		return "lisaaSalasana";
	}
	
	// KÄYTTÄJÄN MUOKKAUS FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "uusisalasana/{satunnainen}", method = RequestMethod.POST)
	public String uusiSalasana(@ModelAttribute(value = "henkilo")@Validated(HenkiloImpl.uusiSalasana.class) HenkiloImpl henkilo, BindingResult result) {
		if(result.hasErrors()){

				return "lisaaSalasana";

		}else{
		SalasananKryptaaja sk = new SalasananKryptaaja();
		henkilo.setSalasana(sk.kryptattuna(henkilo.getSalasana()));
		dao.muokkaa(henkilo);
		return "redirect:/";
		}
	}



}
