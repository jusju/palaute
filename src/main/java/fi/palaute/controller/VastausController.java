package fi.palaute.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import fi.palaute.bean.Kysymys;
import fi.palaute.bean.KysymysImpl;
import fi.palaute.bean.Vastaus;
import fi.palaute.bean.VastausImpl;
import fi.palaute.dao.KysymysDAO;
import fi.palaute.dao.KysymysDAOSpringJdbcImpl;
import fi.palaute.dao.VastausDAO;


@Controller
@RequestMapping(value = "/kysely")
public class VastausController {

	@Inject
	private KysymysDAO dao;

	@Inject
	private VastausDAO vdao;

	public KysymysDAO getDao() {
		return dao;
	}

	public void setDao(KysymysDAO dao) {
		this.dao = dao;

	}

	public VastausDAO getVdao() {
		return vdao;
	}

	public void setVdao(VastausDAO vdao) {
		this.vdao = vdao;

	}

	// Hae kysymykset

	  @RequestMapping(value = "/kysymykset", method = RequestMethod.GET) public
	  String kyselySivu(Model model) {
	  
	  List<Kysymys> kysymykset = new ArrayList<Kysymys>(); kysymykset =
	  dao.haeKaikki();
	  
	  model.addAttribute("kysymykset", kysymykset);
	  
	  return "naytaKysely";
	 
	  }
	

	// Uusi vastaus
		/*@RequestMapping(value = "/kysymykset", method = RequestMethod.GET)
	public String setForm(@PathVariable Integer kysymysID, Model model) {

		Kysymys kysymys = dao.etsi(kysymysID);

		List<Kysymys> kysymykset = new ArrayList<Kysymys>();
		kysymykset = dao.haeKaikki();

		Vastaus uusiVastaus = new VastausImpl();
		
		model.addAttribute("kysymys", kysymys);
		model.addAttribute("kysymykset", kysymykset);
		model.addAttribute("vastaus", uusiVastaus);
		return "naytaKysely";
	}

	// Vastaustietojen vastaanotto
	@RequestMapping(value = "/kysymysVastaanotto", method = RequestMethod.POST)
	public String getForm(
			@ModelAttribute(value = "vastaus") VastausImpl vastaus,
			BindingResult result) {

		vdao.talleta(vastaus);
		return "redirect:/";
	} */

}
