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

	private RestTemplate restTemplate;

	public WsRaspayIntegrationImpl() {
		restTemplate = new RestTemplate();
	}

	@Override
	public CustomerDto createCustomer(CustomerDto dto) {
		try {
			HttpHeaders headers = getHttpHeaders();
			
			HttpEntity<CustomerDto> request = new HttpEntity<>(dto, headers);
			
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
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		String credentials ="rasmooplus:r@sm00";
		String base64 = new String (org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(credentials.getBytes()));
		headers.add("Authorization","Basic "+base64);
		return headers;
	}

}
