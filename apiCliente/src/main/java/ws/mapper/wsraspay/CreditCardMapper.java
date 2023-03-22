package ws.mapper.wsraspay;

import ws.dto.UserPaymentInfoDto;
import ws.dto.raspay.CreditCardDto;

public class CreditCardMapper {
	
	public static CreditCardDto build(UserPaymentInfoDto dto, String documentNumber) {
		return CreditCardDto.builder()
				.documentNumber(documentNumber)
				.cvv(Long.parseLong(dto.getCardSecurityCode()))
				.number(dto.getCardNumber())
				.month(dto.getCardExpirationMonth())
				.year(dto.getCardExpirationYear())
				.installments(dto.getInstallments())
				.build();
	}
}
