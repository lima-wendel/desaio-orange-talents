package com.vacinacaoBR.cadastro.domain.exceptionhandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.vacinacaoBR.cadastro.domain.exception.CadastroException;
import com.vacinacaoBR.cadastro.domain.exception.RespostaErro;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;


	@ExceptionHandler({DataIntegrityViolationException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RespostaErro handleAll(DataIntegrityViolationException ex, WebRequest webRequest) {
		String message = ex.getMessage();
		String campo = webRequest.getDescription(false);
		if (ex.getMessage().contains("email_uk")) {
			message = "Esse email já foi cadastrado, insira um email válido.";
			campo = "email";
		}
		if (ex.getMessage().contains("cpf_uk")) {
			message = "Esse cpf já foi cadastrado, insira um cpf válido.";
			campo = "cpf";
		}
		return new RespostaErro(campo, message);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<RespostaErro> handle(MethodArgumentNotValidException exception){
		List<RespostaErro> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			RespostaErro erro = new RespostaErro(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public CadastroException handleAll(Exception ex, WebRequest webRequest) {
		return new CadastroException(
				new Date(),
				ex.getMessage(),
				webRequest.getDescription(false));
	}
}