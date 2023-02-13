package ws.mapper;

import ws.dto.SubscriptionTypeDto;
import ws.model.SubscriptionType;

public class SubscriptionTypeMapper {
	public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto) {
		return SubscriptionType.builder()
				.id(dto.getId())
				.name(dto.getName())
				.accecessMonths(dto.getAccecessMonths())
				.price(dto.getPrice())
				.productKey(dto.getProductKey())
				.build();
	}
	
}
