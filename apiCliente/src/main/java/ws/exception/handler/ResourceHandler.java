package ws.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ws.exception.BadRequestException;
import ws.exception.NotFoundException;

@RestControllerAdvice
public class ResourceHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> notFoundException(NotFoundException n){
		String errorMEssage = n.getMessage();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMEssage);
	}
	
//	@ExceptionHandler(BadRequestException.class)
//	public ResponseEntity<String> badRequestException(NotFoundException b){
//		String errorMEssage = b.getMessage();
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMEssage);
//	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> badRequestException(BadRequestException b){
		String errorMessage = b.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}
}
