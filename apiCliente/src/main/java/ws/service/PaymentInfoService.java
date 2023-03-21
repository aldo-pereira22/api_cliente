package ws.service;

import ws.dto.PaymentProcessDto;


public interface PaymentInfoService {
	Boolean process(PaymentProcessDto paymentProcessDto);
}
