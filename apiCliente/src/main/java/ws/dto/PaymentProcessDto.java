package ws.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentProcessDto {

	@NotBlank(message = "Deve ser informado")
	private String productKey;
	
	private BigDecimal discount;
	
	@NotNull(message = "Dados do pagamento deve ser informado")
	@JsonProperty("userPaymentInfo")
	private UserPaymentInfoDto userPaymentInfoDto;
	
}
