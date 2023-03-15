package ws.integration;

import ws.dto.raspay.CustomerDto;
import ws.dto.raspay.OrderDto;
import ws.dto.raspay.PaymentDto;

public interface WsRaspayIntegration {
	
	CustomerDto createCustomer(CustomerDto dto);
	OrderDto createOrder(OrderDto dto);
	Boolean processPayment(PaymentDto dto);
}
