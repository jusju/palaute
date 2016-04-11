package fi.tunnit.lila.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.HenkiloaEiLoydyPoikkeus;
import fi.tunnit.lila.dao.PolettiDAO;

@Controller
@RequestMapping(value = "/nollaus")
public class PolettiController {

	@Inject
	private PolettiDAO pdao;

	@Inject
	private HenkiloDAO dao;

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
			String error = "Henkiloä ei löydy";
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
		pdao.tallenna(poletti);

		String appUrl = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/"
				+ "nollaus/" + "resetPassword/" + satunnainen;
		model.addAttribute("appUrl", appUrl);

		return "nollausLinkki";

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


		modelAll.addAttribute("poletti", poletti);

		System.out.println(satunnainen + poletti);
		return "lisaaSalasana";
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
