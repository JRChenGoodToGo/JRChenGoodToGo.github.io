package tw.org.iii.cma.MusicWeb.C.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.MusicWeb.C.Controller.ActivityInfoDetail;
import tw.org.iii.cma.MusicWeb.C.Controller.MainPage;
import tw.org.iii.cma.MusicWeb.C.dao.ActivityInfoDAO;
import tw.org.iii.cma.MusicWeb.C.dao.ActivityInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.C.dao.LocationInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;

@Service
public class ActivityInfoService {
	@Autowired
	private ActivityInfoDAO activityInfoDao;

	public ActivityInfoService(ActivityInfoDAO activityInfoDao) {
		this.activityInfoDao = activityInfoDao;
	}

//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//
//		ActivityInfoService activityInfoService = new ActivityInfoService(new ActivityInfoDAOHibernate(sessionFactory));
//		LocationInfoService locationInfoService = new LocationInfoService(new LocationInfoDAOHibernate(sessionFactory));
//
////		List<ActivityInfoBean> activityList = activityInfoService.listActivity(0, 2);
////		System.out.println(activityList);
//
////		Object countAll = activityInfoService.countActivityAmt();
////		System.out.println(countAll);
//
////		ActivityInfoBean insertObj = new ActivityInfoBean();
////		insertObj.setTagId(1);
////		insertObj.setBandPost("xxxx011");
////		insertObj.setHost("大娛樂家");
////		insertObj.setPlayer("休傑克曼");
////		insertObj.setTheme("「怪異人士」台中變換場");
////		insertObj.setSubTitle("xx011");
////		insertObj.setActivityIntro("xx...011");
////		insertObj.setBandIntro("介紹介紹011");
////		insertObj.setLocationId(1);
////		insertObj.setTape("https://youtube.dd");
////		insertObj.setPurchaseWeb("https://myweb/activity?011");
////		insertObj.setMemberId(1);
////		ActivityInfoBean resultInsert = activityInfoService.insertActivity(insertObj);
////		System.out.println(resultInsert);
//
//		
//////		ActivityInfoBean updateObj = new ActivityInfoBean();
//////		updateObj.setActivityId(8);
////		ActivityInfoBean updateObj = session.get(ActivityInfoBean.class, 2);
////		updateObj.setTagId(2);
//////		updateObj.setBandPost("xxxx005");
//////		updateObj.setHost("金曲歌王");
//////	updateObj.setPlayer("茄子蛋");
////		updateObj.setPlayer("小女孩樂團");
//////		updateObj.setTheme("借筆傻笑癡等");
////		updateObj.setSubTitle("xx005");
////		updateObj.setActivityIntro("xx...005");
////		updateObj.setBandIntro("介紹介紹005");
////		updateObj.setLocationId(1);
////		updateObj.setTape("https://youtube.dd");
////		updateObj.setPurchaseWeb("https://myweb/activity?005");
////		ActivityInfoBean resultUdt = activityInfoService.updateActivity(4, updateObj);
////		System.out.println(resultUdt);
//		
////		boolean clickAdd = activityInfoService.addClick(2);
////		System.out.println(clickAdd);
//		
////		boolean resultDelete = activityInfoService.deleteActivity(12);
////		System.out.println(resultDelete);
//		
////		Object clickAmtFind = activityInfoService.findClickAmt(15);
////		System.out.println(clickAmtFind);
//		
////		Object activityAmtCount = activityInfoService.countActivityAmt(16);
////		System.out.println(activityAmtCount);
//		
////		List<ActivityInfoBean> activityList = activityInfoService.listActivityPerMember(4, 2);
////		System.out.println(activityList);
//		
//		
//		
////		// 得到關鍵字從locationInfo回傳ids
////		List<Object> locationIdFound = locationInfoService.findIdByLocation("高雄");
////		System.out.println(locationIdFound);
////		
////		System.out.println("size = " + locationIdFound.size()); 
////		 for(int i=0; i<locationIdFound.size(); i++) {
////			 // 從activityInfo根據得到的ids列出活動
////			 List<ActivityInfoBean> activityByLocIdList = 
////					 activityInfoService.listActivityByLocId((Integer) locationIdFound.get(i));
////			 System.out.println(activityByLocIdList);
////		 }
//		
//
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}

	public ActivityInfoBean selectActivityById(Integer activityId) {
		if(activityId != null) { // 多製作一個找ID是否存在的方法?
			Object checkIdExist = activityInfoDao.isIdExist(activityId);
			if(checkIdExist!=null) {
				return activityInfoDao.select(activityId);
			}
		}
		return null;
	}
	public List<ActivityInfoBean> listActivity(Integer start, Integer total) {
		if (start != null && total != null) {
			return activityInfoDao.select(start, total);
		}
		return null;
	}

	public Object countActivityAmt() {
		return activityInfoDao.countTotal();
	}

	public ActivityInfoBean insertActivity(ActivityInfoBean bean) { // 需要設接收memberId??
		if (bean != null) {
			return activityInfoDao.insert(bean);
		}
		return null;
	}

	public ActivityInfoBean updateActivity(Integer memberId, ActivityInfoBean newBean) {
		if (memberId != null && newBean.getActivityId() != null && newBean != null) {
			if(newBean.getMemberId().equals(memberId)) {
				return activityInfoDao.update(newBean);
			}
		}
		return null;
	}

	public boolean addClick(Integer activityId) {
		return activityInfoDao.updateClick(activityId);
	}

	public boolean deleteActivity(Integer activityId) {
		if (activityId != null) {
			return activityInfoDao.delete(activityId);
		}
		return false;
	}

	public Object findClickAmt(Integer activityId) {
		if (activityId != null) {
			return activityInfoDao.countClickAmt(activityId);
		}
		return null;
	}

	public Object countActivityAmt(Integer memberId) {
		if (memberId != null) {
			return activityInfoDao.countActivityAmtById(memberId);
		}
		return null;
	}

	public List<ActivityInfoBean> listActivityPerMember(Integer memberId, Integer total) {
		if (memberId != null && total != null) {
			return activityInfoDao.listActivityByMemberId(memberId, total);
		}
		return null;
	}
	// r11_1
	public Object countActivityAmtByLocId(Integer locationId) {
		if(locationId!=null) {
			return activityInfoDao.countActivityAmtByLocId(locationId);
		}
		return null;
	}
	// r11
	public List<ActivityInfoBean> listActivityByLocId(Integer locationId){// [...]
		if(locationId != null) {
			return activityInfoDao.listActivityByLoc(locationId);
		}
		return null;
	}
	// r12
	public Object countActivityAmtByTagId(Integer tagId) {
		if(tagId != null) {
			return activityInfoDao.countActivityAmtByTagId(tagId);
		}
		return null;
	}
	// r13
	public List<ActivityInfoBean> listActivityByTagId(Integer tagId){
		if(tagId != null) {
			return activityInfoDao.listActivityByTagId(tagId);
		}
		return null;
	}
	public List<Object> listActivityWithoutTimeInfo(){
		return activityInfoDao.listIdWithoutTime();
	}
	public List<MainPage> listDefForMainPage(Integer total){
//		if(total != null) {
//			return activityInfoDao.listDefForMainPage(total);
//		}
//		return null;
		return activityInfoDao.listDefForMainPage(total);
		
	}
	public Object selectOnePic(Integer activityId) {
		if(activityId != null) {
			return activityInfoDao.selectOnePic(activityId);
		}
		return null;  
	}
	
	public List<MainPage> listByDateOption(Integer year, Integer startMonth, Integer endMonth, Integer total){
		if(year != null) {
			return activityInfoDao.listByDateOption(year, startMonth, endMonth, total);
		}
		return null;
	}
	public List<MainPage> listByRegion(String area, Integer total){
		if(area!=null && !area.isEmpty()) {
			return activityInfoDao.listByRegion(area, total);
		}
		return null;
	}
	public List<MainPage> listByDateAndRegOption(Integer year, Integer startMonth, Integer endMonth, String region, Integer total){
		if(year!=null && region!=null && !region.isEmpty()) {
			return activityInfoDao.listByDateAndRegOption(year, startMonth, endMonth, region, total);
		}
		return null;
	}
	
	// too complex
	public List<List<ActivityInfoBean>> listByLocKeyword(List<List<Object>> listId){
		if(listId!=null && !listId.isEmpty()) {
			System.out.println("enter service");
			return activityInfoDao.listByLocKeyword(listId);
		}
		return null;
	}
	public ActivityInfoDetail listActivityDetailByAcId(Integer activityId) {
		if(activityId!= null) {
			return activityInfoDao.listActivityDetailByAcId(activityId);
		}
		return null;
	}
	
	public List<MainPage> searchBySubTitle(String subTitle, Integer total){
		if(subTitle!=null && !subTitle.isEmpty()) {
			return activityInfoDao.searchBySubTitle(subTitle, total);
		}
		return null;
	}
	public List<MainPage> searchByPlayer(String player, Integer total){
		if(player!=null && !player.isEmpty()) {
			return activityInfoDao.searchByPlayer(player, total);
		}
		return null;
	}
	
	public List<MainPage> searchByTag(String tagName, Integer total) {
		if(tagName!=null && !tagName.isEmpty()) {
			return activityInfoDao.searchByTag(tagName, total);
		}
		return null;

	}
	
	public List<MainPage> listActivityByTagId(Integer tagId, Integer total) {
		if(tagId != null) {
			return activityInfoDao.listActivityByTagId(tagId, total);
		}
		return null;
	}

}
