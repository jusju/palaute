package fi.tunnit.lila.bean.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import fi.tunnit.lila.dao.HenkiloDAO;


public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private HenkiloDAO dao;
	
	
	@Override
	public void initialize(UniqueEmail arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return dao.etsiSposti(value) == null;
		
	}

}
