package Utils.UserUtils;

import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.cj.PreparedQuery;
import com.sun.istack.internal.logging.Logger;

public class Mail {

	public void sendMail(String recepient) {
		Properties properties = System.getProperties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		String from = "biancadondas21@gmail.com";
		String password = "Bleckyblanca12#";

		Session sesion = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		Message message = prepareMessage(sesion, from, recepient);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static Message prepareMessage(Session session, String from, String recepient) {
		WriteUser wr  = new WriteUser();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Bill");
			message.setText("Hello here is the bill for your order\n location of the tickets are: "+wr.products("czaada@gmail.com")+ "with a total of: " + wr.total("czaada@gmail.com")+" euro");
			return message;
		} catch (Exception e) {
			Logger.getLogger(Mail.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return null;

	}
}
