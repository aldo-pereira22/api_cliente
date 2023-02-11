package ws.service;

import java.util.List;

import ws.model.SubscriptionType;

public interface SubscritionTypeService {

	List<SubscriptionType> findAll();

	SubscriptionType findById(Long id);

	SubscriptionType create(SubscriptionType subscriptionType);
	
	SubscriptionType update(Long id, SubscriptionType subscriptionType);
	
	void delete(Long id);
}
