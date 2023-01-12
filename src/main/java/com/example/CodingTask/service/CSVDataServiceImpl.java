package com.example.CodingTask.service;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import com.example.CodingTask.entity.CSVData;
import com.example.CodingTask.exception.InvalidFieldException;
import com.example.CodingTask.exception.ResourceNotFoundException;
import com.example.CodingTask.repository.CSVDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class defines the CSVDataAervice Implementation.
 * @author Taofeek Hammed
 * @since 12th Janury 2023
 */
@Service
@Transactional
@Slf4j
@Validated
public class CSVDataServiceImpl implements CSVDataService {
	@Autowired
	private CSVDataRepository csvDataRepository;

	public void  loadCSVData(MultipartFile csvFile) throws IOException {
		log.info("Loading file....");
			File file = convertMultipartToFile(csvFile);
			if (!file.getName().contains(".csv")) {
				throw new InvalidFieldException("file provided is not a csv file");
			}
			String lineData = "";
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
				int lineCounter = 0;
				while ((lineData = bufferedReader.readLine()) != null) {
					//ignore the header 
					log.info("Reading lines...");
					if (lineCounter > 0) {
						//split line by comma
						String[] linePart = lineData.split(",");
						String primaryKey = linePart[0];
						String name = linePart[1];
						String description = linePart[2];
						ZonedDateTime updateTime = null;
						if (linePart.length > 3)  {
							String updatedTimestamp = linePart[3];
							if(!(updatedTimestamp.isEmpty()) || !(updatedTimestamp.isBlank())) {
								updateTime = ZonedDateTime.parse(updatedTimestamp);
							}
						}
						CSVData csvData = CSVData.builder()
							.primaryKey(primaryKey)
							.name(name)
							.description(description)
							.updatedTimestamp(updateTime)
								.build();
						this.csvDataRepository.save(csvData);
						
					}
					lineCounter += 1;
				}
				log.info("CSV Data Loaded");
			}
			catch(IOException ex) {
				log.error("Something went wrong {}", ex.getMessage());
				throw new IOException(ex.getMessage());
			}
	}

	public CSVData getDataByPrimaryKey(String primarykey) {
		log.info("getting data...");
		CSVData response = this.csvDataRepository.findById(primarykey)
			.orElseThrow(() -> new ResourceNotFoundException("Data not found for primaty key " + primarykey));
			log.info("Data loaded");
			return response;
	}

	public void deleteDataByPrimaryKey(String primary) {
		log.info("deleting....");
		this.csvDataRepository.deleteById(primary);
		log.info("Data deleted");
	}

	private File convertMultipartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}
