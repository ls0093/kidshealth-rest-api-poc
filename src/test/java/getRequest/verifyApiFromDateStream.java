package getRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class verifyApiFromDateStream {

	String myUrl = "http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";

	@Test
	public void sendWithHeader1() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("https://kidshealth.org/ws/AmericanFamily/en/parents/infections/").then().statusCode(200);
	}

	@Test
	public void validateArticleTitle() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl).then().assertThat()
				.body("kharticles.kharticle.article_title[0]", equalTo("Girls and Puberty"));
	}

	@Test
	public void validateResponseHeader() {
		RestAssured.baseURI = "http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(myUrl);

		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		// String contentType = response.header("Content-Type");
		// Assert.assertEquals(contentType /* actual value */, "text/html;charset=utf-8"
		// /* expected value */);

		// Reader header of a give name. In this line we will get
		// Header named Server
		String AccessControlAllowOrigin = response.header("Access-Control-Allow-Origin");
		Assert.assertEquals(AccessControlAllowOrigin /* actual value */, "*" /* expected value */);

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String via = response.header("Via");
		Assert.assertEquals(via /* actual value */,
				"1.1 wlmwsamgt002.nemours.org:80 (Cisco-WSA/11.5.1-124)" /* expected value */);
	}

}
