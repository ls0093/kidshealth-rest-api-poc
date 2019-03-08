package getRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class writeDataToConsole {
	String myUrl = "http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine";

	@Test
	public void testXmlBodyContent() {
		String s = given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl)
				.thenReturn().asString();
		System.out.println(s);
	}

	@Test
	public void articleTitleValidateFirstRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(myUrl).then().assertThat()
				.body("kharticles.kharticle.article_title[0]", equalTo("Girls and Puberty"));
	}

	@Test
	public void articleTitleValidateLastRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat()
				.body("kharticles.kharticle.article_title[-1]", equalTo("Why Is My Voice Changing?"));
	}

	@Test
	public void metaDescriptionValidateFirstRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.meta_description[0]", equalTo(
						"Girls have lots of questions about puberty and growing up. Find all the answers here!"));
	}

	@Test
	public void metaDescriptionValidateLastRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.meta_description[-1]", equalTo(
						"At puberty, guys' bodies begin producing a lot of the hormone testosterone, which causes changes in several parts of the body, including the voice."));
	}

	@Test
	public void metaKeywordsValidateFirstRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.meta_keywords[0]", equalTo(
						"girls,  puberty,  growing up,  periods,  menstruation,  bras,  crushes,  body hair,  shaving legs,  breasts,  pads,  tampons"));
	}

	@Test
	public void metaKeywordsValidateLastRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.meta_keywords[-1]", equalTo(
						"voice,  voise,  voyse,  voice change,  voice changvoice changing,  voice breaking,  voice cracking,  voice cracks,  when will my voice change?,  how deep will my voice get?,  deep voice,  high voice,  low voice,  voice sounds,  vocal chords,  vocal cords,  larynx,  larinx,  lairinx,  lairincs,  larincs,  laryncs,  adams apple,  adam's apple,  control the voice,  voice control,  controlling my voice"));
	}

	@Test
	public void articleFullUrlValidateFirstRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.article_full_url[0]", equalTo(
						"http://trs.kidshealth.org/ws/CookChildrens/en/kids/center/girls-puberty-center.html/"));
	}

	@Test
	public void articleFullUrlValidateLastRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.article_full_url[-1]",
						equalTo("http://trs.kidshealth.org/ws/CookChildrens/en/teens/voice-changing.html/"));
	}

	@Test
	public void languageValidateFirstRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.language[0]", equalTo("en"));
	}

	@Test
	public void languageValidateLastRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.language[-1]", equalTo("en"));
	}

	@Test
	public void sectionNameValidateFirstRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.section_name[0]", equalTo("Kids"));
	}

	@Test
	public void sectionNameValidateLastRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.kharticle.section_name[-1]", equalTo("Teens"));
	}

	@Test
	public void artObjectIdValidateFirstRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat()
				.body("kharticles.kharticle.article_object_id[0]", equalTo("96184a9a-a430-4f70-83fe-45724296399c"));
	}

	@Test
	public void artObjectIdValidateLastRecord() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat()
				.body("kharticles.kharticle.article_object_id[-1]", equalTo("ee70bd3e-f08f-4e54-a92b-89a9a132cd0e"));
	}

	@Test
	public void footerCopyWriteValidate() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.footer.copyright", equalTo(
						"&copy; 1995-2018 KidsHealth&reg; All rights reserved. Images provided by The Nemours Foundation, iStock, Getty Images, Veer, Shutterstock, and Clipart.com."));
	}

	@Test
	public void footerDisclaimerValidate() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.footer.disclaimer", equalTo(
						"Note: All information is for educational purposes only. For specific medical advice, diagnoses, and treatment, consult your doctor."));
	}

	@Test
	public void footerLogoValidate() {
		given().header("Accept", "text/xml,application/xml,application/xhtml+xml").when().get(
				"http://trs.kidshealth.org/ws/CookChildrens/searchbyaspect/?lang=en&section=Parents&aspects=primaryClinicalDesignation-adolescentMedicine")
				.then().assertThat().body("kharticles.footer.logo", equalTo(
						"http://trs.kidshealth.org/licensees/standard_licensee/images/kidshealth_ed_part_logo.gif"));
	}
}
