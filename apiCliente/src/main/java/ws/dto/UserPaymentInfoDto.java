package ws.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class UserPaymentInfoDto {


	private Long id;

	@Size(min = 16, max = 16, message = "Deve conter 16 carateres")
	private String cardNumber;


	@Min(value = 1)
	@Max(value = 12)
	private Long cardExpirationMonth;
	
	
	private Long cardExpirationYear;

	@Size(min = 3, max = 3, message = "Deve conter 3 caracteres")
	private String cardSecurityCode;

	private BigDecimal price;

	@Builder.Default
	private LocalDate dtPayment = LocalDate.now();

	@NotNull(message = "Deve ser informado")
	private Long userId;
	
	private Long installments;

}
