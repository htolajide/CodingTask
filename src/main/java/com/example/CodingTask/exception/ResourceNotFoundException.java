
package com.example.CodingTask.exception;


/**
 * This class defines the resource not found exception.
 * @author Taofeek Hammed
 * @since 12th Janury 2023
 */
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
