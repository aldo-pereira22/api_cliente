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
	private BigDecimal dicount;
	private String productAcronym;
	
	public OrderDto(String customerId, BigDecimal dicount, String productAcronym, String string) {
		super();
		this.customerId = customerId;
		this.dicount = dicount;
		this.productAcronym = productAcronym;
	}
	
	
}
