package ws.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ws.Repository.SubscribeTypeRepository;
import ws.dto.SubscriptionTypeDto;
import ws.exception.NotFoundException;
import ws.model.SubscriptionType;
import ws.service.SubscritionTypeService;

@Service
public class SubscriptionTypeServiceImpl implements SubscritionTypeService {

	private SubscribeTypeRepository subscribeTypeRepository;

	public SubscriptionTypeServiceImpl(SubscribeTypeRepository subscribeTypeRepository) {

		this.subscribeTypeRepository = subscribeTypeRepository;
	}

	@Override
	public List<SubscriptionType> findAll() {

		return this.subscribeTypeRepository.findAll();
	}

	@Override
	public SubscriptionType findById(Long id) {
		
		Optional<SubscriptionType> optionalSubscriptionType = this.subscribeTypeRepository.findById(id);
		
		if(optionalSubscriptionType.isEmpty()) {
			 throw new NotFoundException("SubscriptionType não encontrado!!!");
		}
		return optionalSubscriptionType.get();
	}

	
	@Override
	public SubscriptionType create(SubscriptionTypeDto dto) {
		
		return subscribeTypeRepository.save(SubscriptionType.builder()
				.id(dto.getId())
				.name(dto.getName())
				.accecessMonth(dto.getAccessMonth())
				.price(dto.getPrice())
				.productKey(dto.getProductKey())
				.build());
	}

	@Override
	public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
