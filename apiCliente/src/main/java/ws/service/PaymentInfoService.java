package ws.service;

import org.springframework.stereotype.Service;

import ws.dto.PaymentProcessDto;


public interface PaymentInfoService {
	Boolean process(PaymentProcessDto paymentProcessDto);
}
