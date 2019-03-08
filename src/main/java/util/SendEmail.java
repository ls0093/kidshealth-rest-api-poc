package util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail {

	public static void sendMail() throws EmailException {

		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\Users\\ls0093\\eclipse-workspace\\RestApiTest\\API_Testingreults.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Report");
		attachment.setName("TestResults");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		// Email email = new SimpleEmail();
		email.setHostName("outgoing-smtp.nemours.org");
		email.setSslSmtpPort("25"); //
		email.setFrom("noreply@nemours.org ");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("larry.smith@nemours.org");
		// email.send();

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

		/*
		 * Email email = new SimpleEmail();
		 * email.setHostName("outgoing-smtp.nemours.org"); email.setSmtpPort(25); //
		 * email.MAIL_TRANSPORT_PROTOCOL("smtp"); email.setAuthenticator(new
		 * DefaultAuthenticator("larry.smith@nemours.org", "Loveme@7968"));
		 * email.setSSLOnConnect(true); email.setFrom("noreply@nemours.org ");
		 * email.setSubject("TestMail"); email.setMsg("This is a test mail ... :-)");
		 * email.addTo("larry.smith@nemours.org"); email.send();
		 */

	}

}
