package tw.org.iii.cma.MusicWeb.C.Controller;

import java.util.Arrays;
import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

public class ActivityInfoDetail {

	private Integer activityId;
	private String bandPost;
	private String tagName;
	private String host;
	private String player; // "accusefive",
	private String theme; // "今晚我想來點...",
	private String subTitle; // "南應最棒的小妞滷味is here",
	private String activityIntro; // "麻辣鴨血辣辣炒香麵團團圓圓",
	private byte[] photo; 
	private String bandIntro; // "我們是告五人!!",
	private String purchaseWeb; // "http://xxxxx.com.errier",
	private Integer clickAmt; // 6,
	private java.util.Date showDate; // "2021-09-08T16:00:00.000+00:00",
	private String showAddr; // "台中市西屯區安和路117號",
	private String showPlace; // "Legacy Taichung 傳 音樂展演空間",
	private java.time.LocalTime enterTime; // "19:00:00",
	private java.time.LocalTime showTime; // "19:30:00",
	private Integer showTotalTime; // 120,
	private List<TicketSettingBean> ticketInfo; // "預售票", // 200,
	
	@Override
	public String toString() {
		return "ActivityInfoDetail [activityId=" + activityId + ", bandPost=" + bandPost + ", tagName=" + tagName
				+ ", host=" + host + ", player=" + player + ", theme=" + theme + ", subTitle=" + subTitle
				+ ", activityIntro=" + activityIntro + ", photo=" + Arrays.toString(photo) + ", bandIntro=" + bandIntro
				+ ", purchaseWeb=" + purchaseWeb + ", clickAmt=" + clickAmt + ", showDate=" + showDate + ", showAddr="
				+ showAddr + ", showPlace=" + showPlace + ", enterTime=" + enterTime + ", showTime=" + showTime
				+ ", showTotalTime=" + showTotalTime + ", ticketInfo=" + ticketInfo + ", soldDeadline="
				+ "]";
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getBandPost() {
		return bandPost;
	}
	public void setBandPost(String bandPost) {
		this.bandPost = bandPost;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getBandIntro() {
		return bandIntro;
	}
	public void setBandIntro(String bandIntro) {
		this.bandIntro = bandIntro;
	}
	public String getPurchaseWeb() {
		return purchaseWeb;
	}
	public void setPurchaseWeb(String purchaseWeb) {
		this.purchaseWeb = purchaseWeb;
	}
	public Integer getClickAmt() {
		return clickAmt;
	}
	public void setClickAmt(Integer clickAmt) {
		this.clickAmt = clickAmt;
	}
	public java.util.Date getShowDate() {
		return showDate;
	}
	public void setShowDate(java.util.Date showDate) {
		this.showDate = showDate;
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
	public List<TicketSettingBean> getTicketSettingInfo() {
		return ticketInfo;
	}
	public void setTicketSettingInfo(List<TicketSettingBean> ticketSettingInfo) {
		this.ticketInfo = ticketSettingInfo;
	}
}
