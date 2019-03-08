package getRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class SendWithHeader {

	@Test
	public void sendWithHeader() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
				.then().statusCode(200);
	}

	@Test
	public void sendWithHeader1() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("https://kidshealth.org/ws/AmericanFamily/en/parents/infections/").then().statusCode(200);
	}

	@Test
	public void sendWithHeader2() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("https://kidshealth.org/ws/AmericanFamily/en/parents/amblyopia.html/").then().statusCode(200);
	}

	@Test
	public void sendWithHeader3() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=es&section=Parents&key=¿Qué es unainfección de oído%3F")
				.then().statusCode(200);
	}

	@Test
	public void sendWithHeader4() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?key=food allergy&count=40").then()
				.statusCode(200);
	}

	@Test
	public void sendWithHeader5() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Kids&key=blood")
				.then().statusCode(200);
	}

	@Test
	public void sendWithHeader6() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
				.then().statusCode(200);
	}

	@Test
	public void sendWithHeader7() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
				.then().statusCode(200);
	}

	@Test
	public void sendWithHeader8() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
				.then().statusCode(200);
	}

	@Test
	public void sendWithHeader9() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
				.then().statusCode(200);
	}

	@Test
	public void sendWithHeader10() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when()
				.get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
				.then().statusCode(200);
	}
}
