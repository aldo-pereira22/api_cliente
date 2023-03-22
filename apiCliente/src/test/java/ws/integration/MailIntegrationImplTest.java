package ws.integration;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ws.dto.raspay.CreditCardDto;
import ws.dto.raspay.CustomerDto;
import ws.dto.raspay.OrderDto;
import ws.dto.raspay.PaymentDto;


@SpringBootTest
public class MailIntegrationImplTest {
	
	@Autowired
	private MailIntegration mailIntegration;
	
	@Test
	void createCustomerWhenDtoOk() {

		mailIntegration.send("rasmoocontateste@gmail.com", "Olá Gmail");
	}

}
