package fi.palaute.bean.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import fi.palaute.dao.KayttajaDAO;


public class UniqueTunnusValidator implements ConstraintValidator<UniqueTunnus, String> {

	@Autowired
	private KayttajaDAO dao;
	
	
	@Override
	public void initialize(UniqueTunnus arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return dao.etsiSposti(value) == null;
		
	}

}
