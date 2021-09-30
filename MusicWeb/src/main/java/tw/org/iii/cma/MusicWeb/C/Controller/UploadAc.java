package tw.org.iii.cma.MusicWeb.C.Controller;

import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class UploadAc {

	private Integer activityId;
	private byte[] photo;
	private	String host;
	private String player;
	private String theme;
	private	String subTitle;
	private	String activityIntro;
	private	String bandIntro;
	private	Integer tagId;
	private	String tagName;
	private	String tape;
	private	String purchaseWeb;
	private	Integer memberId;
	private	Integer clickAmt;
	private Integer	locationId;
	private	String showAddr;
	private	String showPlace;
	private	java.util.Date showDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private	java.time.LocalTime enterTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private	java.time.LocalTime showTime;
	
	private	Integer showTotalTime;
	private	java.util.Date soldDeadline;
	private	String ticketKind1;
	private	Float cost1;
	private	Integer storage1;
	private	String ticketKind2;
	private	Float cost2;
	private Integer storage2;
	
	@Override
	public String toString() {
		return "UploadAc [activityId=" + activityId + ", photo=" + Arrays.toString(photo) + ", host=" + host
				+ ", player=" + player + ", theme=" + theme + ", subTitle=" + subTitle + ", activityIntro="
				+ activityIntro + ", bandIntro=" + bandIntro + ", tagId=" + tagId + ", tagName=" + tagName + ", tape="
				+ tape + ", purchaseWeb=" + purchaseWeb + ", memberId=" + memberId + ", clickAmt=" + clickAmt
				+ ", locationId=" + locationId + ", showAddr=" + showAddr + ", showPlace=" + showPlace + ", showDate="
				+ showDate + ", enterTime=" + enterTime + ", showTime=" + showTime + ", showTotalTime=" + showTotalTime
				+ ", soldDeadline=" + soldDeadline + ", ticketKind1=" + ticketKind1 + ", cost1=" + cost1 + ", storage1="
				+ storage1 + ", ticketKind2=" + ticketKind2 + ", cost2=" + cost2 + ", storage2=" + storage2 + "]";
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTape() {
		return tape;
	}
	public void setTape(String tape) {
		this.tape = tape;
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
	public java.util.Date getSoldDeadline() {
		return soldDeadline;
	}
	public void setSoldDeadline(java.util.Date soldDeadline) {
		this.soldDeadline = soldDeadline;
	}
	public String getTicketKind1() {
		return ticketKind1;
	}
	public void setTicketKind1(String ticketKind1) {
		this.ticketKind1 = ticketKind1;
	}
	public Float getCost1() {
		return cost1;
	}
	public void setCost1(Float cost1) {
		this.cost1 = cost1;
	}
	public Integer getStorage1() {
		return storage1;
	}
	public void setStorage1(Integer storage1) {
		this.storage1 = storage1;
	}
	public String getTicketKind2() {
		return ticketKind2;
	}
	public void setTicketKind2(String ticketKind2) {
		this.ticketKind2 = ticketKind2;
	}
	public Float getCost2() {
		return cost2;
	}
	public void setCost2(Float cost2) {
		this.cost2 = cost2;
	}
	public Integer getStorage2() {
		return storage2;
	}
	public void setStorage2(Integer storage2) {
		this.storage2 = storage2;
	}
}
