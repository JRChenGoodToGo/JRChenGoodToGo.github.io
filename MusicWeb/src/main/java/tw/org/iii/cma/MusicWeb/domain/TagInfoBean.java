package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAGINFO")
public class TagInfoBean {

	@Id
	@Column(name="TAGID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tagId;
	
	@Column(name="TAGNAME")
	private String tagName;

	@Override
	public String toString() {
		return "TagInfoBean [tagId=" + tagId + ", tagName=" + tagName + "]";
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

	
	
}
