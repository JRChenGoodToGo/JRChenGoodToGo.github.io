package tw.org.iii.cma.MusicWeb.C.Service;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.MusicWeb.C.dao.TicketSettingDAO;
import tw.org.iii.cma.MusicWeb.C.dao.TicketSettingDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

@Service
public class TicketSettingService {
	@Autowired
	private TicketSettingDAO ticketSettingDao;
	public TicketSettingService(TicketSettingDAO ticketSettingDao) {
		this.ticketSettingDao = ticketSettingDao;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		TicketSettingService ticketSettingService = new TicketSettingService(new TicketSettingDAOHibernate(sessionFactory));
//		
////		List<TicketSettingBean> ticketListByActivityId = ticketSettingService.listTicketSettingByActivityId(3);
////		System.out.println(ticketListByActivityId);
//		
////		Object count = ticketSettingService.countByActivityId(3);
////		System.out.println(count);
//		
////		List<TicketSettingBean> soldDeadlineList = ticketSettingService.listBySoldDeadline(2021, 10, 10, null);
////		System.out.println(soldDeadlineList);
//		
////		List<TicketSettingBean> leftStorageList = ticketSettingService.listByStorage(20, 50, null);
////		System.out.println(leftStorageList);
//		
////		List<TicketSettingBean> costList = ticketSettingService.listByCost(50.0f, 400.0f, 5);
////		System.out.println(costList);
//		
////		TicketSettingBean insertObj = new TicketSettingBean();
////		String deadlineSold = "2021-11-10 15:30:00";
////		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		try {
////			Date soldDeadline = sdfDate.parse(deadlineSold);
////			insertObj.setTicketKind("愛心票");
////			insertObj.setCost(50.0f);
////			insertObj.setStorage(30);
////			insertObj.setSoldDeadline(soldDeadline);
////		} catch(Exception e) {
////			e.printStackTrace();
////		}
////		TicketSettingBean resultInsert = ticketSettingService.insertTicketSetting(insertObj);
////		System.out.println(resultInsert);
//		
////		TicketSettingBean updateObj = new TicketSettingBean();
////		String deadlineSold = "2021-11-20 12:00:00";
////		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		try {
////			Date soldDeadline = sdfDate.parse(deadlineSold);
////			updateObj.setTicketKind("貓貓票");
////			updateObj.setCost(240.0f);
////			updateObj.setStorage(20);
////			updateObj.setSoldDeadline(soldDeadline);
////		} catch(Exception e) {
////			e.printStackTrace();
////		}
////		TicketSettingBean resultUpdate = ticketSettingService.updateTicketSetting(36, "浪人票", updateObj);
////		System.out.println(resultUpdate);
//		
////		boolean deleteByIdentifier = ticketSettingService.delete(12);
////		System.out.println(deleteByIdentifier);
//		
////		boolean optionDelete = ticketSettingService.deleteByOption(3, null);
////		System.out.println(optionDelete);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}
	
	public List<TicketSettingBean> listTicketSettingByActivityId(Integer activityId){
		if(activityId != null) {
			return ticketSettingDao.findFromActivityId(activityId);
		}
		return null;
	}
	public Object countByActivityId(Integer activityId) {
		if(activityId != null) {
			return ticketSettingDao.countAll(activityId);
		}
		return null;
	}
	public List<TicketSettingBean> listBySoldDeadline(Integer year, Integer month, Integer day, Integer total){
		if(year != null && month != null && day != null) {
			return ticketSettingDao.findSoldDeadline(year, month, day, total);
		}
		return null;
	}
	public List<TicketSettingBean> listByStorage(Integer amount1, Integer amount2, Integer total){
		if(amount1 != null && amount2 != null) {
			return ticketSettingDao.findStorage(amount1, amount2, total);
		}
		return null;
	}
	public List<TicketSettingBean> listByCost(Float cost1, Float cost2, Integer total){
		if(cost1 != null && cost2 != null) {
			return ticketSettingDao.findCost(cost1, cost2, total); 
		}
		return null;
	}
	public TicketSettingBean insertTicketSetting(TicketSettingBean bean) {
		if(bean != null) {
			return ticketSettingDao.insert(bean); 
		}
		return null;
	}
	// 模擬客戶僅傳回活動編號跟欲更新的內容，從客戶欲更新的內容查找identifier呼叫方法做更新
	public TicketSettingBean updateTicketSetting(Integer activityId, String ticketKind, TicketSettingBean bean) {
		System.out.println("prepare update");
		if(activityId != null && bean != null) {
			Object identifier = ticketSettingDao.findIdentifier(activityId, ticketKind);
			if(ticketKind != null) { // 指定該活動編號某票種做修改
				System.out.println("identifier=" + identifier);
				bean.setId((Integer) identifier);
				bean.setActivityId(activityId);
				System.out.println("bean" + bean);
				return ticketSettingDao.update(ticketKind, bean);
			} else { // 該活動編號只有一筆票種
				System.out.println("identifier=" + identifier);
				bean.setId((Integer) identifier);
				bean.setActivityId(activityId);
				System.out.println("bean" + bean);
				return ticketSettingDao.update(null, bean);
			}
		}
		return null;
	}
	public boolean delete(Integer id) {
		if(id != null) {
			return ticketSettingDao.delete(id);
		}
		return false;
	}
	public boolean deleteByOption(Integer activityId, String ticketKind) {
		if(activityId != null) {
			return ticketSettingDao.deleteByOption(activityId, ticketKind);
		}
		return false;
	}
}
