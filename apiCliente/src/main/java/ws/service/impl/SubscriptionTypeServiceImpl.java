package ws.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ws.Repository.SubscribeTypeRepository;
import ws.model.SubscriptionType;
import ws.service.SubscritionTypeService;

@Service
public class SubscriptionTypeServiceImpl implements SubscritionTypeService {
	
	private SubscribeTypeRepository subscribeTypeRepository;
	
	public SubscriptionTypeServiceImpl( SubscribeTypeRepository subscribeTypeRepository) {
		
		this.subscribeTypeRepository = subscribeTypeRepository;
	}
	
	
	@Override
	public List<SubscriptionType> findAll() {
		// TODO Auto-generated method stub
		return this.subscribeTypeRepository.findAll();
	}

	@Override
	public SubscriptionType findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubscriptionType create(SubscriptionType subscriptionType) {
		// TODO Auto-generated method stub
		return null;
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
