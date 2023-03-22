package ws.integration;

public interface MailIntegration {
	void send(String mailTo, String message, String subject);
}
