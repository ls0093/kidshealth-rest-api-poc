package getRequest;

import static io.restassured.RestAssured.given;

import org.apache.commons.mail.EmailException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.SendEmail;
import util.TestUtil;

public class KhApiTest {

	String myUrl = "http://kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData("data");
		return data;
	};

	@Test // (dataProvider = "getTestData")
	public void sendWithHeader1() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl).then()
				.statusCode(200);
		System.out.println("URL: " + myUrl + "Test: " + test);
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("=======Before Class has started=========");
	}

	@AfterMethod
	public void afterClass(ITestResult result) throws EmailException, InterruptedException {
		// Thread.sleep(2000);
		/*
		 * if (result.getStatus() == ITestResult.FAILURE) { SendEmail.sendMail();
		 * System.out.println("The test failed and email sent"); }
		 */
		SendEmail.sendMail();
		System.out.println("==========The test failed and email sent===========");
	}

}
