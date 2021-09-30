package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;


@Repository
public class LocationInfoDAOHibernate implements LocationInfoDAO{
	@PersistenceContext
	private Session session;
//	public LocationInfoDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return session;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		LocationInfoDAO locationInfo = new LocationInfoDAOHibernate(sessionFactory);
//	r1	
////		LocationInfoBean selectOne = locationInfo.select(1);
////		System.out.println(selectOne);
//	r2	
////		List<LocationInfoBean> selectSeveral = locationInfo.select(0, 1);
////		System.out.println(selectSeveral);
//	r3	
////		Object count = locationInfo.countTotal();
////		System.out.println(count);
//		
//// r4		
//		List<Object> selectKeyWord = locationInfo.findAddrKeyWord("台中");
//		System.out.println(selectKeyWord);
//		
//// r5		
////		LocationInfoBean insertObj = new LocationInfoBean();
////		insertObj.setShowAddr("桃園市大園區航翔路1號");
////		insertObj.setShowPlace("星宇航空運籌中心");
////		LocationInfoBean resultInsert = locationInfo.insert(insertObj);
////		System.out.println(resultInsert);
//		
//// r6		
////		LocationInfoBean updateObj = new LocationInfoBean();
////		updateObj.setLocationId(1);
////		updateObj.setShowAddr("台中市西屯區安和路118號");
////		updateObj.setShowPlace("Legacy Taichung 傳 音樂展演空間1");
////		LocationInfoBean resultUdt = locationInfo.update("Legacy Taichung 傳 音樂展演空間", updateObj);
////		System.out.println(resultUdt);
//		
////		boolean deleteObj = locationInfo.delete("星宇航空運籌中心");
////		System.out.println(deleteObj);
	
//	// r7	
//			boolean resultDelete = locationInfo.delete("星宇航空運籌中心");
//			System.out.println(resultDelete);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.getSessionFactory().getCurrentSession().close();
//		HibernateUtil.closeSessionFactory();
//	}

	@Override
	public LocationInfoBean select(Integer id) {
		if(id != null) {
			LocationInfoBean r1 =  this.getSession().get(LocationInfoBean.class, id);
			if(r1 != null) {
				return r1;
			}
		}
		return null;
	}

	@Override
	public List<LocationInfoBean> select(Integer start, Integer total) {
		if(start != null && total != null) {
			List<LocationInfoBean> r2 = this.getSession().createQuery("FROM LocationInfoBean", LocationInfoBean.class)
				.setFirstResult(start)
				.setMaxResults(total)
				.list();
			return r2;
		}
		return null;
	}

	@Override
	public Object countTotal() {
		Object r3 = this.getSession().createQuery("SELECT count(*) FROM LocationInfoBean").getSingleResult();
		return r3;
	}

	@Override
	public List<List<Object>> findAddrKeyWord(String keyword) { // find locationId
		System.out.println("hello, keyword = " + keyword);
		if(!keyword.isEmpty() && !keyword.isBlank() && keyword != null) {
			System.out.println("keyword in locationInfoDAOHibernate != null");
			List<String> listString = new ArrayList<String>();
			if(keyword.equals("中")) {
				listString.add("中");
				listString.add("彰");
			}
			System.out.println("listString= " + listString);
			List<List<Object>> idList = new ArrayList<List<Object>>();
			for(String result: listString) {
				List<Object> r4 = this.getSession().createQuery("SELECT locationId FROM LocationInfoBean WHERE showAddr LIKE :word", Object.class)
						.setParameter("word", "%"+ result + "%")
						.list();
				idList.add(r4); 
			}
			return idList ; // [[1, ...], [..., ...], , ]
		}
		return null;
	}

	@Override // r5
	public LocationInfoBean insert(LocationInfoBean bean) {
		if(bean != null && bean.getShowAddr() != null && bean.getShowPlace() != null) {
			Serializable pk = this.getSession().save(bean);
			System.out.println("pk = " + pk);
			return bean;
		}
		return null;
	}

	@Override
	public LocationInfoBean update(String showPlace, LocationInfoBean bean) {
		if(bean != null && showPlace != null) {
			System.out.println(bean);
			LocationInfoBean r6 = this.getSession().createQuery("FROM LocationInfoBean WHERE showPlace = :showPlace", LocationInfoBean.class)
				.setParameter("showPlace", showPlace)
				.uniqueResult();
			System.out.println("r6 = " + r6);
			if(r6 != null) {
				bean.setLocationId(r6.getLocationId());
				return (LocationInfoBean) this.getSession().merge(bean);
			}
		}
		return null;
	}

	@Override
	public boolean delete(String showPlace) {
		if(showPlace != null) {
			LocationInfoBean r7 = this.getSession().createQuery("FROM LocationInfoBean WHERE showPlace = :showPlace", LocationInfoBean.class)
				.setParameter("showPlace", showPlace)
				.uniqueResult();
			if(r7 != null) {
				this.getSession().delete(r7);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Object findIdByAddr(String showAddr) {
		if(showAddr != null && !showAddr.isEmpty()) {
			Object r8 = this.getSession().createQuery("SELECT locationId FROM LocationInfoBean WHERE showAddr=:showAddr")
				.setParameter("showAddr", showAddr)
				.uniqueResult();
			if(r8 != null) {
				return r8;
			}
		}
		return null;
	}
}
