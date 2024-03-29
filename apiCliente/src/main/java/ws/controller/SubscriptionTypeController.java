package ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.dto.SubscriptionTypeDto;
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
	
	@PostMapping
	public ResponseEntity<SubscriptionType> create(@Valid @RequestBody SubscriptionTypeDto dto){
			return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeServiceImpl.create(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SubscriptionType> update(@PathVariable("id") Long id, @RequestBody SubscriptionTypeDto dto){
			return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeServiceImpl.update(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		subscriptionTypeServiceImpl.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}














