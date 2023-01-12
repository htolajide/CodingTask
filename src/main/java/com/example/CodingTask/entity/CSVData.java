package com.example.CodingTask.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * This class defines the CSVDate entity.
 * @author Taofeek Hammed
 * @since 12th Janury 2023
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CSVData {
	@Id
	@NotNull
	@NotEmpty
	private String primaryKey;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String description;
	private ZonedDateTime updatedTimestamp;
}
