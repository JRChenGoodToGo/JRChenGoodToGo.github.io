package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERINFO")
public class OrderInfoBean {

	@Id
	@Column(name="ORDERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@Column(name="NAME")
	private String  name;

	@Column(name="IDENTIFICATION")
	private String  identification;
	
	@Column(name="EMAIL")
	private String  email;
	
	@Column(name="TICKETKIND")
	private String  ticketKind;
	
	@Column(name="COST")
	private Float   cost;
	
	@Column(name="PURCHASEAMT", 
			columnDefinition = "smallint"
	)
	private Integer purchaseAmt;
	
	@Column(name="PAYMENT")
	private String  payment;
	
	@Column(name="MEMBERID")
	private Integer memberId;

	@Column(name="ACTIVITYID")
	private Integer activityId;

	@Override
	public String toString() {
		return "OrderInfoBean [orderId=" + orderId + ", name=" + name + ", identification=" + identification
				+ ", email=" + email + ", ticketKind=" + ticketKind + ", cost=" + cost + ", purchaseAmt=" + purchaseAmt
				+ ", payment=" + payment + ", memberId=" + memberId + ", activityId=" + activityId + "]";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTicketKind() {
		return ticketKind;
	}

	public void setTicketKind(String ticketKind) {
		this.ticketKind = ticketKind;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Integer getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(Integer purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
}
