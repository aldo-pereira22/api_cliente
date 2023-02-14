package ws.mapper;

import ws.dto.UserDto;
import ws.model.SubscriptionType;
import ws.model.User;
import ws.model.UserType;

public class UserMapper {
	public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType) {
		
		System.out.println("\n\n\nDATAAA: "+dto.getDtExpiration() +"\n\n\n");
		return User.builder()
				.id(dto.getId())
				.name(dto.getName())
				.cpf(dto.getCpf())
				.email(dto.getEmail())
				.phone(dto.getPhone())
				.dtSubscription(dto.getDtSubscription())
				.dtExpiration(dto.getDtExpiration())
				.userType(userType)
				.subScriptionType(subscriptionType)
				.build();
	}
}
