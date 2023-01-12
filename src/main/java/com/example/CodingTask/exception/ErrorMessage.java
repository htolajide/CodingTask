package com.example.CodingTask.exception;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * This class defines the Error message from exceptions.
 * @author Taofeek Hammed
 * @since 12th Janury 2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {

	/**
	 * This field defines error status code.
	 */
	private int statusCode;

	/**
	 * This field defines exception type.
	 */
	private String exception;

	/**
	 * This field defines error message.
	 */
	private String message;

	/**
	 * This field defines error description.
	 */
	private String description;

	/**
	 * This field defines error timestamp.
	 */
	@Builder.Default
	private ZonedDateTime timestamp = ZonedDateTime.now();

}
