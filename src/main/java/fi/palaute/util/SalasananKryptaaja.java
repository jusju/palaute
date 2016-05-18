package fi.palaute.util;

import org.springframework.security.crypto.password.StandardPasswordEncoder;


public class SalasananKryptaaja {
	
	public String kryptattuna (String salasana) {
		
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		
		String krypt = spe.encode(salasana);
		
		return krypt;
	}

}
