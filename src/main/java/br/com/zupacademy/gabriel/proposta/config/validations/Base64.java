package br.com.zupacademy.gabriel.proposta.config.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {Base64Validator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Base64 {

	String message() default "valor do campo não está em formato base64";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	String fieldName();

}
