package ws.dto.raspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private String id;
	private String customerId;
	private Long dicount;
	private String productAcronym;
	
}
