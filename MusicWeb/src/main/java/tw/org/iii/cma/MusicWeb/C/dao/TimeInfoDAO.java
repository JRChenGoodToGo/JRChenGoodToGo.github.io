package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

public interface TimeInfoDAO {
	public abstract TimeInfoBean select(Integer id);
	public abstract List<TimeInfoBean> findYearMonth(Integer year, Integer month, Integer amount);
	public abstract List<TimeInfoBean> findShowTime(Integer time1, Integer time2, Integer amount);
	public abstract List<TimeInfoBean> selectAll(Integer start, Integer total);
	public abstract Object countTotal();
	public abstract TimeInfoBean insert(TimeInfoBean bean);
	public abstract TimeInfoBean update(TimeInfoBean bean);
	public abstract boolean delete(Integer activityId);
	public abstract TimeInfoBean selectByActivityId(Integer activityId);
	public abstract Object countActivityAmtByOption(Integer year, Integer month);
	public abstract List<Object> listActivityIdByOption(Integer year, Integer month);
}
