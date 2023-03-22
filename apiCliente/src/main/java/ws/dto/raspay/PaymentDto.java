package ws.dto.raspay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
	
	private CreditCardDto creditCard;
	
	private String customerId;
	private String orderId;
	
}
