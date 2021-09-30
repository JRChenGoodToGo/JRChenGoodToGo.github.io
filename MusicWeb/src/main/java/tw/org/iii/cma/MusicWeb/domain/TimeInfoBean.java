package tw.org.iii.cma.MusicWeb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;






import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="TIMEINFO")
public class TimeInfoBean {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="SHOWDATE")
	private java.util.Date showDate;
	
	@Column(name="ENTERTIME")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private java.time.LocalTime enterTime;
	
	@Column(name="SHOWTIME")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private java.time.LocalTime showTime;
	
	@Column(name="SHOWTOTALTIME")
	private Integer showTotalTime;

	@Column(name="ACTIVITYID")
	private Integer activityId;

	@Override
	public String toString() {
		return "TimeInfoBean [id=" + id + ", showDate=" + showDate + ", enterTime=" + enterTime + ", showTime="
				+ showTime + ", showTotalTime=" + showTotalTime + ", activityId=" + activityId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getShowDate() {
		return showDate;
	}

	public void setShowDate(java.util.Date showDate) {
		this.showDate = showDate;
	}

	public java.time.LocalTime getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(java.time.LocalTime enterTime) {
		this.enterTime = enterTime;
	}

	public java.time.LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(java.time.LocalTime showTime) {
		this.showTime = showTime;
	}

	public Integer getShowTotalTime() {
		return showTotalTime;
	}

	public void setShowTotalTime(Integer showTotalTime) {
		this.showTotalTime = showTotalTime;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	
}

