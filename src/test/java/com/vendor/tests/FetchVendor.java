package com.vendor.tests;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class FetchVendor {

	@Test
	public void verifyVendorDetails() {

		RestAssured.baseURI = "http://10.81.69.76:8080/RestDemo5/api";
		RestAssured.basePath = "/vendors";
		Response response = RestAssured.given().queryParam("vendorId", "Vendor4").when().get();

		Assert.assertEquals(response.getStatusCode(), 200, "Status Code Mismatch!");
		Assert.assertTrue(response.getStatusLine().contains("200"), "Status Line Mismatch!");
		Assert.assertNotNull(response.getContentType(), "Content Type is null!");

		String body = response.asString();
		Assert.assertTrue(body.contains("vendorId"), "Field 'id' missing");
		Assert.assertTrue(body.contains("vendorName"), "Field 'vendorName' missing");
		Assert.assertTrue(body.contains("vendorAddress"), "Field 'vendorAddress' missing");
		Assert.assertTrue(body.contains("vendorPhoneNumber"), "Field 'vendorPhoneNumber' missing");
		Assert.assertTrue(body.contains("LG"), "Response does not contain 'LG'");

		System.out.println("--- All Response Headers ---");
		System.out.println(response.getHeaders().toString());
	}
}
