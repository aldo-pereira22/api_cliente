package ws.integration;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ws.dto.raspay.CustomerDto;
import ws.dto.raspay.OrderDto;


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
}
