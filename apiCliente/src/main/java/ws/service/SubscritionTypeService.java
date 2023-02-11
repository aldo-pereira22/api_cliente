package ws.service;

import java.util.List;

import ws.dto.SubscriptionTypeDto;
import ws.model.SubscriptionType;

public interface SubscritionTypeService {

	List<SubscriptionType> findAll();

	SubscriptionType findById(Long id);

	SubscriptionType create(SubscriptionTypeDto dto);
	
	SubscriptionType update(Long id, SubscriptionTypeDto dto);
	
	void delete(Long id);
}
