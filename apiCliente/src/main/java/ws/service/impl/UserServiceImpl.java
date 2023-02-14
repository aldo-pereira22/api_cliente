package ws.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import ws.Repository.UserRepository;
import ws.Repository.UserTypeRepository;
import ws.dto.UserDto;
import ws.exception.BadRequestException;
import ws.exception.NotFoundException;
import ws.mapper.UserMapper;
import ws.model.User;
import ws.model.UserType;
import ws.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	private final  UserTypeRepository userTypeRepository;
	
	public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository ) {
		this.userRepository = userRepository;
		this.userTypeRepository = userTypeRepository;
		
	}
	
	@Override
	public User create(UserDto dto) {
		if(Objects.nonNull(dto.getId())) {
			throw new BadRequestException("Id deve ser nulo");
		}
		
		var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());
		
		 if(userTypeOpt.isEmpty()) {
			 throw new NotFoundException("UserTypeId não encontrado!!!");
		 }
		 
		 UserType userType = userTypeOpt.get();
		 
		 User user = UserMapper.fromDtoToEntity(dto, userType, null);
		return userRepository.save(user);
	}

}
