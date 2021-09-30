package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.OrderInfoBean;

public interface OrderInfoDAO {
	public abstract OrderInfoBean select(Integer id);
	public abstract Object countNoActivityId();
	public abstract List<OrderInfoBean> selectNoActivityId();
	public abstract Object countByActivityId(Integer activityId);
	public abstract List<OrderInfoBean> selectActivityId(Integer activityId);
	public abstract Object countByMemberId(Integer memberId);
	public abstract List<OrderInfoBean> selectMemberId(Integer memberId);
	public abstract Object countTotal();
	public abstract List<OrderInfoBean> selectAll(Integer start, Integer total);
	public abstract OrderInfoBean insert(OrderInfoBean bean);
	public abstract Object findOrderIdByOption(Integer activityId, String ticketKind, String identification);
	public abstract OrderInfoBean update(OrderInfoBean bean); // 外掛
	public abstract OrderInfoBean update(String originalTicketKind, OrderInfoBean bean);
	public abstract boolean delete(Integer id);
}
