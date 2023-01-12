package com.example.CodingTask.exception;


/**
 * This class defines invalid field exception.
 * @author Taofeek Hammed
 * @since 12th Janury 2023
 */
public class InvalidFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidFieldException() {
		super();
	}

	public InvalidFieldException(String message) {
		super(message);
	}

	public InvalidFieldException(String message, Throwable cause) {
		super(message, cause);
	}
}

