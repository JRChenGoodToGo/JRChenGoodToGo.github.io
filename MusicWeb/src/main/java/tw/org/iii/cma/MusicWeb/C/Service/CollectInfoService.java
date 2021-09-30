package tw.org.iii.cma.MusicWeb.C.Service;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.MusicWeb.C.Controller.ActivityInfoDetail;
import tw.org.iii.cma.MusicWeb.C.dao.CollectInfoDAO;
import tw.org.iii.cma.MusicWeb.C.dao.CollectInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.CollectId;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;

@Service
public class CollectInfoService {
	@Autowired
	private CollectInfoDAO collectInfoDao;
	
	public CollectInfoService(CollectInfoDAO collectInfoDao) {
		this.collectInfoDao = collectInfoDao;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		CollectInfoService collectInfoService = new CollectInfoService(new CollectInfoDAOHibernate(sessionFactory));
//
//		
////		Object collectionCount = collectInfoService.countCollectByMemberId(15);
////		System.out.println(collectionCount);
//		
////		List<CollectInfoBean> allCollectionList = collectInfoService.listAllCollection(15);
////		System.out.println(allCollectionList);
//		
////		Object collectedAmtCount = collectInfoService.countCollectedAmt(8);
////		System.out.println(collectedAmtCount);
//		
////		List<CollectInfoBean> collectedDataList = collectInfoService.listCollectedData(8);
////		System.out.println(collectedDataList);
//		
////		CollectInfoBean insertObj = new CollectInfoBean();
////		insertObj.setMemberId(20);
////		insertObj.setActivityId(34);
////		CollectInfoBean resultInsert = collectInfoService.insertCollectInfo(insertObj);
////		System.out.println(resultInsert);
//		
////		boolean collectInfoDelete = collectInfoService.deleteCollectInfo(20, 34);
////		System.out.println(collectInfoDelete);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}
	
	public Object countCollectByMemberId(Integer memberId) {
		if(memberId != null) {
			return collectInfoDao.countAllCollectionByMemberId(memberId);
		}
		return null;
	}
	public List<CollectInfoBean> listAllCollection(Integer memberId){
		if(memberId != null) {
			return collectInfoDao.findActivityByMemberId(memberId, null);
		}
		return null;
	}
	public Object countCollectedAmt(Integer activityId) {
		if(activityId != null) {
			return collectInfoDao.countCollectAmt(activityId);
		}
		return null;
	}
	public List<CollectInfoBean> listCollectedData(Integer activityId){
		if(activityId != null) {
			return collectInfoDao.findWhoCollect(activityId, null);
		}
		return null;
	}
	// r5_1
	public CollectInfoBean insertCollectInfo(Integer memberId, Integer activityId) {
		if(memberId != null && activityId != null) {
			System.out.println("enter collectInfoService");
			return collectInfoDao.insert(memberId, activityId);
		}
		return null;
	}
	
	public CollectInfoBean insert(CollectId idBean) {
		if(idBean != null) {
//			return collectInfoDao.insert(idBean);
		}
		return null;
	}

	
	public boolean deleteCollectInfo(Integer memberId, Integer activityId) {
		if(memberId != null && activityId != null) {
			return collectInfoDao.delete(memberId, activityId);
		}
		return false;
	}
	// r7
	public List<ActivityInfoDetail> listDetail(Integer memberId) {
		if(memberId!=null) {
			return collectInfoDao.listDetail(memberId);
		}
		return null;
	}

}
