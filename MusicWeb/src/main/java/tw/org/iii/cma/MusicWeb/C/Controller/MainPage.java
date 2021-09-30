package tw.org.iii.cma.MusicWeb.C.Controller;


import java.util.Arrays;

import javax.persistence.Lob;

public class MainPage {

	private Integer activityId;
	private String bandPost;
	private String tagName;//補上host, player
	
	private String host;
	private String player;
	
	private String theme;
	private String subTitle;
	private String activityIntro;
	private Integer clickAmt;
	private byte[] photo;
	private String showAddr;
	
	@Override
	public String toString() {
		return "MainPage [activityId=" + activityId + ", bandPost=" + bandPost + ", tagName=" + tagName + ", host="
				+ host + ", player=" + player + ", theme=" + theme + ", subTitle=" + subTitle + ", activityIntro="
				+ activityIntro + ", clickAmt=" + clickAmt + ", photo=" + Arrays.toString(photo) + ", showAddr="
				+ showAddr + "]";
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
	public String getShowAddr() {
		return showAddr;
	}
	public void setShowAddr(String showAddr) {
		this.showAddr = showAddr;
	}

}
