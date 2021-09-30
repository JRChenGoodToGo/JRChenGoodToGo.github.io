package tw.org.iii.cma.MusicWeb.C.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.MusicWeb.C.dao.OrderInfoDAO;
import tw.org.iii.cma.MusicWeb.C.dao.OrderInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.OrderInfoBean;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoDAO orderInfo;
	
//	public OrderInfoService(OrderInfoDAO orderInfo) {
//		this.orderInfo = orderInfo;
//	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//
//		OrderInfoService orderInfoService = new OrderInfoService(new OrderInfoDAOHibernate(sessionFactory));
//
////		OrderInfoBean selectOne = orderInfoService.select(1);
////		System.out.println(selectOne);
//		
////		Object countNoAcId = orderInfoService.countNoActivityId();
////		System.out.println(countNoAcId);
//		
////		List<OrderInfoBean> selectByAcId = orderInfoService.selectActivityId(3);
////		System.out.println(selectByAcId);
//		
////		List<OrderInfoBean> selectAll = orderInfoService.selectAll(0, 3);
////		System.out.println(selectAll);
//		
////	// r10		
////			OrderInfoBean insertObj = new OrderInfoBean();
////			insertObj.setName("Allen");
////			insertObj.setIdentification("A124577752");
////			insertObj.setEmail("allen@aaa.ss");
////			insertObj.setTicketKind("現場票"); // 注意TicketSetting庫存是否存在
////			insertObj.setCost(100.0f);
////			insertObj.setPurchaseAmt(3);
////			insertObj.setPayment("Credit");
////			insertObj.setMemberId(10);
////			insertObj.setActivityId(3); // 注意TicketSetting庫存是否存在
////			OrderInfoBean insertResult = orderInfoService.insert(insertObj);
////			System.out.println(insertResult);
//
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}
	
	public OrderInfoBean select(Integer id) {
		if(id!=null) {
			return orderInfo.select(id);
		}
		return null;
	}
	public Object countNoActivityId() {
		return orderInfo.countNoActivityId();
	}
	public List<OrderInfoBean> selectNoActivityId(){
		return orderInfo.selectNoActivityId();
	}
	public Object countByActivityId(Integer activityId) {
		if(activityId!=null) {
			return orderInfo.countByActivityId(activityId);
		}
		return null;
	}
	public List<OrderInfoBean> selectActivityId(Integer activityId){
		if(activityId!=null) {
			return orderInfo.selectActivityId(activityId);
		}
		return null;
	}
	public Object countByMemberId(Integer memberId) {
		if(memberId!=null) {
			return orderInfo.countByMemberId(memberId);
		}
		return null;
	}
	public List<OrderInfoBean> selectMemberId(Integer memberId){
		if(memberId!=null) {
			return orderInfo.selectMemberId(memberId);
		}
		return null;
	}
	public Object countTotal() {
		return orderInfo.countTotal();
	}
	public List<OrderInfoBean> selectAll(Integer start, Integer total){
		if(start!=null && total!=null) {
			return orderInfo.selectAll(start, total);
		}
		return null;
	}
	public OrderInfoBean insert(OrderInfoBean bean) {
		if(bean!=null) {
			return orderInfo.insert(bean);
		}
		return null;
	}
	public Object findOrderIdByOption(Integer activityId, String ticketKind, String identification) {
		if(activityId!=null && ticketKind!=null && !ticketKind.isEmpty() && identification!=null && !identification.isEmpty()) {
			return orderInfo.findOrderIdByOption(activityId, ticketKind, identification);
		}
		return null;
	}
	public OrderInfoBean update(String originalTicketKind, OrderInfoBean bean) {
		if(bean!=null) {
			return orderInfo.update(originalTicketKind, bean);
		}
		return null;
	}
	public boolean delete(Integer id) {
		if(id!= null) {
			return orderInfo.delete(id);
		}
		return false;
	}
}
