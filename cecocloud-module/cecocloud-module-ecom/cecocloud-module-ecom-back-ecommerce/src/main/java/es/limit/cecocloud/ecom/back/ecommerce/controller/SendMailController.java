/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.mail.smtp.SMTPTransport;

import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.Email;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/sendMail")
public class SendMailController {
	
	private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "marcserratomas@gmail.com";
    private static final String PASSWORD = "pekesita86";

    private static final String EMAIL_FROM = "marcserratomas@gmail.com";
    /*private static final String EMAIL_TO = "mserra@limit.es";
    private static final String EMAIL_TO_CC = "";

    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP (HTML)";
    private static final String EMAIL_TEXT = "<h1>Hello Java Mail \n ABC123</h1>";*/
	
	public SendMailController() {

	}

	@PostMapping(
	value = "/send",
	produces = "application/json")
	public void sendEmail(@RequestBody final Email email) {
	     
		 Properties prop = System.getProperties();
	        prop.put("mail.smtp.auth", "true"); 
	        prop.put("mail.smtp.starttls.enable", "true");
//	        prop.put("mail.smtp.port", "465");  
//	        prop.put("mail.debug", "true");  
//	        prop.put("mail.smtp.socketFactory.port", "465");  
//	        prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
//	        prop.put("mail.smtp.socketFactory.fallback", "false");  

	        Session session = Session.getInstance(prop, null);
	        Message msg = new MimeMessage(session);

	        try {
	        		
	            msg.setFrom(new InternetAddress(email.getFrom()!=null?email.getFrom():EMAIL_FROM));

	            msg.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(email.getTo(), false));

	            msg.setSubject(email.getSubject());

				// TEXT email
	            //msg.setText(EMAIL_TEXT);

				// HTML email
	            msg.setDataHandler(new DataHandler(new HTMLDataSource(email.getBody())));


				SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

				// connect
	            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

				// send
	            t.sendMessage(msg, msg.getAllRecipients());

	            System.out.println("Response: " + t.getLastServerResponse());

	            t.close();

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
}
    
	
	static class HTMLDataSource implements DataSource {

        private String html;

        public HTMLDataSource(String htmlString) {
            html = htmlString;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            if (html == null) throw new IOException("html message is null!");
            return new ByteArrayInputStream(html.getBytes());
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("This DataHandler cannot write HTML");
        }

        @Override
        public String getContentType() {
            return "text/html";
        }

        @Override
        public String getName() {
            return "HTMLDataSource";
        }
    }	

}