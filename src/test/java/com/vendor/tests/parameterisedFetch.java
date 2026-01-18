package com.vendor.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class parameterisedFetch {

	@Test
	public void testVendors() throws IOException {
		String path = "C:\\Users\\mudit.gupta06\\Desktop\\Capstone_Project_RestAssured\\Vendors\\src\\test\\resources\\te";

		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");

		int rows = sheet.getLastRowNum();
		for (int i = 1; i <= rows; i++) {

			String vendorId = sheet.getRow(i).getCell(0).getStringCellValue();

			RestAssured.baseURI = "http://10.81.69.76:8080/RestDemo5/api";
			RestAssured.basePath = "/vendors";
			Response response = RestAssured.given().queryParam("vendorId", vendorId).when().get();

			String responseBody = response.getBody().asString();
			System.out.println("Response for " + vendorId + ": " + responseBody);
		}

		book.close();
		fis.close();
	}
}
