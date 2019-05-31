package com.rally.automation.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResultsIT {

	Date dt = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("E dd-MMM-yyyy");
	String today = simpleDate.format(dt);
	String from = "AutomateMailForEmail@gmail.com";
	String bcc = "";
	String to = "sachintalwaria@gmail.com,saroj.malhotra@wildnettechnologies.com,Sarojmalhotra26@gmail.com";
	String cc = "";


	@BeforeClass(alwaysRun = true)
	void setupMailConfig() {
		System.out.println(System.getProperty("user.dir"));
	}

	@Test(alwaysRun = true)
	public void sendResultsMail() {

		try {

			Properties props = System.getProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.ssl","true");
			props.put("mail.smtp.auth", "true");

			// Use your GMail account username here
			props.put("mail.smtp.user", "AutomateMailForEmail@gmail.com");
			props.put("mail.smtp.port", "465");
			props.put("mail.mime.charset", "ISO-8859-1");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			Session session = Session.getDefaultInstance(props,
					new Authentication("AutomateMailForEmail@gmail.com", "Wildnet@123"));
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from, "Automation QA - Rally"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc, false));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
			message.setSubject("Rally Bus Automated Test Execution Report - " + today);
			message.setContent(setAttachement());
			Thread.sleep(8000);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Multipart setAttachement() throws Exception {
		// Create the message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();

		// Fill the message
		messageBodyPart.setContent(setBodyText(), "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment **** Emailable report ****
		messageBodyPart = new MimeBodyPart();
		String cwd = System.getProperty("user.dir");
		messageBodyPart.attachFile(cwd + "/target/surefire-reports/emailable-report.html");
		multipart.addBodyPart(messageBodyPart);
		return multipart;
	}

	public String setBodyText() {
		String mailtext = "";
		mailtext = "<html> <body> <font face='calibri'>" + "Hi,<br>";
		mailtext = mailtext + "<font face='calibri'>" + "<br>Greetings !<br>" + "</font>";
		mailtext = mailtext + "<font face='calibri'>" + "<br>The automated TCs have been executed." + "<br>"
				+ "</font>";
		mailtext = mailtext + "<font face='calibri'>" + "<br>Please find the attachment." + "<br>" + "</font>";

		mailtext = mailtext
				+ "<font face = 'Calibri' size = 2, color = '#707070'>Note: This is a system generated e-mail. Please do not reply. If you have any queries; mail to </font><font face = 'Calibri' size = 2><a href=mailto:AutomateMailForEmail@gmail.com?Subject=Reply of Automation Status>Automation Team</a> </font> </font> </html>";
		return mailtext;
	}

}
