package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONINFO")
public class LocationInfoBean {

	@Id
	@Column(name="LOCATIONID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;
	
	@Column(name="SHOWADDR")
	private String showAddr; 
	
	@Column(name="SHOWPLACE")
	private String showPlace;

	@Override
	public String toString() {
		return "LocationInfoBean [locationId=" + locationId + ", showAddr=" + showAddr + ", showPlace=" + showPlace
				+ "]";
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getShowAddr() {
		return showAddr;
	}

	public void setShowAddr(String showAddr) {
		this.showAddr = showAddr;
	}

	public String getShowPlace() {
		return showPlace;
	}

	public void setShowPlace(String showPlace) {
		this.showPlace = showPlace;
	}
	
	
}
