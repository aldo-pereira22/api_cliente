package ws.integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

	private final RestTemplate restTemplate;
	private final HttpHeaders headers;
	
	
	public WsRaspayIntegrationImpl() {
		restTemplate = new RestTemplate();
		headers = getHttpHeaders();
	}

	@Override
	public CustomerDto createCustomer(CustomerDto dto) {
		try {
			
			HttpEntity<CustomerDto> request = new HttpEntity<>(dto, this.headers);
			
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
		try {
			
			HttpEntity<OrderDto> request = new HttpEntity<>(dto, this.headers);
			
			ResponseEntity<OrderDto> response = restTemplate.exchange(
					"https://ws-raspay.herokuapp.com/ws-raspay/v1/order", HttpMethod.POST, request,
					OrderDto.class);
			System.out.println("BODY"+ response.getBody());
			return response.getBody();

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean processPayment(PaymentDto dto) {
		try {
			
			HttpEntity<PaymentDto> request = new HttpEntity<>(dto, this.headers);
			
			ResponseEntity<Boolean> response = restTemplate.exchange(
					"https://ws-raspay.herokuapp.com/ws-raspay/v1/payment/credit-card/", HttpMethod.POST, request,
					Boolean.class);
			System.out.println("BODY"+ response.getBody());
			return response.getBody();

		} catch (Exception e) {
			throw e;
		}

	}
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		String credentials ="rasmooplus:r@sm00";
		String base64 = new String (org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(credentials.getBytes()));
		headers.add("Authorization","Basic "+base64);
		return headers;
	}

}
