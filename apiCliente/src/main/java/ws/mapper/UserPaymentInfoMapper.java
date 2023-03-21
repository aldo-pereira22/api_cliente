package ws.mapper;

import ws.dto.UserPaymentInfoDto;
import ws.model.User;
import ws.model.UserPaymentinfo;

public class UserPaymentInfoMapper {
	
	public static UserPaymentinfo fromDtoToEntity(UserPaymentInfoDto dto, User user) {
		return UserPaymentinfo.builder()
				.id(dto.getId())
				.cardExpirationMonth(dto.getCardExpirationMonth())
				.cardExpirationYear(dto.getCardExpirationYear())
				.cardSecurityCode(dto.getCardSecurityCode())
				.price(dto.getPrice())
				.dtPayment(dto.getDtPayment())
				.user(user)
				.build();
	}
}
