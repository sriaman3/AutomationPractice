package com.emailPractice;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EmailWithAttachment {

	public static void main(String[] args) throws EmailException {
		
		// Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath(System.getProperty("user.dir")+"\\ScreenShot\\19_2022_154.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Picture of John");
		  attachment.setName("John");

		  // Create the email message
		  MultiPartEmail emails = new MultiPartEmail();
		  emails.setHostName("smtp.gmail.com");
		  emails.setSmtpPort(465);
		  emails.setAuthenticator(new DefaultAuthenticator("sriaman3@gmail.com", ""));
		  emails.setSSLOnConnect(true);
		  emails.addTo("sriaman3@gmail.com", "John Doe");
		  emails.setFrom("sriaman3@gmail.com", "Me");
		  emails.setSubject("The picture");
		  emails.setMsg("Here is the picture you wanted");

		  // add the attachment
		  emails.attach(attachment);

		  // send the email
		  emails.send();
		  System.out.println("Email sent");
	}

}
