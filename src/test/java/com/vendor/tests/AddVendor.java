package com.vendor.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddVendor {

	@Test
	public void addVendorTest() throws JSONException {
		RestAssured.baseURI = "http://10.81.69.76:8080/RestDemo5/api";
		RestAssured.basePath = "/vendors";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("vendorId", "Vendor537");
		jsonObject.put("vendorName", "LG");
		jsonObject.put("vendorAddress", "Mysuru");
		jsonObject.put("vendorPhoneNumber", "1010101010");

		request.body(jsonObject.toString());
		Response response = request.post();

		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);

		Assert.assertEquals(response.getStatusCode(), 201, "Status code check failed!");
		Assert.assertTrue(response.getStatusLine().contains("201"), "Status line check failed!");
		Assert.assertTrue(responseBody.contains("InfosysMysuru"), "Vendor Name mismatch!");
		Assert.assertTrue(responseBody.contains("Mysuru"), "Address mismatch!");
		Assert.assertTrue(responseBody.contains("1010101010"), "Phone Number mismatch!");
	}
}
