/**
 * 
 */
package es.limit.cecocloud.logic.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test d'enviament de correus electrònics.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.properties.mail.smtp.from}")
	private String mailSmtpFrom;

	@Test
	public void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(mailSmtpFrom);
        msg.setTo("josepg@limit.es");
        msg.setSubject("Cecocloud: validació d'usuari");
        msg.setText("Enllaç de validació: ???");
        javaMailSender.send(msg);
	}

}
