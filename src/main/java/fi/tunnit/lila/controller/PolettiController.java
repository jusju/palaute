package fi.tunnit.lila.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.Poletti;
import fi.tunnit.lila.bean.PolettiImpl;
import fi.tunnit.lila.dao.HenkiloDAO;
import fi.tunnit.lila.dao.HenkiloaEiLoydyPoikkeus;
import fi.tunnit.lila.dao.PolettiDAO;
import fi.tunnit.lila.dao.ProjektiDAO;

@Controller
@RequestMapping(value="/nollaus")

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
	
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)

	public String salasananNollaus(
	  HttpServletRequest request, @RequestParam("email") String userEmail) {
	     
	    Henkilo henkilo = dao.etsiSposti(userEmail);
	    if (henkilo == null) {
	        Exception e = null;
			throw new HenkiloaEiLoydyPoikkeus(e);
	    }
	 
	    String satunnainen = UUID.randomUUID().toString();
	    String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	    Poletti poletti = new PolettiImpl();
	    
	    poletti.setKaytID(henkilo.getId());
	    poletti.setSatunnainen(satunnainen);
	    poletti.setPvm(timeStamp);
	    
	    pdao.tallenna(poletti);

	    String appUrl = 
	      "http://" + request.getServerName() + 
	      ":" + request.getServerPort() + 
	      request.getContextPath();
		return appUrl;
	    
	   /* SimpleMailMessage email = 
	      constructResetTokenEmail(appUrl, request.getLocale(), satunnainen);
	    mailSender.send(email);*/

	}

}
