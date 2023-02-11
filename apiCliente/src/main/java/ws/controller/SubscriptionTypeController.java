package ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.Repository.SubscribeTypeRepository;
import ws.model.SubscriptionType;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

	@Autowired
	private SubscribeTypeRepository subscriptionRepository;
	
	@GetMapping
	public ResponseEntity< List<SubscriptionType>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(subscriptionRepository.findAll());
	}
	
}
