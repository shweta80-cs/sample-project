package com.example.api;

import java.io.File;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelApiApplication.class, args);
		System.out.println("Mail sending process started");
		String message = "Hello shweta ";
		String subject = "Test mail";
		String to = "shwetagaur525@gmail.com";
		String from = "shwetagaur525@gmail.com";
			
		
		//SendMail(message,subject,to,from);
		SendAttachmentonMail(message,subject,to,from);
	}

	private static void SendAttachmentonMail(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		String host = "smtp.gmail.com";
		Properties properties=System.getProperties();
		System.out.println("Properties"+properties);
		//set host as gmail server
		properties.put("mail.smtp.host", host);
		//set port
		properties.put("mail.smtp.port", "465");
		//set ssl enable
		properties.put("mail.smtp.ssl.enable", "true");
		//set authentication 
		properties.put("mail.smtp.auth", "true");
		
		//to get session object only after providing correct username and password
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("shwetagaur525@gmail.com", "pmev yytf xifc fuoo");
			}
		
		});
		
		
		session.setDebug(true);
		//create message or attach  multimedia etc.
		
		MimeMessage mimeMessage= new MimeMessage(session);
		try {
			
			//meaasage sender 
			mimeMessage.setFrom("shwetagaur80@gmail.com");
			
			//message receiver
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to) ); //"shwetagaur80@gmail.com"
			
			//set subject 
			mimeMessage.setSubject(subject);
			
			//set attachment using file path
			//mimeMessage.setText(message);
			String path = "C:\\Users\\Shweta\\Downloads\\BM2407I009357778.pdf";
			MimeMultipart mimeMultipart= new MimeMultipart();
			
			MimeBodyPart textMimeBodyPart= new MimeBodyPart();
			
			MimeBodyPart fileMimeBodyPart= new MimeBodyPart();
			
			
			
			try {
				textMimeBodyPart.setText(message);
				File file = new File(path);
				fileMimeBodyPart.attachFile(file);
				
				mimeMultipart.addBodyPart(textMimeBodyPart);
				mimeMultipart.addBodyPart(fileMimeBodyPart);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
			mimeMessage.setContent(mimeMultipart);
			
			
		//send message through Transport class
			Transport.send(mimeMessage);
			System.out.println("email sent successfully");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void SendMail(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		String host = "smtp.gmail.com";
		Properties properties=System.getProperties();
		System.out.println("Properties"+properties);
		//set host as gmail server
		properties.put("mail.smtp.host", host);
		//set port
		properties.put("mail.smtp.port", "465");
		//set ssl enable
		properties.put("mail.smtp.ssl.enable", "true");
		//set authentication 
		properties.put("mail.smtp.auth", "true");
		
		//to get session object only after providing correct username and password
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("shwetagaur525@gmail.com", "pmev yytf xifc fuoo");
			}
		
		});
		
		
		session.setDebug(true);
		//create message or attach  multimedia etc.
		
		MimeMessage mimeMessage= new MimeMessage(session);
		try {
			
			//meaasage sender 
			mimeMessage.setFrom("shwetagaur80@gmail.com");
			
			//message receiver
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to) ); //"shwetagaur80@gmail.com"
			
			//set subject 
			mimeMessage.setSubject(subject);
			
			//set message
			mimeMessage.setText(message);
		
		//send message through Transport class
			Transport.send(mimeMessage);
			System.out.println("email sent successfully");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
