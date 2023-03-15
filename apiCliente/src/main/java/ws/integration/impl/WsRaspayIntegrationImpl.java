package ws.integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ws.dto.raspay.CustomerDto;
import ws.dto.raspay.OrderDto;
import ws.dto.raspay.PaymentDto;
import ws.integration.WsRaspayIntegration;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

	private RestTemplate restTemplate;

	public WsRaspayIntegrationImpl() {
		restTemplate = new RestTemplate();
	}

	@Override
	public CustomerDto createCustomer(CustomerDto dto) {
		try {
			HttpEntity<CustomerDto> request = new HttpEntity<>(dto);
			ResponseEntity<CustomerDto> response = restTemplate.exchange(
					"https://ws-raspay.herokuapp.com/ws-raspay/v1/customer", HttpMethod.POST, request,
					CustomerDto.class);
			return response.getBody();

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public OrderDto createOrder(OrderDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean processPayment(PaymentDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
