package ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ws.dto.PaymentProcessDto;
import ws.service.PaymentInfoService;

@RestController
@RequestMapping("/payment")
public class PaymentInfoController {

	@Autowired
	private PaymentInfoService paymentInfoservice;
	
	@PostMapping("/process")
	public ResponseEntity<Boolean> process( @RequestBody PaymentProcessDto dto){
		return ResponseEntity.status(HttpStatus.OK).body(paymentInfoservice.process(dto));
	}
	
}
