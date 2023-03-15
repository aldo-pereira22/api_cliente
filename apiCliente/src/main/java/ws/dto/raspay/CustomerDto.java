package ws.dto.raspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	
		private String id;
		private String cpf;
		private String email;
		private String firstName;
		private String lastName;
		
//		public CustomerDto(String id, String cpf, String firstName, String lastName) {
//			super();
//			this.id = id;
//			this.cpf = cpf;
//			this.firstName = firstName;
//			this.lastName = lastName;
//		}
		
		
}
