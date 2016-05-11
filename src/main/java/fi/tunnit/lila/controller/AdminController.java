package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.HenkiloImpl;
import fi.tunnit.lila.bean.KayttajanAuthority;
import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.bean.ProjektiImpl;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.KayttajanAuthorityDAO;
import fi.tunnit.lila.dao.ProjektiDAO;
import fi.tunnit.lila.dao.TunnitDAO;
import fi.tunnit.lila.util.SalasananKryptaaja;

@Controller
@RequestMapping(value = "/secure/admin/super")
public class AdminController {

	@Inject
	private TunnitDAO tdao;

	@Inject
	private HenkiloDAO dao;

	@Inject
	private ProjektiDAO pdao;
	
	@Inject
	private KayttajanAuthorityDAO kdao;

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
	
	public KayttajanAuthorityDAO getkDao() {
		return kdao;
	}

	public void setKdao(KayttajanAuthorityDAO kdao) {
		this.kdao = kdao;
	}

	
	//HAE KAIKKI K�YTT�J�T
	@RequestMapping(value = "/kayttajalista", method = RequestMethod.GET)
	public String paasivu(Model model) {

		List<Henkilo> henkilot = new ArrayList<Henkilo>();
		henkilot = dao.haeKaikki();
		
		List<KayttajanAuthority> authorit = new ArrayList<KayttajanAuthority>();
		authorit = kdao.etsiK();
		
		model.addAttribute("authorit", authorit);
		model.addAttribute("henkilot", henkilot);

		return "secure/admin/super/naytaKayttajat";
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
		
		Henkilo henk = dao.etsi(id);

		model.addAttribute("henkilo", henk);
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
		
		Projekti proj = pdao.etsi(projID);

		model.addAttribute("proj", proj);
		model.addAttribute("ptunnit", ptunnit);
		model.addAttribute("henkilot", henkilot);
		model.addAttribute("projektit", projektit);
		return "secure/admin/super/projektinTunnit";
	}

	// POISTA K�YTT�J�

	@RequestMapping(value = "/delete/kayttaja/{id}", method = RequestMethod.GET)
	public String showDelete(@PathVariable("id") Integer id) {

		tdao.poistaHTunnit(id);
		dao.poistaHenkilonAuth(id);
		dao.poistaHenkilonPoletti(id);
		dao.poistaHenkilo(id);

		return "secure/admin/super/poistoApuKayttaja";
	}

	// K�YTT�J�N MUOKKAUS TEKEMINEN
	@RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
	public String getMuokkaaForm(@PathVariable Integer id, Model model) {
		Henkilo henkilo = dao.etsi(id);
		model.addAttribute("henkilo", henkilo);

		Henkilo henkiloa = new HenkiloImpl();
		henkiloa.setEtunimi(henkilo.getEtunimi());
		henkiloa.setSukunimi(henkilo.getSukunimi());
		henkiloa.setSposti(henkilo.getSposti());
		henkiloa.setSalasana(henkilo.getSalasana());
		model.addAttribute("henkilo", henkiloa);
		return "secure/admin/super/muokkaaKayttaja";
	}

	// K�YTT�J�N MUOKKAUS FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.POST)
	public String create(
			@ModelAttribute(value = "henkilo") @Validated(HenkiloImpl.muokkaaHenkilo.class) HenkiloImpl henkilo,
			BindingResult result) {
		if (result.hasErrors()) {
			return "secure/admin/super/muokkaaKayttaja";
		} else {
			SalasananKryptaaja sk = new SalasananKryptaaja();
			henkilo.setSalasana(sk.kryptattuna(henkilo.getSalasana()));
			dao.muokkaa(henkilo);
			return "redirect:/secure/admin/super/kayttajalista";
		}
	}

	// POISTA TUNTI
	@RequestMapping(value = "/delete/tunti/{tuntiID}", method = RequestMethod.GET)
	public String getCreateForm(@PathVariable("tuntiID") Integer tuntiID,
			Model model) {
		tdao.poistaTunti(tuntiID);
		return "secure/admin/super/poistoApuTunti";
	}

	// POISTA K�ytt�j�sivulla TUNTI
	@RequestMapping(value = "/delete/ktunti/{tuntiID}", method = RequestMethod.GET)
	public String getCreateForme(@PathVariable("tuntiID") Integer tuntiID,
			Model model) {
		tdao.poistaTunti(tuntiID);
		return "secure/admin/super/poistoApuKTunti";
	}

	// HAE KAIKKI PROJEKTIT
	@RequestMapping(value = "/projektilista", method = RequestMethod.GET)
	public String showListap(Model modelAll) {

		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();

		modelAll.addAttribute("projektit", projektit);
		return "secure/admin/super/listaaProjektit";
	}

	// POISTA PROJEKTI

	@RequestMapping(value = "delete/projekti/{projID}", method = RequestMethod.GET)
	public String showDeletep(@PathVariable("projID") Integer projID) {
		tdao.poistaPTunnit(projID);
		pdao.poistaProjekti(projID);

		return "secure/admin/super/poistoApuProjekti";

	}

	// PROJEKTIN LUONTI
	@RequestMapping(value = "uusi/projekti", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Projekti uusiProjekti = new ProjektiImpl();

		model.addAttribute("projekti", uusiProjekti);
		return "secure/admin/super/lisaaProjekti";
	}

	// UUDEN PROJEKTIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "uusi/projekti", method = RequestMethod.POST)
	public String create(
			@ModelAttribute(value = "projekti") ProjektiImpl projekti) {
		pdao.talleta(projekti);
		return "redirect:/secure/admin/super/projektilista";
	}

	// muokkaa k�ytt�j�n oikeus

	@RequestMapping(value = "/muokkaa/kayttajanoikeus/{id}", method = RequestMethod.GET)
	public String annaOikeudet(@PathVariable("id") Integer id) {

		dao.muokkaaOikeus(id);

		return "secure/admin/super/muokkausOikeudetApu";
	}

	// muokkaa k�ytt�j�n oikeus

	@RequestMapping(value = "/poista/kayttajanoikeus/{id}", method = RequestMethod.GET)
	public String poistaOikeudet(@PathVariable("id") Integer id) {

		dao.OikeusPoisto(id);

		return "secure/admin/super/poistoOikeudetApu";
	}
	
	

}
