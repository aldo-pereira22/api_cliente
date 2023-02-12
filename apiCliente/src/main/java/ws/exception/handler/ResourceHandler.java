package ws.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ws.dto.error.ErrorResponseDto;
import ws.exception.BadRequestException;
import ws.exception.NotFoundException;

@RestControllerAdvice
public class ResourceHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException n){

		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				ErrorResponseDto.builder()
				.message(n.getMessage())
				.httpStatus(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build()
				);
	}

	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponseDto> badRequestException(BadRequestException b){
		String errorMessage = b.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				ErrorResponseDto.builder()
				.message(b.getMessage())
				.httpStatus(HttpStatus.BAD_REQUEST)
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.build());
	}
}
