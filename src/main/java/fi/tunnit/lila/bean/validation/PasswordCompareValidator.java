package fi.tunnit.lila.bean.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fi.tunnit.lila.bean.Henkilo;



public class PasswordCompareValidator implements ConstraintValidator<PasswordCompare, Object> {


	@Override
	public void initialize(PasswordCompare arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object henkilo, ConstraintValidatorContext context) {
		Henkilo h = (Henkilo) henkilo;
		return h.getSalasana().equals(h.getVertailu());
	}

}
