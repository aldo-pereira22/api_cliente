package ws.integration.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import ws.integration.MailIntegration;

@Component
public class MailIntegrationImpl implements MailIntegration{

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void send(String mailTo, String message, String subject) {
	
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(mailTo);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		javaMailSender.send(simpleMailMessage);
		
	}

	
}
