package ws.integration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ws.dto.raspay.CustomerDto;


@SpringBootTest
public class WsRaspayIntegrationImplTest {
	
	@Autowired
	private WsRaspayIntegration wsRaspayIntegration;
	
	@Test
	void createCustomerWhenDtoOk() {
		CustomerDto dto = new CustomerDto(null,"436.721.710-85", "teste@teste","Aldo", "Pereira");
		System.out.println("\n\n\n\n\n"+wsRaspayIntegration.createCustomer(dto)+"\n\n\n\n");
	}
}
