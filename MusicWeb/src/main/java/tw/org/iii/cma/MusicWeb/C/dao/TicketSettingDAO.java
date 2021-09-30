package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

public interface TicketSettingDAO {
	public abstract List<TicketSettingBean> findFromActivityId(Integer activityId);
	public abstract Object countAll(Integer activityId);
	public abstract List<TicketSettingBean> findSoldDeadline(Integer year, Integer month, Integer day, Integer total);
	public abstract List<TicketSettingBean> findStorage(Integer amount1, Integer amount2, Integer total);
	public abstract List<TicketSettingBean> findCost(Float cost1, Float cost2, Integer total);
	public abstract TicketSettingBean insert(TicketSettingBean bean);
	public abstract TicketSettingBean update(String ticketKind, TicketSettingBean bean);
	public abstract boolean delete(Integer id);
	
	public abstract boolean deleteByOption(Integer activityId, String ticketKind);
	public abstract Object findIdentifier(Integer activityId, String ticketKind);
}
