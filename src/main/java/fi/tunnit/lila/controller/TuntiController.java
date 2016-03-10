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
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.ProjektiDAO;
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.bean.TunnitImpl;
import fi.tunnit.lila.dao.TunnitDAO;




@Controller






@RequestMapping (value="/tunnit")

public class TuntiController {

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
	
	//FORMIN TEKEMINEN
		@RequestMapping(value="uusi", method=RequestMethod.GET)
		public String getCreateForm(Model model) {
			Tunnit uusiTunti = new TunnitImpl();
			uusiTunti.setDate("");
			
			model.addAttribute("tunti", uusiTunti);
			return "tunnit/lisaaTunti";
		}
		
		
		
		
		
		
		//FORMIN TIETOJEN VASTAANOTTO
		@RequestMapping(value="uusi", method=RequestMethod.POST)
		public String create( @ModelAttribute(value="tunti") TunnitImpl tunti) {
			tdao.talleta(tunti);
			return "tunnit/lisaaTunti";
		}
		
		//HAE KAIKKI TUNNIT
				@RequestMapping(value="lista", method=RequestMethod.GET)
				public String showLista(Model modelAll) {
				
					List <Tunnit> tunnit = new ArrayList<Tunnit>();
					tunnit = tdao.haeTunnit();
					
					modelAll.addAttribute("tunnit", tunnit);
					return "tunnit/listaaTunnit";
				}
				
				//POISTA KÄYTTÄJÄ

				 @RequestMapping(value = "delete/{tuntiID}", method = RequestMethod.GET)
				    public String showDelete(@PathVariable("tuntiID") Integer tuntiID) {
					tdao.poistaTunti(tuntiID);
					return "tunnit/lista";
				        
				    }
		
}
