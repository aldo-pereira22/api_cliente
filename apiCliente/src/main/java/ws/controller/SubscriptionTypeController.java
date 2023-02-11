package ws.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.exception.NotFoundException;
import ws.model.SubscriptionType;
import ws.service.impl.SubscriptionTypeServiceImpl;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

	@Autowired
	private SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;
	
	@GetMapping
	public ResponseEntity< List<SubscriptionType>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeServiceImpl.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< SubscriptionType> findById(@PathVariable("id") Long id) {				
		
			return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeServiceImpl.findById(id));
		
	}
	
}
