package com.vendor.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VendorSteps {
	Response response;
	String vendorName;

	@Given("The user initiates a GET request to the Vendor URL")
	public void the_user_initiates_a_GET_request_to_the_Vendor_URL() {
		RestAssured.baseURI = "http://10.81.69.76:8080/RestDemo5/api";
		RestAssured.basePath = "/vendors";
		response = RestAssured.given().queryParam("vendorId", "Vendor1").when().get();
	}

	@When("The user Fetches the VendorName from the response")
	public void the_user_Fetches_the_VendorName_from_the_response() {
		vendorName = response.jsonPath().getString("vendorName");
	}

	@Then("validate that the Vendor Name is IBM and status code {int}")
	public void validate_that_the_Vendor_Name_is_IBM_and_status_code(Integer int1) {
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(vendorName, "IBM");
	}
}
