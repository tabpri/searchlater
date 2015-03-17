package com.toukubo.searchlater;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public Mail(String url){
        Properties property = new Properties();

        property.put("mail.smtp.host","smtp.gmail.com");

        //GmailのSMTPを使う場合
        property.put("mail.smtp.auth", "true");
        property.put("mail.smtp.starttls.enable", "true");
        property.put("mail.smtp.host", "smtp.gmail.com");
        property.put("mail.smtp.port", "587");
        property.put("mail.smtp.debug", "true");

        Session session = Session.getInstance(property, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("toukubo@gmail.com", "zaq12wsxzaq12wsx");
            }
        });

        /*
        //一般的なSMTPを使う場合

        //ポートが25の場合は省略可能
        property.put("mail.smtp.port", 25);

        Session session = 
                Session.getDefaultInstance(property, null);
        */

        try {
			MimeMessage mimeMessage = new MimeMessage(session);

			InternetAddress toAddress = 
			        new InternetAddress("add@getpocket.com", "pocket");

			mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

			InternetAddress fromAddress = 
			        new InternetAddress("toukubo@gmail.com","toukubo");

			mimeMessage.setFrom(fromAddress);

			mimeMessage.setSubject("title", "ISO-2022-JP");

			mimeMessage.setText(url, "ISO-2022-JP");

			Transport.send(mimeMessage);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
