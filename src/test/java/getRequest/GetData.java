package getRequest;

// static com.jayway.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {

	@Test
	public void testResponsecode() {

//		Response resp = get(
		// "http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma");

		// int code = resp.getStatusCode(); */

		int code = get("http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
				.getStatusCode();
		System.out.println("Status code is " + code);
		Assert.assertEquals(code, 404);

	}

	@Test
	public void testbody() {

		String data = get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
						.asString();
		long time = get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbykeyword/?lang=en&section=Parents&key=asthma")
						.getTime();
		System.out.println("Data is " + data);
		System.out.println("Response time " + time + "ms");

	}

}
