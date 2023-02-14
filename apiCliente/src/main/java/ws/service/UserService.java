package ws.service;

import ws.dto.UserDto;
import ws.model.User;

public interface UserService  {

	User create(UserDto dto);
}
