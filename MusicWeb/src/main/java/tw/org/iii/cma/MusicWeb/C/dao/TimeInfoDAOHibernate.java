package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

@Repository
public class TimeInfoDAOHibernate implements TimeInfoDAO{
	@PersistenceContext
	private Session session;
//	public TimeInfoDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return session;
	}
	
//	public static void main(String[] args) {
// 		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
// 		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
// 		
// 		TimeInfoDAO timeInfo = new TimeInfoDAOHibernate(sessionFactory);
// 	r1	
//// 		TimeInfoBean selectOne = timeInfo.select(1);
//// 		System.out.println(selectOne);
//
//// r2
//// 		List<TimeInfoBean> selectYM = timeInfo.findYearMonth(2021, 9, 3);
//// 		System.out.println(selectYM);
//
//// r3 		
//// 		List<TimeInfoBean> selectShowTime = timeInfo.findShowTime(13, 16, 4);
//// 		System.out.println(selectShowTime);
// 		
//// r4
//// 		List<TimeInfoBean> selectSeveral = timeInfo.selectAll(0, 3);
//// 		System.out.println(selectSeveral);
//
//// r5 		
//// 		Object count = timeInfo.countTotal();
//// 		System.out.println(count);
//
//// r6 		
//// 		TimeInfoBean insertObj = new TimeInfoBean();
//// 		String dateShow = "2021-10-30 14:00";
//// 		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//// 		LocalTime showTime = LocalTime.of(14, 00);
//// 		LocalTime enterTime = LocalTime.of(13, 30);
//// 		
//// 		try {
////	 		Date showDate = sdfDate.parse(dateShow);
////	 		insertObj.setShowDate(showDate);
////	 		insertObj.setShowTime(showTime);
////	 		insertObj.setEnterTime(enterTime);
////	 		insertObj.setShowTotalTime(100);
//// 		} catch(Exception e) {
//// 			e.printStackTrace();
//// 		}
//// 		TimeInfoBean resultInsert = timeInfo.insert(insertObj);
//// 		System.out.println(resultInsert);
// 
//// r7  		
//// 		TimeInfoBean updateObj = new TimeInfoBean();
//// 		String dateShow = "2021-10-30 14:00";
//// 		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//// 		LocalTime showTime = LocalTime.of(14, 00);
//// 		LocalTime enterTime = LocalTime.of(13, 30);
//// 		try {
////	 		Date showDate = sdfDate.parse(dateShow);
////	 		updateObj.setId(19);
////	 		updateObj.setShowDate(showDate);
////	 		updateObj.setShowTime(showTime);
////	 		updateObj.setEnterTime(enterTime);
////	 		updateObj.setShowTotalTime(100);
//// 		} catch(Exception e) {
//// 			e.printStackTrace();
//// 		}
////  		TimeInfoBean resultUdt = timeInfo.update(updateObj);
////  		System.out.println(resultUdt);
// 
//// r8 		
//// 		boolean deleteObj = timeInfo.delete(5);
//// 		System.out.println(deleteObj);
// 		
//// r9 
//// 		TimeInfoBean activityIdSelect = timeInfo.selectByActivityId(32);
//// 		System.out.println(activityIdSelect);
// 		
//// 		Object activityAmtCount = timeInfo.countActivityAmtByOption(2021, 9);
//// 		System.out.println(activityAmtCount);
//   r10		
// 		List<Object> activityIdList = timeInfo.listActivityIdByOption(2021, 9);
// 		System.out.println(activityIdList);
// 	 r11
// 		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
// 		HibernateUtil.closeSessionFactory();
//	}
	@Override
	public TimeInfoBean select(Integer id) {
		if(id != null) {
			TimeInfoBean r1 = this.getSession().get(TimeInfoBean.class, id);
			if(r1 != null) {
				return r1;
			}
		}
		return null;
	}
	@Override
	public List<TimeInfoBean> findYearMonth(Integer year, Integer month, Integer amount) {
		if(year != null && month != null) {
			if(amount != null) {
				List<TimeInfoBean> r21 = this.getSession().createQuery("FROM TimeInfoBean WHERE YEAR(showDate)= :year AND MONTH(showDate)= :month ORDER BY DATE(showDate) ASC", TimeInfoBean.class)
						.setParameter("year", year)
						.setParameter("month", month)
						.setMaxResults(amount)
						.list();
				return r21;
			} else {
				List<TimeInfoBean> r22 = this.getSession().createQuery("FROM TimeInfoBean WHERE YEAR(showDate)= :year AND MONTH(showDate)= :month ORDER BY DATE(showDate) ASC", TimeInfoBean.class)
						.setParameter("year", year)
						.setParameter("month", month)
						.setMaxResults(3)
						.list();
				return r22;
			}
		}
		return null;
	}
	@Override
	public List<TimeInfoBean> findShowTime(Integer time1, Integer time2, Integer amount) {
		if(time1 != null && time2 != null) {
			if(amount != null) {
				List<TimeInfoBean> r31 = this.getSession().createQuery("FROM TimeInfoBean WHERE HOUR(showTime) BETWEEN :time1 AND :time2 ORDER BY HOUR(showTime) ASC", TimeInfoBean.class)
						.setParameter("time1", time1)
						.setParameter("time2", time2)
						.setMaxResults(amount)
						.list();
				return r31;
			} else {
				List<TimeInfoBean> r32 = this.getSession().createQuery("FROM TimeInfoBean WHERE HOUR(showTime) BETWEEN :time1 AND :time2 ORDER BY HOUR(showTime) ASC", TimeInfoBean.class)
						.setParameter("time1", time1)
						.setParameter("time2", time2)
						.setMaxResults(3)
						.list();
				return r32;
			}
		}
		return null;
	}
	@Override
	public List<TimeInfoBean> selectAll(Integer start, Integer total) {
		if(start != null) {
			if(total != null) {
				List<TimeInfoBean> r41 = this.getSession().createQuery("FROM TimeInfoBean", TimeInfoBean.class)
						.setFirstResult(start)
						.setMaxResults(total)
						.list();
				return r41;
			} else {
				List<TimeInfoBean> r42 = this.getSession().createQuery("FROM TimeInfoBean", TimeInfoBean.class)
						.setFirstResult(start)
						.list();
				return r42;
			}
		} else {
			if(total == null) {
				List<TimeInfoBean> r43 = this.getSession().createQuery("FROM TimeInfoBean", TimeInfoBean.class)
						.setFirstResult(0)
						.setMaxResults(3)
						.list();
				return r43;
			} else {
				List<TimeInfoBean> r44 = this.getSession().createQuery("FROM TimeInfoBean", TimeInfoBean.class)
						.setFirstResult(0)
						.setMaxResults(total)
						.list();
				return r44;
			}
		}
	}
	@Override
	public Object countTotal() {
		Object r5 = this.getSession().createQuery("SELECT count(*) FROM TimeInfoBean").uniqueResult();
		return r5;
	}
	@Override //r6
	public TimeInfoBean insert(TimeInfoBean bean) {
		if(bean.getShowDate() != null && bean.getEnterTime() !=null && bean.getShowTime() != null) {
			Serializable pk = this.getSession().save(bean);
			System.out.println(pk);
			return bean;
		}
		return null;
	}
	@Transactional
	@Override
	public TimeInfoBean update(TimeInfoBean bean) {
		if(bean.getActivityId() != null && bean != null) {
			TimeInfoBean r7 = this.getSession().createQuery("FROM TimeInfoBean WHERE activityId = :activityId", TimeInfoBean.class)
				.setParameter("activityId", bean.getActivityId())
				.uniqueResult();
			if(r7 != null) {
//				System.out.println("r7 = " + r7);
//				System.out.println("bean = " + bean);
//				System.out.println("--------------");
//				System.out.println(bean.getShowDate() == null);
//				System.out.println(bean.getEnterTime() == null);
//				System.out.println(bean.getShowTime() == null);
//				System.out.println(bean.getShowTotalTime() == null);
				bean.setId(bean.getId() == null? r7.getId(): bean.getId());
				bean.setShowDate(bean.getShowDate()   == null? r7.getShowDate() : bean.getShowDate());
				bean.setEnterTime(bean.getEnterTime() == null? r7.getEnterTime() : bean.getEnterTime());
				bean.setShowTime(bean.getShowTime()   == null? r7.getShowTime(): bean.getShowTime());
				bean.setShowTotalTime(bean.getShowTotalTime() == null? r7.getShowTotalTime(): bean.getShowTotalTime());
				return (TimeInfoBean) this.getSession().merge(bean);
			}
//			TimeInfoBean r7 = this.getSession().get(TimeInfoBean.class, bean.getId());
//			if(r7 != null) {
//				return (TimeInfoBean) this.getSession().merge(bean);
//			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer activityId) {
		if(activityId != null) {
			TimeInfoBean r8 = this.getSession().createQuery("FROM TimeInfoBean WHERE activityId = :activityId", TimeInfoBean.class)
				.setParameter("activityId", activityId)
				.uniqueResult();
			if(r8 != null) {
				System.out.println("r8 = " + r8);
				this.getSession().delete(r8);
				return true;
			}
// 			TimeInfoBean r8 = this.getSession().get(TimeInfoBean.class, id);
// 			if(r8 != null) {
// 				this.getSession().delete(r8);
// 				return true;
// 			}
		}
		return false;
	}
	@Override
	public TimeInfoBean selectByActivityId(Integer activityId) {
		if(activityId != null) {
			TimeInfoBean r9 = this.getSession().createQuery("FROM TimeInfoBean WHERE activityId = :activityId", TimeInfoBean.class)
				.setParameter("activityId", activityId)
				.uniqueResult();
			if(r9 != null) {
				return r9;
			}
		}
		return null;
	}
	@Override
	public Object countActivityAmtByOption(Integer year, Integer month) {
		if(year != null && month != null) {
			Object r10 = this.getSession().createQuery("SELECT count(*) FROM TimeInfoBean WHERE YEAR(showDate)= :year AND MONTH(showDate)= :month")
					.setParameter("year", year)
					.setParameter("month", month)
					.uniqueResult();
			if(r10 != null) {
				return r10;
			}
		}
		return null;
	}
	@Override
	public List<Object> listActivityIdByOption(Integer year, Integer month) {
		if(year != null && month != null) {
			List<Object> r11 = this.getSession().createQuery("SELECT activityId FROM TimeInfoBean WHERE YEAR(showDate)= :year AND MONTH(showDate)= :month ORDER BY DATE(showDate) ASC", Object.class)
					.setParameter("year", year)
					.setParameter("month", month)
					.list();
			if(r11 != null) {
				return r11;
			}
		}
		return null;
	}
}
