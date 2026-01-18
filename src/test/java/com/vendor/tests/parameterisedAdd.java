package com.vendor.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class parameterisedAdd {

	@Test
	public void testVendorApi() throws IOException, JSONException {

		RestAssured.baseURI = "http://10.81.69.76:8080/RestDemo5/api";
		RestAssured.basePath = "/vendors";

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");

		String path = "C:\\Users\\mudit.gupta06\\Desktop\\Capstone_Project_RestAssured\\Vendors\\src\\test\\resources\\testData\\Update_Vendor.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		int rows = sheet.getLastRowNum();

		for (int i = 1; i <= rows; i++) {

			String vId = sheet.getRow(i).getCell(0).getStringCellValue();
			String vName = sheet.getRow(i).getCell(1).getStringCellValue();
			String vAddress = sheet.getRow(i).getCell(2).getStringCellValue();
			String vPhone = sheet.getRow(i).getCell(3).getRawValue();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("vendorId", vId);
			jsonObject.put("vendorName", vName);
			jsonObject.put("vendorAddress", vAddress);
			jsonObject.put("vendorPhoneNumber", vPhone);

			requestSpecification.body(jsonObject.toString());

			Response response = requestSpecification.post();

			System.out.println("Status Line: " + response.getStatusLine());
			System.out.println("Response Body: " + response.getBody().asString());

			sheet.getRow(i).createCell(4).setCellValue(response.getStatusCode());
		}

		fis.close();
		FileOutputStream fos = new FileOutputStream(path);
		book.write(fos);
		fos.close();
		book.close();
	}
}
