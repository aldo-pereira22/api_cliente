package ws.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.Fetch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_payment_info")
public class UserPaymentinfo implements Serializable {

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

	
	
	public UserPaymentinfo(Long id, String cardNumber, Long cardExpirationMonth, Long cardExpirationYear,
			String cardSecurityCode, BigDecimal price, LocalDate dtPayment, User user) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardExpirationMonth = cardExpirationMonth;
		this.cardExpirationYear = cardExpirationYear;
		this.cardSecurityCode = cardSecurityCode;
		this.price = price;
		this.dtPayment = dtPayment;
		this.user = user;
	}

	public UserPaymentinfo() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Long getCardExpirationMonth() {
		return cardExpirationMonth;
	}

	public void setCardExpirationMonth(Long cardExpirationMonth) {
		this.cardExpirationMonth = cardExpirationMonth;
	}

	public Long getCardExpirationYear() {
		return cardExpirationYear;
	}

	public void setCardExpirationYear(Long cardExpirationYear) {
		this.cardExpirationYear = cardExpirationYear;
	}

	public String getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getDtPayment() {
		return dtPayment;
	}

	public void setDtPayment(LocalDate dtPayment) {
		this.dtPayment = dtPayment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
