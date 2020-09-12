/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

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
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/sendEmail")
public class SendMailController {

    private static final String EMAIL_FROM = "limit@limit.es";
	
	public SendMailController() {

	}

	@PostMapping(
	value = "/send",
	produces = "application/json")
	public void sendEmail(@RequestBody final Email email) {
		    
		String username = "", password = "", auth = "", starttls = "", host= "", port = "", ssl = "";
		
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("init.properties"));
		  username = properties.getProperty("mail.username");
		  password = properties.getProperty("mail.password");
		  auth = properties.getProperty("mail.smtp.auth");
		  starttls = properties.getProperty("mail.smtp.starttls.enable");
		  host = properties.getProperty("mail.smtp.host");
		  port = properties.getProperty("mail.smtp.port");
		  ssl = properties.getProperty("mail.smtp.ssl.trust");
		} catch (IOException e) {			
			log.error("No s'ha trobat el fitxer: init.properties");			
		}
		  
		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", auth); 
		prop.put("mail.smtp.starttls.enable", starttls);
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.ssl.trust", ssl);
		
        Session session = Session.getInstance(prop, null);
	    Message msg = new MimeMessage(session);

	    try {
	    	
	    	msg.setFrom(new InternetAddress(username!=null?username:EMAIL_FROM));
	    	msg.setRecipients(Message.RecipientType.TO,
	        InternetAddress.parse(email.getTo(), false));
	    	msg.setSubject(email.getSubject());

			// TEXT email	    	
	    	if (email.getHtmlBody()) {
	    		msg.setContent(email.getBody(), "text/html; charset=UTF-8");
	    	} else {
	    		msg.setText(email.getBody());
	    	}	        
	        
//	    	msg.setDataHandler(new DataHandler(new HTMLDataSource(email.getBody())));
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

			// connect
			t.connect(host, username, password);
			
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