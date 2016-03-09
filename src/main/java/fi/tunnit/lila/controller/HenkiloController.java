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
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.bean.TunnitImpl;
import fi.tunnit.lila.dao.TunnitDAO;




@Controller






@RequestMapping (value="/tunnit")

public class HenkiloController {

	@Inject
	
	private TunnitDAO tdao;
	
	@Inject
	private HenkiloDAO dao;

	
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
	
	//FORMIN TEKEMINEN
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Henkilo tyhjaHenkilo = new HenkiloImpl();
		tyhjaHenkilo.setEtunimi("oletusetunimi");
		
		model.addAttribute("henkilo", tyhjaHenkilo);
		return "kayttaja/lisaaKayttaja";
	}
	
	
	
	
	
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="henkilo") HenkiloImpl henkilo) {
		dao.talleta(henkilo);
		return "redirect:/tunnit/" + henkilo.getId();
	}
	//POISTA KÄYTTÄJÄ
	 @RequestMapping(value = "lista/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Henkilo> poistaKayt(@PathVariable("id") int id) {
	        System.out.println("Poistetaan käyttäjä " + id);
	 
	        Henkilo henkilo = dao.etsi(id);
	        if (henkilo == null) {
	            System.out.println("Tyhjä ID " + id + " ei löydy");
	            return new ResponseEntity<Henkilo>(HttpStatus.NOT_FOUND);
	        }
	 
	        dao.poistaHenkilo(id);
	        return new ResponseEntity<Henkilo>(HttpStatus.NO_CONTENT);
	    }

	
	//TUNNIN TIETOJEN NÄYTTÄMINEN
	
		@RequestMapping(value="ttunti/{tuntiID}", method=RequestMethod.GET)
		public String getTunti(@PathVariable Integer tuntiID, Model model) {
			Tunnit tunnit = tdao.etsiTunti(tuntiID);
			model.addAttribute("tunnit", tunnit);

			return "tunti/tunninTiedot";
		}
	
	
	
	//HAE KAIKKI OIKEA
	@RequestMapping(value="lista", method=RequestMethod.GET)
	public String showList(Model modelAll) {
	
		List <Henkilo> henkilot = new ArrayList<Henkilo>();
		henkilot = dao.haeKaikki();
		
		modelAll.addAttribute("henkilot", henkilot);
		return "kayttaja/listaaKayttajat";
	}


	//HAE KAIKKI TUNNIT
		@RequestMapping(value="listaus", method=RequestMethod.GET)
		public String showLista(Model modelAll) {
		
			List <Tunnit> tunnit = new ArrayList<Tunnit>();
			tunnit = tdao.haeTunnit();
			
			modelAll.addAttribute("tunnit", tunnit);
			return "kayttaja/listaaTunnit";
		}
		
		//HENKILÖN TIETOJEN NÄYTTÄMINEN
		@RequestMapping(value="ktunti/{id}", method=RequestMethod.GET)
		public String getView(@PathVariable Integer id, Model model) {
			Henkilo henkilo = dao.etsi(id);
			model.addAttribute("henkilo", henkilo);
			
			List <Tunnit> tunnit = new ArrayList<Tunnit>();
			tunnit = tdao.etsi(id);
			
			model.addAttribute("tunnit", tunnit);
			return "kayttaja/naytaKayttaja";
		}
		
		/*
	//POISTA KÄYTTÄJÄ

		 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		    public ResponseEntity<Henkilo> poistaKayttaja(@PathVariable("id") Integer id) {
		        System.out.println("Fetching & Deleting User with id " + id);
		 
		        Henkilo henkilo = dao.etsi(id);
		        if (henkilo == null) {
		            System.out.println("Unable to delete. User with id " + id + " not found");
		            return new ResponseEntity<Henkilo>(HttpStatus.NOT_FOUND);
		        }
		 
		        dao.poistaHenkilo(id);
		        return new ResponseEntity<Henkilo>(HttpStatus.NO_CONTENT);
		    }*/

}
