package ws.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String cpf;
	
	@Column(name = "dt_subscription")
	private LocalDate dtSubscription = LocalDate.now();
	
	@Column(name = "dt_expiration")
	private LocalDate dtExpiration;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type_id")
	private UserType userType;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "subscription_type_id")
	private SubscriptionType subScriptionType;
	
	
	
	
	
}
