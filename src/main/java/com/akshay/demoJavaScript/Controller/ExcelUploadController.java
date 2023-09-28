package com.akshay.demoJavaScript.Controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.akshay.demoJavaScript.Model.ExcelData;
import com.akshay.demoJavaScript.Repo.ExcelDataRepository;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestController

public class ExcelUploadController {
	
	@Autowired
    private ExcelDataRepository excelDataRepository;
	
	
	
	@PostMapping("/upload")
	public String uploadExcel(@RequestParam("file") MultipartFile file) throws InvalidFormatException {
		
		try(InputStream inputStream = file.getInputStream()){
			Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            
            for(Row row : sheet) {
            	ExcelData excelData = new ExcelData();
                excelData.setName(row.getCell(0).getStringCellValue());
                excelData.setEmail(row.getCell(1).getStringCellValue());
                excelDataRepository.save(excelData);
            }
		}catch(IOException | EncryptedDocumentException e) {
			e.printStackTrace();
            return "Error uploading Excel file";
		}
		return "Excel file uploaded and data saved to the database";
	}
	
	
	
}

