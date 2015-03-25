package com.endang.restEvoting.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.endang.restEvoting.service.Koneksi;

public class EmailSender {
	
	public static EmailSender getInstance(){
		return new EmailSender();
	}
	
	public void sendEmail(String emailPemilih,String pesan){
		final String username = getOptionEmail();
		final String password = getOptionEmailPassword();
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailPemilih));
			message.setSubject("Password E-VOTING HMTIF");
			message.setText(pesan);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String getOptionEmail(){
		String email = "_";
		String query = "Select value_option from options where id_option = 5";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				email = rs.getString("value_option");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	
	private String getOptionEmailPassword(){
		String emailPassword = "_";
		String query = "Select value_option from options where id_option = 6";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				emailPassword = rs.getString("value_option");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emailPassword;
	}
	
	

}
