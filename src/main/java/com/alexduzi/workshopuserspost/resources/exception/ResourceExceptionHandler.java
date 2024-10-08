package com.alexduzi.workshopuserspost.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alexduzi.workshopuserspost.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// annotation para tratamento de exceções, podemos centralizar todo tratamento de exceção com essa classe
@ControllerAdvice
public class ResourceExceptionHandler {

	// tratamento de exceção específica para o ObjectNotFoundException
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado!", error.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
