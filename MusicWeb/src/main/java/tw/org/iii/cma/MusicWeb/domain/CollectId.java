package tw.org.iii.cma.MusicWeb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class CollectId implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="MEMBERID")
	private Integer memberId;
	@Column(name="ACTIVITYID")
	private Integer activityId;
	
	public CollectId() {  
	}
	
	public CollectId(Integer memberId, Integer activityId) {
		super();
		this.memberId = memberId;
		this.activityId = activityId;
	}
	
	

	@Override
	public String toString() {
		return "CollectId [memberId=" + memberId + ", activityId=" + activityId + "]";
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
