package ws.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ws.Repository.UserRepository;
import ws.dto.PaymentProcessDto;
import ws.exception.BusinessException;
import ws.exception.NotFoundException;
import ws.model.User;
import ws.service.PaymentInfoService;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

	private final UserRepository userRepository;
	
	public PaymentInfoServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
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
//		Salvar informações de pagamento
//		Cria ou atualiza usuario Raspay
//		Cria o pedido de pagamento
//		Processa o pagamento
//		Enviar email de criação de conta
//		retorna o sucesso ou não do pagamento
		return null;
	}

}
