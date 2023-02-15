package ws.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

	private Long id;
	
	@NotBlank(message = "Valor não pode ser nulo ou vazio")
	@Size(min = 4, message = "Valor minimo igual a 4 caracteres")
	private String name;

	@Email(message = "inválido")
	private String email;

	@Size(min = 11, message =  "Valor igual a 11 digitos")
	private String phone;

	@CPF(message = "Inválido")
	private String cpf;
	

	private LocalDate dtSubscription = LocalDate.now();
	
	private LocalDate dtExpiration =  LocalDate.now();
	
	
	@NotNull
	private Long  userTypeId;

	private Long subScriptionTypeId;

}
