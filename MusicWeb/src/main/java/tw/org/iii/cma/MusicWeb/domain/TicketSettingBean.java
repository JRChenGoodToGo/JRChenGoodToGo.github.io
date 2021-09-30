package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="TICKETSETTING")
public class TicketSettingBean {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="TICKETKIND")
	private String ticketKind;
	
	@Column(name="COST")
	private Float  cost;
	
	@Column(name="STORAGE", 
			columnDefinition = "smallint"
	)
	private Integer storage;
	
	@Column(name="SOLDDEADLINE")
	private java.util.Date soldDeadline;
	
	@Column(name="ACTIVITYID")
	private Integer activityId;

	@Override
	public String toString() {
		return "TicketSettingBean [Id=" + Id + ", ticketKind=" + ticketKind + ", cost=" + cost + ", storage=" + storage
				+ ", soldDeadline=" + soldDeadline + ", activityId=" + activityId + "]";
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public java.util.Date getSoldDeadline() {
		return soldDeadline;
	}

	public void setSoldDeadline(java.util.Date soldDeadline) {
		this.soldDeadline = soldDeadline;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
}
