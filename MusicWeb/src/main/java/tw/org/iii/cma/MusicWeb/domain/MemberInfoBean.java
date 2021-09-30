package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBERINFO")
public class MemberInfoBean {
	
	@Id
	@Column(name="MEMBERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	@Column(name="ACCOUNT")
	private String account;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWD")
	private String passwd;
	
	@Column(name="NAME")
	private String name;

	@Override
	public String toString() {
		return "MemberInfoBean [memberId=" + memberId + ", account=" + account + ", email=" + email + ", passwd="
				+ passwd + ", name=" + name + "]";
	}
	
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
