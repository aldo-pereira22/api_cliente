package ws.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscriptions_type")
public class SubscriptionType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "subscriptions_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(name = "access_month")
	private Long accecessMonth;
	
	private BigDecimal price;
	
	@Column(name = "product_key")
	private String productKey;

	public SubscriptionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubscriptionType(Long id, String name, Long accecessMonth, BigDecimal price, String productKey) {
		super();
		this.id = id;
		this.name = name;
		this.accecessMonth = accecessMonth;
		this.price = price;
		this.productKey = productKey;
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

	public Long getAccecessMonth() {
		return accecessMonth;
	}

	public void setAccecessMonth(Long accecessMonth) {
		this.accecessMonth = accecessMonth;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}
	
	
}
