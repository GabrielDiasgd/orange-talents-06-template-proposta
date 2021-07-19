package br.com.zupacademy.gabriel.proposta.config.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Base64Validator implements ConstraintValidator<Base64, String>  {

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 String pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
		    Pattern r = Pattern.compile(pattern);
		    Matcher m = r.matcher(value);
		    if (m.find()) {
		        return true;
		    } else {
		      return false;
		    }
		
	}

}
