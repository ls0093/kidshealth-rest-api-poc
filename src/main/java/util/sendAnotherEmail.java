package util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class sendAnotherEmail {

	public static void main(String[] args) throws EmailException {

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();

		// Email email = new SimpleEmail();
		email.setHostName("outgoing-smtp.nemours.org");
		email.setSslSmtpPort("25"); //
		email.setFrom("noreply@nemours.org ");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("larry.smith@nemours.org");
		email.send();

	}

}
