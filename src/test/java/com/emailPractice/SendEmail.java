package com.emailPractice;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail { 
	public static void main(String[] args) throws EmailException 
	{ 
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sriaman3@gmail.com", ""));
		email.setSSLOnConnect(true);
		email.setFrom("mearpit015@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("sriaman3@gmail.com");
		email.send();
		
		System.out.println("Email sent");
	} 
} 

//note- Less secure app access set ON for your gmail account and off your 2 factor authentication
//https://commons.apache.org/proper/commons-email/download_email.cgi - to dowload the zip file and add external jar in your maven project
//https://commons.apache.org/proper/commons-email/userguide.html -  this is user guide to read about the functions