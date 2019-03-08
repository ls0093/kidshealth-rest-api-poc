package getRequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.apache.commons.mail.EmailException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.SendEmail;

public class validateApiTest {

	static ExtentTest test;
	static ExtentReports report;

	String myUrl = "http://kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";

	/*
	 * @DataProvider public Object[][] getTestData() { Object data[][] =
	 * TestUtil.getTestData("collectionData1"); return data; };
	 */

	// @Test(dataProvider = "getTestData")
	// public void sendWithHeader1(String myUrl) {
	@Test
	public void validateResponseCode200() {
		test.log(LogStatus.INFO, "Starting the test: " + myUrl);
		test = report.startTest("validateResponseCode200");
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl).then()
				.statusCode(200);
		/*
		 * if (result.getStatus() == ITestResult.SUCCESS) { test.log(LogStatus.PASS,
		 * "Response was successful for 200 status: "); } else {
		 * test.log(LogStatus.FAIL, "Response was NOT successful for 200 status: "); }
		 */
		test.log(LogStatus.PASS, "Test Case Passed is validateResponseCode200");
	}

	@Test
	public void validateHeaderConnection() {
		test = report.startTest("validateHeaderConnection");
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl).then().assertThat()
				.header("Connection", "Keep-Alive");
		test.log(LogStatus.PASS, "Test Case Passed: validateHeaderConnection");
	}

	@Test
	public void validateHeaderContentType() {
		test = report.startTest("validateHeaderContentType");
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl).then().assertThat()
				.header("Content-Type", "text/xml");
		test.log(LogStatus.PASS, "Test Case Passed: validateHeaderContentType");
	}

	@Test
	public void validateResponseArticleTitleTag() {
		test = report.startTest("validateResponseArticleTitleTag");
		RestAssured.baseURI = myUrl;
		RequestSpecification httpRequest = RestAssured.given();
		// Set HTTP Headers
		httpRequest.header("Accept", "text/xml,application/xml,application/xhtml+xml");

		Response response = httpRequest.get(myUrl);
		String bodyStringValue = response.asString();
		// Validate if Response Body Contains a specific String
		Assert.assertTrue(bodyStringValue.contains("article_title"));
		test.log(LogStatus.PASS, "Test Case Passed: validateResponseArticleTitleTag");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("=======Before Class has started=========");
		report = new ExtentReports(System.getProperty("user.dir") + "\\API_Testingreults.html", true);
		test = report.startTest("Automation API Testing");

		// extent = new ExtentReports (System.getProperty("user.dir")
		// +"/test-output/STMExtentReport.html", true);
		// extent.addSystemInfo("Environment","Environment Name")
		report.addSystemInfo("Host Name", "Kids Health API").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Larry Smith");
		// loading the external xml file (i.e., extent-config.xml) which was placed
		// under the base directory
		// You could find the xml file below. Create xml file in your project and copy
		// past the code mentioned below
		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		// ending test
		// endTest(logger) : It ends the current test and prepares to create HTML report
		report.endTest(test);
	}

	@AfterClass
	public void wrapUp() throws EmailException, InterruptedException {
		test.log(LogStatus.INFO, "Well well well55555!!!!! The tests are complete check it out Son!: ");
		report.endTest(test);
		report.flush();
		// System.out.println("This is After Class");
		// Thread.sleep(60000);
		SendEmail.sendMail();

	}
}
