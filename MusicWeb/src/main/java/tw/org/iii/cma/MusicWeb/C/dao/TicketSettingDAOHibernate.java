package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

@Repository
public class TicketSettingDAOHibernate implements TicketSettingDAO{
	@PersistenceContext
	private Session session;
//	public TicketSettingDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return session;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		TicketSettingDAO ticketSetting = new TicketSettingDAOHibernate(sessionFactory);
//		
//// r1		
////		List<TicketSettingBean> selectOne = ticketSetting.findFromActivityId(2);
////		System.out.println(selectOne);
//		
//// r2		
////		Object count = ticketSetting.countAll(3);
////		System.out.println(count);
//		
//// r3		
////		List<TicketSettingBean> selectFromSoldDeadline = ticketSetting.findSoldDeadline(2021, 10, 10, 2);
////		System.out.println(selectFromSoldDeadline);
//		
//// r4		
////		List<TicketSettingBean> selectFromStorage = ticketSetting.findStorage(20, 30, 2);
////		System.out.println(selectFromStorage);
//		
//// r5		
////		List<TicketSettingBean> selectFromCost = ticketSetting.findCost(100f, 800f, 4);
////		System.out.println(selectFromCost);
//		
//// r6		
////		TicketSettingBean insertObj = new TicketSettingBean();
////		String deadlineSold = "2021-11-25 12:00:00";
////		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		
////		try {
////			Date soldDeadline = sdfDate.parse(deadlineSold);
////			
////			insertObj.setTicketKind("愛心票");
////			insertObj.setCost(50.0f);
////			insertObj.setStorage(30);
////			insertObj.setSoldDeadline(soldDeadline);
////		} catch(Exception e) {
////			e.printStackTrace();
////		}
////		TicketSettingBean resultInsert = ticketSetting.insert(insertObj);
////		System.out.println(resultInsert);
//		
//// r7		
////		TicketSettingBean updateObj = new TicketSettingBean();
////		String deadlineSold = "2021-11-20 12:00:00";
////		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		
////		try {
////			Date soldDeadline = sdfDate.parse(deadlineSold);
////			updateObj.setId(8);
////			updateObj.setTicketKind("團體票");
////			updateObj.setCost(120.0f);
////			updateObj.setStorage(20);
////			updateObj.setSoldDeadline(soldDeadline);
////			updateObj.setActivityId(12);
////		} catch(Exception e) {
////			e.printStackTrace();
////		}
////		TicketSettingBean resultUpdate = ticketSetting.update(updateObj);
////		System.out.println(resultUpdate);
//		
//// r8		
//		boolean deleteObj = ticketSetting.delete(null);
//		System.out.println(deleteObj);
//		
//// r91		
////		boolean deleteOption = ticketSetting.deleteByOption(2, null);
////		System.out.println("deleteObj= " + deleteOption);
//
//// r10
////		Object identifierFind = ticketSetting.findIdentifier(2, "身障票");
////		System.out.println(identifierFind);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}
	@Override
	public List<TicketSettingBean> findFromActivityId(Integer activityId) {
		if(activityId != null) {
			List<TicketSettingBean> r1 = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId = :activityId ORDER BY storage DESC", TicketSettingBean.class)
				.setParameter("activityId", activityId)
				.list();
			if(r1 != null) {
				return r1;
			}
//			TicketSettingBean r1 = this.getSession().get(TicketSettingBean.class, id);
//			if(r1 != null) {
//				return r1;
//			}
		}
		return null;
	}
	@Override
	public Object countAll(Integer activityId) {
		if(activityId != null) {
			Object r2 = this.getSession().createQuery("SELECT count(*) FROM TicketSettingBean WHERE activityId = :id")
				.setParameter("id", activityId)
				.uniqueResult();
				
			if(r2 != null) {
				return r2;
			}
		}
		return null;
	}
	
	@Override
	public List<TicketSettingBean> findSoldDeadline(Integer year, Integer month, Integer day, Integer total) {
		if(year != null && month != null && day != null) {
			if(total != null) {
				List<TicketSettingBean> r31 = this.getSession().createQuery("FROM TicketSettingBean WHERE "
						+ "YEAR(soldDeadline)= :year AND MONTH(soldDeadline)= :month AND "
						+ "DAY(soldDeadline)= :day ORDER BY DATE(soldDeadline) ASC", TicketSettingBean.class)
						.setParameter("year", year)
						.setParameter("month", month)
						.setParameter("day", day)
						.setMaxResults(total)
						.list();
				return r31;
				
			} else {
				List<TicketSettingBean> r32 = this.getSession().createQuery("FROM TicketSettingBean WHERE "
						+ "YEAR(soldDeadline)= :year AND MONTH(soldDeadline)= :month AND "
						+ "DAY(soldDeadline)= :day ORDER BY DATE(soldDeadline) ASC", TicketSettingBean.class)
						.setParameter("year", year)
						.setParameter("month", month)
						.setParameter("day", day)
						.setMaxResults(3)
						.list();
				return r32;
			}
		}
		return null;
	}
	@Override
	public List<TicketSettingBean> findStorage(Integer amount1, Integer amount2, Integer total) {
		if(amount1 != null && amount2 != null) {
			if(total != null) {
				List<TicketSettingBean> r41 = this.getSession().createQuery("FROM TicketSettingBean WHERE storage BETWEEN :amount1 AND :amount2 ORDER BY soldDeadline", TicketSettingBean.class)
						.setParameter("amount1", amount1)
						.setParameter("amount2", amount2)
						.setMaxResults(total)
						.list();
				return r41;
			} else {
				List<TicketSettingBean> r42= this.getSession().createQuery("FROM TicketSettingBean WHERE storage BETWEEN :amount1 AND :amount2 ORDER BY soldDeadline", TicketSettingBean.class)
						.setParameter("amount1", amount1)
						.setParameter("amount2", amount2)
						.setMaxResults(3)
						.list();
				return r42;
			}
		}
		return null;
	}
	@Override
	public List<TicketSettingBean> findCost(Float cost1, Float cost2, Integer total) {
		if(!cost1.isNaN() && !cost2.isNaN()) {
			if(total != null) {
				List<TicketSettingBean> r51 = this.getSession().createQuery("FROM TicketSettingBean WHERE cost BETWEEN :cost1 AND :cost2 ORDER BY cost DESC", TicketSettingBean.class)
						.setParameter("cost1", cost1)
						.setParameter("cost2", cost2)
						.setMaxResults(total)
						.list();
				return r51;
			} else {
				List<TicketSettingBean> r52 = this.getSession().createQuery("FROM TicketSettingBean WHERE cost BETWEEN :cost1 AND :cost2 ORDER BY cost DESC", TicketSettingBean.class)
						.setParameter("cost1", cost1)
						.setParameter("cost2", cost2)
						.setMaxResults(3)
						.list();
				return r52;
			}
		}
		return null;
	}
	@Override // r6
	public TicketSettingBean insert(TicketSettingBean bean) {
		if(bean != null && bean.getTicketKind() != null && bean.getCost()!= null && bean.getStorage() != null && bean.getSoldDeadline() != null) {
			Serializable pk = this.getSession().save(bean);
			System.out.println(pk);
			return bean;
		}
		return null;
	}
	@Transactional
	@Override
	public TicketSettingBean update(String ticketKind, TicketSettingBean newBean) {
		if(newBean.getActivityId() != null && newBean != null) {
			if(ticketKind != null && !ticketKind.isEmpty()) {
				// 指定某票種要改成什麼
				TicketSettingBean r71 = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId = :activityId AND ticketKind = :ticketKind", TicketSettingBean.class)
				.setParameter("activityId", newBean.getActivityId())
				.setParameter("ticketKind", ticketKind)
				.uniqueResult();
				if(r71 != null) {
					newBean.setId(r71.getId());
					newBean.setTicketKind(newBean.getTicketKind() == null? r71.getTicketKind(): newBean.getTicketKind());
					newBean.setCost(newBean.getCost() == null? r71.getCost(): newBean.getCost());
					newBean.setStorage(newBean.getStorage() == null? r71.getStorage(): newBean.getStorage());
					newBean.setSoldDeadline(newBean.getSoldDeadline() == null? r71.getSoldDeadline(): newBean.getSoldDeadline());
					return (TicketSettingBean) this.getSession().merge(newBean);
				}
				
			} else {
				// 不指定票種，代表該活動編號可能只有一筆票券資訊
				TicketSettingBean r72 = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId = :activityId", TicketSettingBean.class)
					.setParameter("activityId", newBean.getActivityId())
					.uniqueResult();
				
				if(r72 != null) {
					newBean.setId(r72.getId());
					newBean.setTicketKind(newBean.getTicketKind() == null? r72.getTicketKind(): newBean.getTicketKind());
					newBean.setCost(newBean.getCost() == null? r72.getCost(): newBean.getCost());
					newBean.setStorage(newBean.getStorage() == null? r72.getStorage(): newBean.getStorage());
					newBean.setSoldDeadline(newBean.getSoldDeadline() == null? r72.getSoldDeadline(): newBean.getSoldDeadline());
					return (TicketSettingBean) this.getSession().merge(newBean);
				}
			}
		}
		return null;
		
//		if(bean != null && bean.getId() != null && bean.getTicketKind() != null && bean.getCost()!= null && bean.getSoldDeadline() != null && bean.getActivityId() != null) {
//			TicketSettingBean r7 = this.getSession().get(TicketSettingBean.class, bean.getId());
//			if(r7 != null) {
//				return (TicketSettingBean) this.getSession().merge(bean);
//			}
//		}
//		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id != null) {
			TicketSettingBean r8 = this.getSession().get(TicketSettingBean.class, id);
			if(r8 != null) {
				this.getSession().delete(r8);
				return true;
			}
		}
		return false;
	}
	@Transactional
	@Override
	public boolean deleteByOption(Integer activityId, String ticketKind) {
		if(activityId != null) {
			if(ticketKind != null) { // 該活動編號不只一種票種
				System.out.println("ticketKind1 = " + ticketKind);
				Object r91 = this.findIdentifier(activityId, ticketKind);
				TicketSettingBean r911 = this.getSession().createQuery("FROM TicketSettingBean WHERE id = :id", TicketSettingBean.class)
					.setParameter("id", r91)
					.uniqueResult();
				this.getSession().delete(r911);
				return true;
			} else if(ticketKind == null) { // 該活動編號只有一種票種
				int r92 = this.getSession().createQuery("DELETE FROM TicketSettingBean WHERE activityId = :activityId")
					.setParameter("activityId", activityId)
					.executeUpdate();
				System.out.println(r92);
				if(r92 != 0) {
					return true;
				} else {
					System.out.println("no data");
				}
			}
		}
		return false;
	}
	@Override
	public Object findIdentifier(Integer activityId, String ticketKind) {
		if(activityId != null) {
			if(ticketKind != null && !ticketKind.isEmpty()) {
				TicketSettingBean r10 = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId = :activityId AND ticketKind = :ticketKind", TicketSettingBean.class)
						.setParameter("activityId", activityId)
						.setParameter("ticketKind", ticketKind)
						.uniqueResult();
				return r10.getId();
			} else { // 不指定票種，代表該活動編號只有一種票種
				TicketSettingBean r10 = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId = :activityId", TicketSettingBean.class)
					.setParameter("activityId", activityId)
					.uniqueResult();
				return r10.getId();
			}
		}
		return null;
	}
}
