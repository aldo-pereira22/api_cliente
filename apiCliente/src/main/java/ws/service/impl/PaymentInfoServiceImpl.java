package ws.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ws.Repository.UserPaymentInfoRepository;
import ws.Repository.UserRepository;
import ws.dto.PaymentProcessDto;
import ws.dto.raspay.CustomerDto;
import ws.dto.raspay.OrderDto;
import ws.dto.raspay.PaymentDto;
import ws.exception.BusinessException;
import ws.exception.NotFoundException;
import ws.integration.MailIntegration;
import ws.integration.WsRaspayIntegration;
import ws.mapper.UserPaymentInfoMapper;
import ws.mapper.wsraspay.CreditCardMapper;
import ws.mapper.wsraspay.CustomerMapper;
import ws.mapper.wsraspay.OrderMapper;
import ws.mapper.wsraspay.PaymentMapper;
import ws.model.User;
import ws.model.UserPaymentinfo;
import ws.service.PaymentInfoService;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

	private final UserRepository userRepository;
	
	private final UserPaymentInfoRepository userPaymentInfoRepository;
	private final WsRaspayIntegration wsRaspayIntegration;
	private final MailIntegration mailIntegration;
	
	public PaymentInfoServiceImpl(UserRepository  userRepository, UserPaymentInfoRepository userPaymentInfoRepository,
			WsRaspayIntegration wsRaspayIntegration,MailIntegration mailIntegration) {
		this.wsRaspayIntegration = wsRaspayIntegration;
		this.userRepository = userRepository;
		this.userPaymentInfoRepository = userPaymentInfoRepository;
		this.mailIntegration = mailIntegration;
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
		OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(),dto));
		
		
//		Processa o pagamento
		PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(), orderDto.getId(),CreditCardMapper.build(dto.getUserPaymentInfoDto(), user.getCpf()));
		Boolean successPayment =  wsRaspayIntegration.processPayment(paymentDto);
		
		if(Boolean.TRUE.equals(successPayment)) {
//			Salvar informações de pagamento
			UserPaymentinfo userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(), user);
			userPaymentInfoRepository.save(userPaymentInfo);
			mailIntegration.send(user.getEmail(), "Usuário: %S"+user.getEmail()+ "- Senha: aluno", "Acesso liberado!");
			return true;
		}
		

//		Enviar email de criação de conta
//		retorna o sucesso ou não do pagamento
		return false;
	}

}
