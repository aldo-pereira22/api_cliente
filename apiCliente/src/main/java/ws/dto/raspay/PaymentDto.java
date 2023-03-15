package ws.dto.raspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	
	private CreditCardDto creditCrd;
	
	private String customerId;
	private String orderId;
	
}
