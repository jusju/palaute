package fi.palaute.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.palaute.bean.Kayttaja;
import fi.palaute.bean.KayttajaImpl;
import fi.palaute.bean.Poletti;
import fi.palaute.bean.PolettiImpl;
import fi.palaute.dao.KayttajaDAO;
import fi.palaute.dao.PolettiDAO;
import fi.palaute.util.SpostiLahetys;

@Controller
@RequestMapping(value = "/nollaus")
public class PolettiController {

	@Inject
	private PolettiDAO pdao;

	@Inject
	private KayttajaDAO dao;
	
	@Autowired
	private SpostiLahetys sposti;

	public KayttajaDAO getDao() {
		return dao;
	}

	public void setDao(KayttajaDAO dao) {
		this.dao = dao;
	}

	public PolettiDAO getPdao() {
		return pdao;
	}

	public void setPdao(PolettiDAO pdao) {
		this.pdao = pdao;
	}

	// FORMIN TEKEMINEN
	@RequestMapping(value = "resetPassword", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kayttaja tyhjaKayttaja = new KayttajaImpl();

		model.addAttribute("kayttaja", tyhjaKayttaja);
		return "unohditkoSalasanasi";
	}

	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public String salasananNollaus(HttpServletRequest request,
			@RequestParam("tunnus") String userTunnus, Model model) {

		Kayttaja kayttaja = dao.etsiSposti(userTunnus.toLowerCase());
		if (kayttaja == null) {
			String error = "Käyttäjää ei löydy";
			model.addAttribute("error", error);
			return "unohditkoSalasanasi";
		}

		String satunnainen = UUID.randomUUID().toString();

		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar
				.getInstance().getTime());
		Poletti poletti = new PolettiImpl();

		poletti.setKaytID(kayttaja.getId());
		poletti.setSatunnainen(satunnainen);
		poletti.setPvm(timeStamp);
		pdao.poistaPoletti(kayttaja.getId());
		pdao.tallenna(poletti);

		String appUrl = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/"
				+ "nollaus/" + "resetPassword/" + satunnainen;
		

		String subject = "Unohdetun salasanan nollauslinkki";
		sposti.sendMail(userTunnus+"@myy.haaga-helia.fi", subject, appUrl);
		
		String thanks = "Nollauslinkki on lähetetty teidän sähköpostiin";
	
		model.addAttribute("thanks", thanks);

		return "thanksSivu";

	}
	


	//Poletti linkin avaus ja tarkistus
	@RequestMapping(value = "resetPassword/{satunnainen}", method = RequestMethod.GET)
	public String getPoletti(@PathVariable String satunnainen, Model modelAll) {

		List<Poletti> poletti = new ArrayList<Poletti>();
		poletti = pdao.haeKaikki();
		
		for(int i = 0; i<poletti.size(); i++){
			System.out.println(poletti.get(i).getSatunnainen());
			if(poletti.get(i).getSatunnainen().equals(satunnainen)){
				return "redirect:/kayttaja/uusisalasana/"+satunnainen;
			}
			
		}
		return "virhesivu";
	}


}
