package com.example.CodingTask.repository;

import com.example.CodingTask.entity.CSVData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class defines the CSVDataRepositpry.
 * @author Taofeek Hammed
 * @since 12th Janury 2023
 */
@Repository
public interface CSVDataRepository extends JpaRepository<CSVData, String>{

}
