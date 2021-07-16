package br.com.zupacademy.gabriel.proposta.config.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;
import feign.FeignException.FeignClientException;

@RestControllerAdvice
public class ExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ProblemResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		List<ProblemResponse> response = new ArrayList<>();

		fieldErrors.forEach(erro -> {
			String message = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			ProblemResponse problem = new ProblemResponse(erro.getField(), message, LocalDateTime.now());
			response.add(problem);
		});

		return response;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
	public ProblemResponse handleIllegalArgument(IllegalArgumentException exception) {
		
	ProblemResponse response = new ProblemResponse(exception.getLocalizedMessage(), exception.getMessage(), LocalDateTime.now());
		return response;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(FeignException.class)
	public ProblemResponse handleFeignException(FeignClientException e) {
		
		ProblemResponse response = new ProblemResponse(e.getMessage(), e.getMessage(), LocalDateTime.now());
		return response;
	}

}
