package ws.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_payment_info")
public class UserPaymentinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_payment_info_id")
	private Long id;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_expiration_month")
	private Long cardExpirationMonth;

	@Column(name = "card_expiration_year")
	private Long cardExpirationYear;

	@Column(name = "card_security_code")
	private String cardSecurityCode;

	private BigDecimal price;

	@Column(name = "dt_payment")
	private LocalDate dtPayment;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	

	

}
