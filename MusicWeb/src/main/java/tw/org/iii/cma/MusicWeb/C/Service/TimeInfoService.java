package tw.org.iii.cma.MusicWeb.C.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.MusicWeb.C.dao.TimeInfoDAO;
import tw.org.iii.cma.MusicWeb.C.dao.TimeInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

@Service
public class TimeInfoService {
	@Autowired
	private TimeInfoDAO timeInfoDao;
	
	public TimeInfoService(TimeInfoDAO timeInfoDao) {
		this.timeInfoDao = timeInfoDao;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		TimeInfoService timeInfoService = new TimeInfoService(new TimeInfoDAOHibernate(sessionFactory));
//		
////		Object showDateCount = timeInfoService.countByShowDate(2021, 9);
////		System.out.println(showDateCount);
//		
////		List<TimeInfoBean> showDateList = timeInfoService.listByShowDate(2021, 9, 3);
////		System.out.println(showDateList);
//		
////		Object showTimeCount = timeInfoService.countByShowTime(10, 15);
////		System.out.println(showTimeCount);
//		
////		List<TimeInfoBean> showTimeList = timeInfoService.listByShowTime(10, 15, null);
////		System.out.println(showTimeList);
//		
////		List<TimeInfoBean> timeInfoList = timeInfoService.listAllTimeInfo(null, 2);
////		System.out.println(timeInfoList);
//		
////		Object allDataCount = timeInfoService.countAllData();
////		System.out.println(allDataCount);
//		
//		
//// 		TimeInfoBean insertObj = new TimeInfoBean();
//// 		String dateShow = "2021-09-30 21:00";
//// 		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//// 		LocalTime showTime = LocalTime.of(21, 00);
//// 		LocalTime enterTime = LocalTime.of(20, 30);
//// 		try {
////	 		Date showDate = sdfDate.parse(dateShow);
////	 		insertObj.setShowDate(showDate);
////	 		insertObj.setShowTime(showTime);
////	 		insertObj.setEnterTime(enterTime);
////	 		insertObj.setShowTotalTime(100);
//// 		} catch(Exception e) {
//// 			e.printStackTrace();
//// 		}
//// 		TimeInfoBean resultInsert = timeInfoService.insertTimeInfo(insertObj);
//// 		System.out.println(resultInsert);
//		
//// 		TimeInfoBean updateObj = new TimeInfoBean();
////// 		String dateShow = "2021-10-30 14:00";
////// 		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
////// 		LocalTime showTime = LocalTime.of(14, 00);
//// 		LocalTime enterTime = LocalTime.of(20, 00);
//// 		try {
//////	 		Date showDate = sdfDate.parse(dateShow);
//// 			updateObj.setId(21);
//////	 		updateObj.setShowDate(showDate);
//////	 		updateObj.setShowTime(showTime);
////	 		updateObj.setEnterTime(enterTime);
////	 		updateObj.setShowTotalTime(180);
//// 		} catch(Exception e) {
//// 			e.printStackTrace();
//// 		}
////  		TimeInfoBean resultUdt = timeInfoService.updateTimeInfo(40, updateObj);
////  		System.out.println(resultUdt);
//  		
////  		boolean resultDelete = timeInfoService.deleteTimeInfo(35);
////		System.out.println(resultDelete);
//		
////		boolean resultDeleteByIdentifier = timeInfoService.deleteTimeInfoByIdentifier(19);
////		System.out.println(resultDeleteByIdentifier);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}
	
	public Object countByShowDate(Integer year, Integer month) {
		if(year != null && month != null) {
			List<TimeInfoBean> total = timeInfoDao.findYearMonth(year, month, null);
			return total.size(); 
		}
		return null;
	}
	public List<TimeInfoBean> listByShowDate(Integer year, Integer month, Integer total) {
		if(year != null && month != null && total != null) {
			return timeInfoDao.findYearMonth(year, month, total);
		}
		return null;
	}
	public Object countByShowTime(Integer time1, Integer time2) {
		if(time1 != null && time2 != null) {
			return timeInfoDao.findShowTime(time1, time2, null).size();
		}
		return null;
	}
	public List<TimeInfoBean> listByShowTime(Integer time1, Integer time2, Integer total){
		if(time1 != null && time2 != null) {
			return timeInfoDao.findShowTime(time1, time2, total);
		}
		return null;
	}
	public List<TimeInfoBean> listAllTimeInfo(Integer start, Integer total){
		return timeInfoDao.selectAll(start, total);
	}
	public Object countAllData() {
		return timeInfoDao.countTotal();
	}
	public TimeInfoBean insertTimeInfo(TimeInfoBean bean) {
		if(bean != null) {
			return timeInfoDao.insert(bean);
		}
		return null;
	}
	public TimeInfoBean updateTimeInfo(Integer activityId, TimeInfoBean newBean) {
		if(activityId != null && newBean != null) {
			TimeInfoBean resultFromAssign = timeInfoDao.selectByActivityId(activityId);
			if(resultFromAssign.getId().equals(newBean.getId())) {//欲更新的identifier = 根據活動ID撈出的identifer
				newBean.setActivityId(activityId);
				return timeInfoDao.update(newBean);
			}
		}
		return null;
	}
	public boolean deleteTimeInfo(Integer activityId) { //CASCADE狀態下刪的了? 可
		if(activityId != null) {
			return timeInfoDao.delete(activityId);
		}
		return false;
	}
	public boolean deleteTimeInfoByIdentifier(Integer Id) { //副本
		TimeInfoBean data = timeInfoDao.select(Id);
		data.setActivityId(36);
		System.out.println(data);
		return timeInfoDao.delete(36);
	}
	public Object countActivityAmtByDate(Integer year, Integer month) {
		if(year != null && month != null) {
			return timeInfoDao.countActivityAmtByOption(year, month);
		}
		return null;
	}
	public List<Object> listActivityIdByDate(Integer year, Integer month){
		if(year != null && month != null) {
			return timeInfoDao.listActivityIdByOption(year, month);
		}
		return null;
	}
}
