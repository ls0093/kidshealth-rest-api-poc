package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testVerifyHeader {

	@Test
	public void GetWeatherHeaders() {

		RestAssured.baseURI = "http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";
		// RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);

		// Reader header of a give name. In this line we will get
		// Header named Server
		String serverType = response.header("Server");
		System.out.println("Server value: " + serverType);

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);

		String dDate = response.header("Date");
		System.out.println("Date: " + dDate);

		String via = response.header("Via");
		System.out.println("Via: " + via);

		String connection = response.header("Connection");
		System.out.println("Connection: " + connection);
	}

	@Test
	public void loopallheader() {

		RestAssured.baseURI = "http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";
		// RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		Headers allHeaders = response.headers();

		// Iterate over all the Headers
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
	}

	@Test
	public void validateResponseData() {
		RestAssured.baseURI = "http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "text/html;charset=utf-8" /* expected value */);

		// Reader header of a give name. In this line we will get
		// Header named Server
		String serverType = response.header("Server");
		Assert.assertEquals(serverType /* actual value */,
				"Apache/2.4.6 (Unix) mod_jk/1.2.37 PHP/5.5.1 OpenSSL/1.0.1e mod_fcgid/2.3.9" /* expected value */);

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String via = response.header("Via");
		Assert.assertEquals(via /* actual value */,
				"1.1 wlmwsamgt002.nemours.org:80 (Cisco-WSA/11.5.1-124)" /* expected value */);
	}

}