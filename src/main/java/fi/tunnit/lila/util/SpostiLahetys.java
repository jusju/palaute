package fi.tunnit.lila.util;


import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;


/**
 * The e-mail service contains all you need in order to send E-Mails 
 * successfully
 */
@Service
public class SpostiLahetys
{
    // ------------------------------------------------------------------------
    // members
// ------------------------------------------------------------------------

// log4j...
static final Logger logger = Logger.getLogger(SpostiLahetys.class);

@Autowired
private JavaMailSender mailSender;

// ------------------------------------------------------------------------
// public usage
// ------------------------------------------------------------------------

/**
 * Send an Email the cool way!
 * @param recipients
 * @param subject
 * @param text
 * @param html
 */
public void sendEmail(String to, String msgBody)
    throws NoSuchProviderException,AddressException,MessagingException {

    try {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setFrom("teamlilatunnit@gmail.com");
        messageHelper.setTo(to);
        messageHelper.setSubject("Unohdetun salasanan palautuslinkki");
        messageHelper.setText(msgBody);
        mailSender.send(mimeMessage);
    }
    catch (MailException ex) {
        logger.error("Fail: "+ex.getMessage());
    }

}
// ------------------------------------------------------------------------
// private usage
// ------------------------------------------------------------------------


// ------------------------------------------------------------------------
// GETTER & SETTER
// ------------------------------------------------------------------------
}