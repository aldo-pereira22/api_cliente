package ws.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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
	
	
	@Builder.Default
	private LocalDate dtSubscription = LocalDate.now();
	
	@Builder.Default
	private LocalDate dtExpiration =  LocalDate.now();
	
	
	@NotNull
	private Long  userTypeId;

	private Long subScriptionTypeId;

}
