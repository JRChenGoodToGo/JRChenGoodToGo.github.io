package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.C.Controller.ActivityInfoDetail;
import tw.org.iii.cma.MusicWeb.C.Controller.MainPage;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;


public interface ActivityInfoDAO {
	// r1
	public abstract ActivityInfoBean select(Integer activityId);
	// r2
	public abstract List<ActivityInfoBean> select(Integer start, Integer total);
	// r3
	public abstract Object countTotal();
	public abstract ActivityInfoBean insert(ActivityInfoBean bean);
	// r5
	public abstract ActivityInfoBean update(ActivityInfoBean bean);
	public abstract boolean updateClick(Integer activityId);
	public abstract boolean delete(Integer activityId);
	public abstract Object countClickAmt(Integer activityId);
	public abstract Object countActivityAmtById(Integer memberId);
	// r10
	public abstract List<ActivityInfoBean> listActivityByMemberId(Integer memberId, Integer total);
	// r11_1
	public Object countActivityAmtByLocId(Integer locationId);
	// r11
	public abstract List<ActivityInfoBean> listActivityByLoc(Integer locationId);
	// r12
	public abstract Object countActivityAmtByTagId(Integer tagId);
	// r13
	public abstract List<ActivityInfoBean> listActivityByTagId(Integer tagId);
	public abstract List<Object> listIdWithoutTime();
	// r15
	public abstract List<MainPage> listDefForMainPage(Integer total);
	public abstract Object selectOnePic(Integer activityId);
	// r17
	public abstract List<MainPage> listByDateOption(Integer year, Integer startMonth, Integer endMonth, Integer total);
	// r18
	public abstract List<MainPage> listByRegion(String area, Integer total);
	// r19
	public abstract List<MainPage> listByDateAndRegOption(Integer year, Integer startMonth, Integer endMonth, String area, Integer total);
	public abstract List<List<ActivityInfoBean>> listByLocKeyword(List<List<Object>> listId);// too complex
	// r21
	public abstract Object isIdExist(Integer activityId);
	// r22
	public abstract ActivityInfoDetail listActivityDetailByAcId(Integer activityId);
	// r23
	public abstract List<MainPage> searchBySubTitle(String subTitle, Integer total);
	// r24
	public abstract List<MainPage> searchByPlayer(String player, Integer total);
	// r25
	public abstract List<MainPage> searchByTag(String tagName, Integer total);
	// r26
	public abstract List<MainPage> listActivityByTagId(Integer tagId, Integer total);

}
