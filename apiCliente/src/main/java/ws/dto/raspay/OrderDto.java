package ws.dto.raspay;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private String id;
	private String customerId;
	private BigDecimal discount;
	private String productAcronym;
	
	public OrderDto(String customerId, BigDecimal discount, String productAcronym, String string) {
		super();
		this.customerId = customerId;
		this.discount = discount;
		this.productAcronym = productAcronym;
	}
	
	
}
