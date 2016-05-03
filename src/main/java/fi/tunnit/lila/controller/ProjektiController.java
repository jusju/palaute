package fi.tunnit.lila.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.tree.RowMapper;

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
import fi.tunnit.lila.bean.ProjektiImpl;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.ProjektiDAO;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.bean.TunnitImpl;
import fi.tunnit.lila.dao.TunnitDAO;




@Controller






@RequestMapping (value="/projektit")

public class ProjektiController {

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
	
	
	
	// HAE KAIKKI PROJEKTIT
		@RequestMapping(value = "lista", method = RequestMethod.GET)
		public String showLista(Model modelAll) {

			List<Projekti> projektit = new ArrayList<Projekti>();
			projektit = pdao.haeKaikki();

			modelAll.addAttribute("projektit", projektit);
			return "projekti/listaaProjektit";
		}
		/*
		// FORMIN TEKEMINEN
				@RequestMapping(value = "delete", method = RequestMethod.GET)
				public String getLuoForm(Model model) {
					Projekti uusiProjekti = new ProjektiImpl();
					

					model.addAttribute("projekti", uusiProjekti);
					return "projekti/lisaaProjekti";
				}

				// FORMIN TIETOJEN VASTAANOTTO
				@RequestMapping(value = "delete", method = RequestMethod.POST)
				public String Poista(@ModelAttribute(value = "projekti") ProjektiImpl projekti) {
					pdao.talleta(projekti);
					return "redirect:/projektit/lista";
				}
		*/
		

		
		
		
		
		
}
