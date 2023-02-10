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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(Long id, String name, String email, String phone, String cpf, LocalDate dtSubscription,
			LocalDate dtExpiration, UserType userType, SubscriptionType subScriptionType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.dtSubscription = dtSubscription;
		this.dtExpiration = dtExpiration;
		this.userType = userType;
		this.subScriptionType = subScriptionType;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LocalDate getDtSubscription() {
		return dtSubscription;
	}


	public void setDtSubscription(LocalDate dtSubscription) {
		this.dtSubscription = dtSubscription;
	}


	public LocalDate getDtExpiration() {
		return dtExpiration;
	}


	public void setDtExpiration(LocalDate dtExpiration) {
		this.dtExpiration = dtExpiration;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public SubscriptionType getSubScriptionType() {
		return subScriptionType;
	}


	public void setSubScriptionType(SubscriptionType subScriptionType) {
		this.subScriptionType = subScriptionType;
	}
	
	
	
}
