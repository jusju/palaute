package fi.tunnit.lila.util;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Component
public class SpostiLahetys {

	@Autowired
	private mailSender MailSender; // MailSender interface defines a strategy
										// for sending simple mails
 
	public void send(String to, String msgBody) throws MessagingException {
 
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("Unohdetun salasanan palautuslinkki");
		helper.setTo(to);
		helper.setText(msgBody, true);
		
		javaMailSender.send(message);
		

	}
	
}
