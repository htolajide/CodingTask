package com.example.CodingTask.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CSVDataServiceImplTest {
    @Autowired
    private CSVDataService dataService;
    @Test
    void testDeleteDataByPrimaryKey() {

    }

    @Test
    void testLoadCSVData() throws FileNotFoundException, IOException {
        MultipartFile csvFile = new MockMultipartFile("data", "data.csv", "text/plain", new FileInputStream(new ClassPathResource("data.csv").getFile()));
        this.dataService.loadCSVData(csvFile);
        assertEquals(this.dataService.getDataByPrimaryKey("one").getName(), "Rice");
    }
}
