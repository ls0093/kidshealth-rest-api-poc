package getRequest;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;

public class loopThroughTitle {

	String myUrl = "http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";

	@Test
	public void loopThroughAllTitles() {
		String s = given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl)
				.thenReturn().asString();

		XmlPath xml = new XmlPath(s);
		// System.out.println(xml.get("kharticles.kharticle.article_title[0]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[1]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[2]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[3]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[4]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[5]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[6]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[7]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[8]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[9]"));
		// System.out.println(xml.get("kharticles.kharticle.article_title[10]"));

		List<String> list = xml.getList("kharticles.kharticle.article_title");
		// List<String> list = xml.getList("kharticles.kharticle.article_object_id");
		// List<String> list = xml.getList("kharticles.kharticle.section_name");

		System.out.println("**************************************************");
		System.out.println("Number of total articles or records: " + list.size());
		System.out.println("**************************************************");

		for (String str : list) {
			System.out.println(str);
		}
	}
}
