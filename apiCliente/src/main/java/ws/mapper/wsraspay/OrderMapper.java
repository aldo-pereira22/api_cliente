package ws.mapper.wsraspay;

import ws.dto.PaymentProcessDto;
import ws.dto.raspay.OrderDto;

public class OrderMapper {
	
	public static OrderDto build(String customerId, PaymentProcessDto paymentProcessDto) {
		return OrderDto.builder()
				.customerId(customerId)
				.productAcronym(paymentProcessDto.getProductKey())
				.discount(paymentProcessDto.getDiscount())
				.build();
	}
}
