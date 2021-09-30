package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.Serializable;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.C.Controller.ActivityInfoDetail;
import tw.org.iii.cma.MusicWeb.domain.CollectId;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;

@Repository
public class CollectInfoDAOHibernate implements CollectInfoDAO{
	@PersistenceContext
	private Session session;
//	public CollectInfoDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return session;
	}
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		CollectInfoDAO collectInfo = new CollectInfoDAOHibernate(sessionFactory);
//		
//// r1		
////		List<CollectInfoBean> selectActivityByMemberId = collectInfo.findActivityByMemberId(15, 3);
////		System.out.println(selectActivityByMemberId);
//		
//// r2		
////		Object countAllByMemberId = collectInfo.countAllCollectionByMemberId(15);
////		System.out.println(countAllByMemberId);
//		
//// r3		
////		List<CollectInfoBean> selectCollectPerson = collectInfo.findWhoCollect(8, 1);
////		System.out.println(selectCollectPerson);
//		
//// r4		
////		Object countAllByActivityId = collectInfo.countCollectAmt(8);
////		System.out.println(countAllByActivityId);
//		
//// r5		
////		CollectInfoBean insertObj = new CollectInfoBean();
////		insertObj.setMemberId(10);
////		insertObj.setActivityId(2);
////		CollectInfoBean resultInsert = collectInfo.insert(insertObj);
////		System.out.println(resultInsert);
//		
//// r6		
////		boolean deleteObj = collectInfo.delete(10, 4);
////		System.out.println(deleteObj);
//		
//		
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}
	@Override
	public List<CollectInfoBean> findActivityByMemberId(Integer memberId, Integer total) {
		if(memberId != null) {
			if(total != null) {
				List<CollectInfoBean> r11 = this.getSession().createQuery("FROM CollectInfoBean WHERE memberId = :memberId", CollectInfoBean.class)
						.setParameter("memberId", memberId)
						.setMaxResults(total)
						.list();
				if(r11 != null) {
					return r11;
				}
			} else {
				List<CollectInfoBean> r12 = this.getSession().createQuery("FROM CollectInfoBean WHERE memberId = :memberId", CollectInfoBean.class)
						.setParameter("memberId", memberId)
						.setMaxResults(3)
						.list();
				if(r12 != null) {
					System.out.println(r12.get(0).getCollectId().getActivityId());
					return r12;
				}
			}
		}
		return null;
	}
	@Override
	public Object countAllCollectionByMemberId(Integer memberId) {
		if(memberId != null) {
			Object r2 = this.getSession().createQuery("SELECT count(*) FROM CollectInfoBean WHERE memberId = :memberId")
				.setParameter("memberId", memberId)
				.uniqueResult();
			if(r2 != null) {
				return r2;
			}
		}
		return null;
	}
	
	@Override
	public List<CollectInfoBean> findWhoCollect(Integer activityId, Integer total) {
		if(activityId != null) {
			if(total != null) {
				List<CollectInfoBean> r31 = this.getSession().createQuery("FROM CollectInfoBean WHERE activityId = :activityId", CollectInfoBean.class)
						.setParameter("activityId", activityId)
						.setMaxResults(total)
						.list();
				if(r31 != null) {
					return r31;
				}
			} else {
				List<CollectInfoBean> r32 = this.getSession().createQuery("FROM CollectInfoBean WHERE activityId = :activityId", CollectInfoBean.class)
						.setParameter("activityId", activityId)
						.setMaxResults(3)
						.list();
				if(r32 != null) {
					return r32;
				}
			}
		}
		return null;
	}
	@Override
	public Object countCollectAmt(Integer activityId) {
		if(activityId != null) {
			Object r4 = this.getSession().createQuery("SELECT count(*) FROM CollectInfoBean WHERE activityId = :activityId")
				.setParameter("activityId", activityId)
				.uniqueResult();
			if(r4 != null) {
				return r4;
			}
		}
		return null;
	}
	@Override // r5
	public CollectInfoBean insert(CollectInfoBean bean) {
		if(bean != null && bean.getCollectId() != null) {
			System.out.println("enter CollectInfoDAOHibernate");
			CollectInfoBean checkData = this.getSession().get(CollectInfoBean.class, bean.getCollectId());
			if(checkData==null) {
				System.out.println("bean= " + bean);
				Serializable pk = this.getSession().save(bean);
				System.out.println("pk= " + pk);
				return bean;
			} else {
				return null;
			}
		}
		return null;
	}
	
	@org.springframework.transaction.annotation.Transactional
	@Override // r5_1
	public CollectInfoBean insert(Integer memberId, Integer activityId) {
		if(memberId != null && activityId != null) {
			CollectId collectId = new CollectId(memberId, activityId);
			CollectInfoBean checkData = this.getSession().get(CollectInfoBean.class, collectId);
			if(checkData==null) {
				System.out.println("memberId= " + memberId);
				System.out.println("activityId= " + activityId);
				CollectInfoBean collectInfoBean = new CollectInfoBean();
				collectInfoBean.setCollectId(collectId);
				Serializable pk = this.getSession().save(collectInfoBean);
				System.out.println("pk= " + pk);
				return collectInfoBean;
			} else {
				return null;
			}
		}
		return null;
	}
	
	@Transactional
	@Override
	public boolean delete(Integer memberId, Integer activityId) {
		if(memberId != null && activityId != null) {
			System.out.println("memberId= " + memberId);
			System.out.println("activityId= " + activityId);
			CollectInfoBean r6 = this.getSession().createQuery("FROM CollectInfoBean WHERE memberId = :memberId AND activityId = :activityId", CollectInfoBean.class)
				.setParameter("memberId", memberId)
				.setParameter("activityId", activityId)
				.uniqueResult();
			if(r6 != null) {
				System.out.println("r6= " + r6);
				this.getSession().delete(r6);
				return true;
			}
		}
		return false;
	}
	@Override 
	public List<ActivityInfoDetail> listDetail(Integer memberId) {
		if(memberId != null) {
			System.out.println("memberId != null");
			List<Object[]>  r7 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.photo, ac.bandIntro, ac.purchaseWeb, ac.clickAmt"
										+ ", time.showDate, loc.showAddr, loc.showPlace, time.enterTime, time.showTime, time.showTotalTime "
										+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
										+ "WHERE ac.tagId = tag.tagId AND ac.activityId = time.activityId AND ac.locationId=loc.locationId "
										+ "AND ac.activityId IN (SELECT collectId.activityId FROM CollectInfoBean WHERE memberId = :memberId)", Object[].class)
				.setParameter("memberId", memberId)
				.list();
			System.out.println(r7.get(0));
			if(r7!=null) {
				System.out.println("r22 != null");
				List<ActivityInfoDetail> list = new ArrayList<ActivityInfoDetail>();
				for(Object result[]: r7) {
//					System.out.println(result[1]);
					
					List<TicketSettingBean> ticketSetting = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId=:activityId", TicketSettingBean.class)
							.setParameter("activityId", result[0])
							.list();
					System.out.println("ticketSetting= " + ticketSetting);
					ActivityInfoDetail detail = new ActivityInfoDetail();
					detail.setActivityId((Integer)result[0]);
					detail.setBandPost((String)result[1]);
					detail.setTagName((String)result[2]);
					detail.setHost((String)result[3]);
					detail.setPlayer((String)result[4]);
					detail.setTheme((String)result[5]);
					detail.setSubTitle((String)result[6]);
					detail.setActivityIntro((String)result[7]);
					detail.setPhoto((byte[])result[8]);
					detail.setBandIntro((String)result[9]);
					detail.setPurchaseWeb((String)result[10]);
					detail.setClickAmt((Integer)result[11]);
					detail.setShowDate((java.util.Date)result[12]);
					detail.setShowAddr((String)result[13]);
					detail.setShowPlace((String)result[14]);
					detail.setEnterTime((java.time.LocalTime)result[15]);
					detail.setShowTime((java.time.LocalTime)result[16]);
					detail.setShowTotalTime((Integer)result[17]);
					detail.setTicketSettingInfo(ticketSetting);
					
					list.add(detail);
				}
				
				return list;
			}
		}
		return null;
	}
	
	@Override
	public Object testDatailList(Integer memberId, Integer activityId) {
		if(memberId!=null && activityId!=null) {
			CollectId collectId = new CollectId();
			collectId.setMemberId(memberId);
			collectId.setActivityId(activityId);
			List<Object> collectBean = this.getSession().createQuery("SELECT collectId.activityId FROM CollectInfoBean WHERE memberId = :memberId", Object.class)
						.setParameter("memberId", memberId)
						.list();
			if(collectBean!=null) {
				return collectBean;
			}
		}
		return null;
	}
}

