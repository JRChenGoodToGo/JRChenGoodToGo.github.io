package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;

public interface LocationInfoDAO {
	public abstract LocationInfoBean select(Integer id);
	public abstract List<LocationInfoBean> select(Integer start, Integer total);
	public abstract Object countTotal();
	public abstract List<List<Object>> findAddrKeyWord(String keyword);
	public abstract LocationInfoBean insert(LocationInfoBean bean);
	public abstract LocationInfoBean update(String showPlace, LocationInfoBean bean);
	public abstract boolean delete(String showPlace);
	
	public abstract Object findIdByAddr(String showAddr);

}
