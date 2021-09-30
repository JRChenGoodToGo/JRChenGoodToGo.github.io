package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;
import tw.org.iii.cma.MusicWeb.C.Controller.ActivityInfoDetail;
import tw.org.iii.cma.MusicWeb.domain.CollectId;


public interface CollectInfoDAO {
	public abstract List<CollectInfoBean> findActivityByMemberId(Integer memberId, Integer total);
	public abstract Object countAllCollectionByMemberId(Integer memberId);
	public abstract List<CollectInfoBean> findWhoCollect(Integer activityId, Integer total);
	public abstract Object countCollectAmt(Integer activityId);
	public abstract CollectInfoBean insert(CollectInfoBean bean);
	// r5_1
	public abstract CollectInfoBean insert(Integer memberId, Integer activityId); // 9/5 try
	public abstract boolean delete(Integer memberId, Integer activityId);
	// r7
	public abstract List<ActivityInfoDetail> listDetail(Integer memberId);
	public abstract Object testDatailList(Integer memberId, Integer activityId);
}
