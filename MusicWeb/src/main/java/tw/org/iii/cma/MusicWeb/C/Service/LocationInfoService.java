package tw.org.iii.cma.MusicWeb.C.Service;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.MusicWeb.C.dao.LocationInfoDAO;
import tw.org.iii.cma.MusicWeb.C.dao.LocationInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;



@Service
public class LocationInfoService {
	@Autowired
	private LocationInfoDAO locationInfoDao;
	
	public LocationInfoService(LocationInfoDAO locationInfoDao) {
		this.locationInfoDao = locationInfoDao;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		LocationInfoDAO locationInfoDao = new LocationInfoDAOHibernate(sessionFactory);
//		LocationInfoService locationInfoService = new LocationInfoService(locationInfoDao);
//		
////		List<LocationInfoBean> locationRangeSelect = locationInfoService.selectLocationRange(0, 1);
////		System.out.println(locationRangeSelect);
//		
////		Object count = locationInfoService.countAllLocationData();
////		System.out.println(count);
//		
////		List<LocationInfoBean> locationChoose = locationInfoService.chooseLocation("台中");
////		System.out.println(locationChoose);
//		
////		LocationInfoBean insertObj = new LocationInfoBean();
////		insertObj.setShowAddr("桃園市大園區航翔路1號");
////		insertObj.setShowPlace("星宇航空運籌中心");
////		LocationInfoBean resultInsert =  locationInfoService.insertLocation(insertObj);
////		System.out.println(resultInsert);
//		
////		LocationInfoBean updateObj = new LocationInfoBean();
////		updateObj.setShowAddr("台中市西屯區安和路117號");
////		updateObj.setShowPlace("Legacy Taichung 傳 音樂展演空間");
////		LocationInfoBean resultUdt = locationInfoService.updateLocation("Legacy Taichung 傳 音樂展演空間1", updateObj);
////		System.out.println(resultUdt);
//		
////		boolean locationDelete = locationInfoService.deleteLocation("Legacy Taichung 傳 音樂展演空間");
////		System.out.println(locationDelete);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//		
//
//	}
	
	public LocationInfoBean select(Integer id) {
		if(id != null) {
			return locationInfoDao.select(id);
		}
		return null;
	}
	
	public List<LocationInfoBean> selectLocationRange(Integer start, Integer total){
		if(start != null && total != null) {
			return locationInfoDao.select(start, total);
		}
		return null;
	}
	public Object countAllLocationData() {
		return locationInfoDao.countTotal();
	}
	public List<List<Object>> findIdByLocation(String keyword){
		if(keyword != null) {
			return locationInfoDao.findAddrKeyWord(keyword);
		}
		return null;
	}
	public LocationInfoBean insertLocation(LocationInfoBean bean) {
		if(bean != null) {
			return locationInfoDao.insert(bean);
		}
		return null;
	}
	public LocationInfoBean updateLocation(String showPlace, LocationInfoBean bean) {
		if(bean != null){
			return locationInfoDao.update(showPlace, bean);
		}
		return null;
	}
	public boolean deleteLocation(String showPlace) {
		if(showPlace != null) {
			return locationInfoDao.delete(showPlace);
		}
		return false;
	}
	
	public Object findIdByAddr(String showAddr) {
		if(showAddr != null && !showAddr.isEmpty()) {
			return locationInfoDao.findIdByAddr(showAddr);
		}
		return null;
	}
	

}
