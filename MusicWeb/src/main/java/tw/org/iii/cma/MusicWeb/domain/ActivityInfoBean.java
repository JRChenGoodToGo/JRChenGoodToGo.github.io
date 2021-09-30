package tw.org.iii.cma.MusicWeb.domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="ACTIVITYINFO")
public class ActivityInfoBean {
	
	@Id
	@Column(name="ACTIVITYID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityId;
	
	@Column(name="TAGID")
	private Integer tagId;
	
	@Column(name="BANDPOST", 
			columnDefinition = "text"
	)
	private String bandPost; 

	@Column(name="HOST")
	private String host; 

	@Column(name="PLAYER")
	private String player;          

	@Column(name="THEME")
	private String theme;              

	@Column(name="SUBTITLE")
	private String subTitle;       

	@Column(name="ACTIVITYINTRO", 
			columnDefinition = "text"
	)
	private String activityIntro;

	@Column(name="BANDINTRO", 
			columnDefinition = "text"
	)
	private String bandIntro;           

	@Column(name="LOCATIONID")
	private Integer locationId;        

	@Column(name="TAPE", 
			columnDefinition = "text"
	)
	private String tape;

	@Column(name="UPLOADTIME")
	private java.util.Date uploadTime;  

	@Column(name="PURCHASEWEB")
	private String purchaseWeb;  

	@Column(name="MEMBERID")
	private Integer memberId;
	
	@Column(
			name="CLICKAMT"
	)
	private Integer clickAmt = 0;
	
	@Lob
	@Column(name="PHOTO", 
			columnDefinition = "longblob"
	)
	private byte[] photo;

	@Override
	public String toString() {
		return "ActivityInfoBean [activityId=" + activityId + ", tagId=" + tagId + ", bandPost=" + bandPost + ", host="
				+ host + ", player=" + player + ", theme=" + theme + ", subTitle=" + subTitle + ", activityIntro="
				+ activityIntro + ", bandIntro=" + bandIntro + ", locationId=" + locationId + ", tape=" + tape
				+ ", uploadTime=" + uploadTime + ", purchaseWeb=" + purchaseWeb + ", memberId=" + memberId
				+ ", clickAmt=" + clickAmt + ", photo=" + Arrays.toString(photo) + "]";
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getBandPost() {
		return bandPost;
	}

	public void setBandPost(String bandPost) {
		this.bandPost = bandPost;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getActivityIntro() {
		return activityIntro;
	}

	public void setActivityIntro(String activityIntro) {
		this.activityIntro = activityIntro;
	}

	public String getBandIntro() {
		return bandIntro;
	}

	public void setBandIntro(String bandIntro) {
		this.bandIntro = bandIntro;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getTape() {
		return tape;
	}

	public void setTape(String tape) {
		this.tape = tape;
	}

	public java.util.Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(java.util.Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getPurchaseWeb() {
		return purchaseWeb;
	}

	public void setPurchaseWeb(String purchaseWeb) {
		this.purchaseWeb = purchaseWeb;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getClickAmt() {
		return clickAmt;
	}

	public void setClickAmt(Integer clickAmt) {
		this.clickAmt = clickAmt;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
