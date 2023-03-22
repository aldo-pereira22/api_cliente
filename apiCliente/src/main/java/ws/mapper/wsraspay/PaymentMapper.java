package ws.mapper.wsraspay;

import ws.dto.raspay.CreditCardDto;
import ws.dto.raspay.PaymentDto;

public class PaymentMapper {

	public static PaymentDto build(String customerId, String orderId, CreditCardDto dto) {
		return PaymentDto.builder()
				.customerId(customerId)
				.orderId(orderId)
				.creditCard(dto)
				.build();
	}
}
