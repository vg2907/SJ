package com.vg.sj.exceptionhandler;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vg.sj.rest.WorkerNotFoundException;

/**
 * 
 * @author VG
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler({ WorkerNotFoundException.class })
	protected ResponseEntity<VndErrors> handleNotFoundEntity(final WorkerNotFoundException ex) {
		final ResponseEntity<VndErrors> error = error(ex, HttpStatus.NOT_FOUND, String.valueOf(ex.getId()));
		LOGGER.info(error.toString());
		return error;
	}

	private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
		final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
	}
}
