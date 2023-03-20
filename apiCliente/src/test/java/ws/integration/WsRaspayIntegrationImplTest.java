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
public class WsRaspayIntegrationImplTest {
	
	@Autowired
	private WsRaspayIntegration wsRaspayIntegration;
	
	@Test
	void createCustomerWhenDtoOk() {
		CustomerDto dto = new CustomerDto(null,"436.721.710-85", "teste@teste","Aldo", "Pereira");
		wsRaspayIntegration.createCustomer(dto);
	}
	
	@Test
	void createOrderWhenDtoOk() {
		OrderDto dto = new OrderDto(null,"641848c1583cf374dd5e5a09", BigDecimal.ZERO,"MONTH22");
		System.out.println("\n\n\n\n\n"+wsRaspayIntegration.createOrder(dto)+"\n\n\n\n");
	}
	
	@Test
	void processPaymentDtoWhenDtoOk() {
		CreditCardDto  creditCard = new CreditCardDto(123L, "436.721.710-85", 0L, 06L,"1234123412341234",2025L);
		PaymentDto paymentDto = new PaymentDto(creditCard, "641848c1583cf374dd5e5a09","64185ede583cf374dd5e5a0c");
		
		wsRaspayIntegration.processPayment(paymentDto);
	}
}
