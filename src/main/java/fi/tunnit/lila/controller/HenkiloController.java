package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.tree.RowMapper;
import javax.validation.Valid;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.sun.javafx.collections.MappingChange.Map;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.HenkiloImpl;
import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.ProjektiDAO;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.bean.TunnitImpl;
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

	// FORMIN TEKEMINEN
	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Henkilo tyhjaHenkilo = new HenkiloImpl();
		

		model.addAttribute("henkilo", tyhjaHenkilo);
		return "lisaaKayttaja";
	}

	// FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String muokkaa(@ModelAttribute(value = "henkilo") @Valid HenkiloImpl henkilo, BindingResult result) {
		if(result.hasErrors()){
			return "/lisaaKayttaja";
		}else{
			SalasananKryptaaja sk = new SalasananKryptaaja();
			henkilo.setSalasana(sk.kryptattuna(henkilo.getSalasana()));
			dao.talleta(henkilo);
		return "redirect:/";
		}
	}

	// K�YTT�J�N MUOKKAUS TEKEMINEN
	@RequestMapping(value = "muokkaa/{id}", method = RequestMethod.GET)
	public String getMuokkaaForm(@PathVariable Integer id, Model model) {
		Henkilo henkilo = dao.etsi(id);
		model.addAttribute("henkilo", henkilo);

		Henkilo henkiloa = new HenkiloImpl();
		henkiloa.setEtunimi(henkilo.getEtunimi());
		henkiloa.setSukunimi(henkilo.getSukunimi());
		henkiloa.setSposti(henkilo.getSposti());
		henkiloa.setSalasana(henkilo.getSalasana());
		model.addAttribute("henkilo", henkiloa);
		return "kayttaja/muokkaaKayttaja";
	}

	// K�YTT�J�N MUOKKAUS FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "muokkaa/{id}", method = RequestMethod.POST)
	public String create(@ModelAttribute(value = "henkilo")@Valid HenkiloImpl henkilo, BindingResult result) {
		if(result.hasErrors()){
			return "kayttaja/muokkaaKayttaja";
		}else{
		dao.muokkaa(henkilo);
		return "redirect:/henkilo/lista";
		}
	}

	// HAE KAIKKI OIKEA
	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public String showList(Model modelAll) {

		List<Henkilo> henkilot = new ArrayList<Henkilo>();
		henkilot = dao.haeKaikki();

		modelAll.addAttribute("henkilot", henkilot);
		return "kayttaja/listaaKayttajat";
	}

	// HAE KAIKKI TUNNIT
	@RequestMapping(value = "listaus", method = RequestMethod.GET)
	public String showLista(Model modelAll) {

		List<Tunnit> tunnit = new ArrayList<Tunnit>();
		tunnit = tdao.haeTunnit();

		modelAll.addAttribute("tunnit", tunnit);
		return "secure/kayttaja/listaaTunnit";
	}
/*
	// HENKIL�N TIETOJEN N�YTT�MINEN
	@RequestMapping(value = "ktunti/{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Henkilo henkilo = dao.etsi(id);
		model.addAttribute("henkilo", henkilo);

		List<Tunnit> tunnit = new ArrayList<Tunnit>();
		tunnit = tdao.etsi(id);

		model.addAttribute("tunnit", tunnit);

		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();

		model.addAttribute("projektit", projektit);

		return "kayttaja/naytaKayttaja";
	}
*/
	// TUNNIN TIETOJEN N�YTT�MINEN

	@RequestMapping(value = "ttunti/{tuntiID}", method = RequestMethod.GET)
	public String getTunti(@PathVariable Integer tuntiID, Model model) {
		Tunnit tunnit = tdao.etsiTunti(tuntiID);
		model.addAttribute("tunnit", tunnit);

		return "secure/tunnit/tunninTiedot";
	}

	// PROJEKTIN TIETOJEN L�YT�MINEN
	@RequestMapping(value = "ptunti/{projID}", method = RequestMethod.GET)
	public String getProj(@PathVariable Integer projID, Model model) {
		Projekti projekti = pdao.etsi(projID);
		model.addAttribute("projekti", projekti);

		return "secure/projekti/projektinTiedot";
	}

	// HAE KAIKKI PROJEKTIT

	@RequestMapping(value = "projlista", method = RequestMethod.GET)
	public String showPlista(Model modelAll) {

		List<Projekti> projektit = new ArrayList<Projekti>();
		projektit = pdao.haeKaikki();

		modelAll.addAttribute("projektit", projektit);
		return "secure/kayttaja/listaaTunnit";
	}

	// POISTA K�YTT�J� 

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String showDelete(@PathVariable("id") Integer id) {	

		
			tdao.poistaHTunnit(id);
			dao.poistaHenkilo(id);

			return "secure/kayttaja/poistoApu";
	}
	
	

}
