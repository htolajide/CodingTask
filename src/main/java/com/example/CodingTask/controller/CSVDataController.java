package com.example.CodingTask.controller;

import java.io.IOException;

import com.example.CodingTask.entity.CSVData;
import com.example.CodingTask.service.CSVDataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/csv-data")
public class CSVDataController {
	@Autowired
	private CSVDataServiceImpl csvDataServiceImpl;

	@PostMapping
	public ResponseEntity<String> loadCSVData(@RequestPart MultipartFile csvFile) throws IOException{
		this.csvDataServiceImpl.loadCSVData(csvFile);
		String response = "CSV data loaded succesfully";
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<CSVData> getDataByPrimaryKey(@RequestParam("pk") String primarKey) {
		CSVData response = this.csvDataServiceImpl.getDataByPrimaryKey(primarKey);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleDataByPrimarykey(@RequestParam("pk") String primaryKey){
		this.csvDataServiceImpl.deleteDataByPrimaryKey(primaryKey);
		String response = "Data deleted for primary key " + primaryKey;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
