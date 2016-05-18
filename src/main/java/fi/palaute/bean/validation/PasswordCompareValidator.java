package fi.palaute.bean.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fi.palaute.bean.Kayttaja;



public class PasswordCompareValidator implements ConstraintValidator<PasswordCompare, Object> {


	@Override
	public void initialize(PasswordCompare arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object henkilo, ConstraintValidatorContext context) {
		Kayttaja h = (Kayttaja) henkilo;
		return h.getSalasana().equals(h.getVertailu());
	}

}
