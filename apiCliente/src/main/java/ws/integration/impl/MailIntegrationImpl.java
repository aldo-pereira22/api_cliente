package ws.integration.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import ws.integration.MailIntegration;

public class MailIntegrationImpl implements MailIntegration{

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void send(String mailTo, String message) {
	
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(mailTo);
		simpleMailMessage.setSubject("Acesso liberado!");
		simpleMailMessage.setText("Login: "+mailTo+"senha: aluno");
		javaMailSender.send(simpleMailMessage);
		
	}

	
}
