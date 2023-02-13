package ws.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionTypeDto {
	private Long id;
	
	@NotBlank(message = "Campo name não pode ser nulo ou vazio.")
	@Size(min = 4, max = 30)
	private String name;
	
	@Max(value=12, message = "Campo AccessMonth não pode ser maior que 12")
	private Long accecessMonth;
	
	@NotNull(message = "Campo price não pode ser nulo")
	private BigDecimal price;
	
	@NotBlank(message = "Campo productKey não pode ser nulo ou vazio")
	@Size(min = 5, max = 15)
	private String productKey;
	
}
