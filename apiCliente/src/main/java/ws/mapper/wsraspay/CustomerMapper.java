package ws.mapper.wsraspay;

import ws.dto.raspay.CustomerDto;
import ws.model.User;

public class CustomerMapper {

	public static CustomerDto build(User user) {
		
		var fullname = user.getName().split(" ");
		var firstName = fullname[0];
		var lastName = fullname.length > 1 ? fullname[fullname.length - 1] : "";
		
		
										
		
		return CustomerDto.builder()
				.email(user.getEmail())
				.cpf(user.getCpf())
				.firstName(firstName)
				.lastName(lastName)
				.build();
	}
}
