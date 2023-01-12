package com.example.CodingTask.service;

import java.io.IOException;

import com.example.CodingTask.entity.CSVData;

import org.springframework.web.multipart.MultipartFile;

/**
 * This class defines the CSVData Service.
 * @author Taofeek Hammed
 * @since 12th Janury 2023
 */
public interface CSVDataService {
	/**
	 * This method define loadCSVData.
	 * @param csvFile to load
	 * @return CSVData Loaded
	 * @throws IOExeption
	 */
public void loadCSVData(MultipartFile csvFile) throws IOException;
	/**
	 * This method define deleteDataByPrimaryKey.
	 * @param primarykey to delete
	 */
	public void deleteDataByPrimaryKey(String primaryKey);
	/**
     * This method define fet CSVData by primarkey.
     * @param primrykey to get 
     * @return CSVData Loaded
     */
	public CSVData getDataByPrimaryKey(String primaryKey);
}
