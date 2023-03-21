package ws.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ws.Repository.UserPaymentInfoRepository;
import ws.Repository.UserRepository;
import ws.dto.PaymentProcessDto;
import ws.dto.raspay.CustomerDto;
import ws.exception.BusinessException;
import ws.exception.NotFoundException;
import ws.integration.WsRaspayIntegration;
import ws.mapper.UserPaymentInfoMapper;
import ws.mapper.wsraspay.CustomerMapper;
import ws.model.User;
import ws.model.UserPaymentinfo;
import ws.service.PaymentInfoService;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

	private final UserRepository userRepository;
	
	private final UserPaymentInfoRepository userPaymentInfoRepository;
	private final WsRaspayIntegration wsRaspayIntegration;
	
	public PaymentInfoServiceImpl(UserRepository  userRepository, UserPaymentInfoRepository userPaymentInfoRepository, WsRaspayIntegration wsRaspayIntegration) {
		this.wsRaspayIntegration = wsRaspayIntegration;
		this.userRepository = userRepository;
		this.userPaymentInfoRepository = userPaymentInfoRepository;
	}
	
	@Override
	public Boolean process(PaymentProcessDto dto) {
	
//		Verifca usuário por id e verifica se ja existe;
		Optional<User> userOpt = userRepository.findById(dto.getUserPaymentInfoDto().getId());
		if(userOpt.isEmpty()) {
			throw new NotFoundException("Usuário não encontrado!");
		}
		User user = userOpt.get();
		
		if(Objects.nonNull(user.getSubScriptionType())) {
			throw new BusinessException("Pagameno não pode ser processado pois o usuário ja possui assinatura");
		}

		
//		Cria ou atualiza usuario Raspay
		CustomerDto customerDto =   wsRaspayIntegration.createCustomer(CustomerMapper.build(user));
		
//		Cria o pedido de pagamento
//		Processa o pagamento
		
//		Salvar informações de pagamento
		UserPaymentinfo userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(), user);
		userPaymentInfoRepository.save(userPaymentInfo);
//		Enviar email de criação de conta
//		retorna o sucesso ou não do pagamento
		return null;
	}

}
