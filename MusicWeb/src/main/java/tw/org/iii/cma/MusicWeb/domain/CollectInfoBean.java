package tw.org.iii.cma.MusicWeb.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COLLECTINFO")
public class CollectInfoBean {

	@EmbeddedId
	private CollectId collectId;

	@Override
	public String toString() {
		return "CollectInfoBean [collectId=" + collectId + "]";
	}
	
	public CollectId getCollectId() {
		return collectId;
	}

	public void setCollectId(CollectId collectId) {
		this.collectId = collectId;
	}


	
}
