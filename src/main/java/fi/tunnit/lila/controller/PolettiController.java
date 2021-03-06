package fi.tunnit.lila.controller;

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

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.HenkiloImpl;
import fi.tunnit.lila.bean.Poletti;
import fi.tunnit.lila.bean.PolettiImpl;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.PolettiDAO;
import fi.tunnit.lila.util.SpostiLahetys;

@Controller
@RequestMapping(value = "/nollaus")
public class PolettiController {

	@Inject
	private PolettiDAO pdao;

	@Inject
	private HenkiloDAO dao;
	
	@Autowired
	private SpostiLahetys sposti;

	public HenkiloDAO getDao() {
		return dao;
	}

	public void setDao(HenkiloDAO dao) {
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
		Henkilo tyhjaHenkilo = new HenkiloImpl();

		model.addAttribute("henkilo", tyhjaHenkilo);
		return "unohditkoSalasanasi";
	}

	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public String salasananNollaus(HttpServletRequest request,
			@RequestParam("email") String userEmail, Model model) {

		Henkilo henkilo = dao.etsiSposti(userEmail);
		if (henkilo == null) {
			String error = "Henkilo� ei l�ydy";
			model.addAttribute("error", error);
			return "unohditkoSalasanasi";
		}

		String satunnainen = UUID.randomUUID().toString();

		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar
				.getInstance().getTime());
		Poletti poletti = new PolettiImpl();

		poletti.setKaytID(henkilo.getId());
		poletti.setSatunnainen(satunnainen);
		poletti.setPvm(timeStamp);
		pdao.poistaPoletti(henkilo.getId());
		pdao.tallenna(poletti);

		String appUrl = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/"
				+ "nollaus/" + "resetPassword/" + satunnainen;
		

		String subject = "Unohdetun salasanan nollauslinkki";
		sposti.sendMail(userEmail, subject, appUrl);
		
		String thanks = "Nollauslinkki on l�hetetty teid�n s�hk�postiin";
	
		model.addAttribute("thanks", thanks);

		return "thanksSivu";

		/*
		 * SimpleMailMessage email = constructResetTokenEmail(appUrl,
		 * request.getLocale(), satunnainen); mailSender.send(email);
		 */

	}
	


	//Poletti linkin avaus ja tarkistus
	@RequestMapping(value = "resetPassword/{satunnainen}", method = RequestMethod.GET)
	public String getPoletti(@PathVariable String satunnainen, Model modelAll) {

		List<Poletti> poletti = new ArrayList<Poletti>();
		poletti = pdao.haeKaikki();
		
		for(int i = 0; i<poletti.size(); i++){
			System.out.println(poletti.get(i).getSatunnainen());
			if(poletti.get(i).getSatunnainen().equals(satunnainen)){
				return "redirect:/henkilo/uusisalasana/"+satunnainen;
			}
			
		}
		return "virhesivu";
	}
	/*
	// HAE KAIKKI TUNNIT
		@RequestMapping(value = "resetPassword/{satunnainen}", method = RequestMethod.GET)
		public String showLista(@PathVariable int polettiID, Model modelAll) {

			List<Poletti> poletti = new ArrayList<Poletti>();
			poletti = pdao.etsiS(polettiID);
			System.out.println(polettiID);
			modelAll.addAttribute("poletti", poletti);
			System.out.println(polettiID);
			return "lisaaSalasana";
		}*/



}
