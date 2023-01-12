package com.example.CodingTask.exception;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * This class defines exception handling controller.
 * @author Taofeek Hammed
 * @since 12th January 2023
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage badRequestExceptionHandler(IllegalArgumentException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(IOException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage IORequestExceptionHandler(IOException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage numberFormatExceptionHandler(NumberFormatException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleFieldValidationError(BindException ex, WebRequest request) {
		// Retrieve Binding error from method argument exception.
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(getFieldError(error))
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex, WebRequest request) {
		// Retrieve Binding error from method argument exception.
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(getFieldError(error))
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(InvalidFieldException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage InvalidFieldExceptionHandler(InvalidFieldException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage dataIntegrityExceptionHandler(DataIntegrityViolationException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage httpMediaTypeSupportExceptionHandler(HttpMediaTypeNotSupportedException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message("Media file resources content not present")
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(MissingServletRequestPartException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage missingServletRequestPartExceptionHandler(MissingServletRequestPartException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage illegalStateExceptionHandler(IllegalStateException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage maxUploadExceptionHandler(MaxUploadSizeExceededException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(InvalidDataAccessResourceUsageException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage inalidDataAccessUsagaExceptionHandler(InvalidDataAccessResourceUsageException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(NoSuchAlgorithmException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage noSuchAlgorithmExceptionHandler(NoSuchAlgorithmException ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		return message;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage serverExceptionHandler(Exception ex, WebRequest request) {
		ErrorMessage message = ErrorMessage.builder()
			.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
			.exception(ex.toString())
			.message(ex.getMessage())
			.description(request.getDescription(false)).build();
		ex.printStackTrace();
		return message;
	}

	// method to process field error
	private String getFieldError(final FieldError error) {
		String message = "";
		if (error != null) {
			Locale currentLocale = LocaleContextHolder.getLocale();
			message = this.messageSource.getMessage(error.getDefaultMessage(), null, currentLocale);
		}
		return message;
	}
}
