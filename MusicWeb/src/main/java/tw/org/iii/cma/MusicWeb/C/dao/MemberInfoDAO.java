package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;

public interface MemberInfoDAO {
	public abstract MemberInfoBean select(Integer id);
	public abstract List<MemberInfoBean> select(Integer start, Integer total);
	public abstract Object countTotal();
	public abstract MemberInfoBean insert(MemberInfoBean bean);
	public abstract boolean delete(Integer id);
	
	public abstract MemberInfoBean select(String account);
	public abstract MemberInfoBean update(String account, String newPasswd);
	public abstract boolean isAccountExist(String account);
}
