package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.swing.ImageIcon;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.org.iii.cma.MusicWeb.C.Controller.ActivityInfoDetail;
import tw.org.iii.cma.MusicWeb.C.Controller.MainPage;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;





@Repository
public class ActivityInfoDAOHibernate implements ActivityInfoDAO{
	private java.util.Date today = new java.util.Date();
	@PersistenceContext
	private Session session;
	private Integer clickAmt=0;
//	public ActivityInfoDAOHibernate(SessionFactory sessionFactory) {
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
//		ActivityInfoDAO activityInfo = new ActivityInfoDAOHibernate(sessionFactory);
//		
////// r1		
////		ActivityInfoBean selectObj = activityInfo.select(1);
////		System.out.println(selectObj);
//
////// r2		
////		List<ActivityInfoBean> selectSeveral = activityInfo.select(0, 3);
////		System.out.println(selectSeveral);
//		
////// r3		
////		Object resultTotal = activityInfo.countTotal();
////		System.out.println(resultTotal);
//		
////// r4		
////		ActivityInfoBean insertObj = new ActivityInfoBean();
////		insertObj.setTagId(2);
////		insertObj.setBandPost("xxxx010");
////		insertObj.setHost("馬茲卡團隊");
////		insertObj.setPlayer("Matzka");
////		insertObj.setTheme("「大水災」台中命運場");
////		insertObj.setSubTitle("xx010");
////		insertObj.setActivityIntro("xx...010");
////		insertObj.setBandIntro("介紹介紹010");
////		insertObj.setLocationId(1);
////		insertObj.setTape("https://youtube.dd");
//////		insertObj.setUploadTime(new java.util.Date());
////		insertObj.setPurchaseWeb("https://myweb/activity?010");
////		insertObj.setMemberId(2);
////		
////		ActivityInfoBean result = activityInfo.insert(insertObj);
////		System.out.println(result);
//	
//// r5		
////		ActivityInfoBean updateObj = new ActivityInfoBean();
//////		updateObj.setActivityId(8);
//////		ActivityInfoBean updateObj = session.get(ActivityInfoBean.class, 13);
//////		updateObj.setTagId(2);
//////		updateObj.setBandPost("xxxx005");
////		updateObj.setHost("金曲歌王");
//////		updateObj.setPlayer("茄子蛋");
//////		updateObj.setPlayer("逃跑計畫");
////		updateObj.setTheme("借筆傻笑癡等");
//////		updateObj.setSubTitle("xx005");
//////		updateObj.setActivityIntro("xx...005");
//////		updateObj.setBandIntro("介紹介紹004");
//////		updateObj.setLocationId(1);
//////		updateObj.setTape("https://youtube.dd");
//////		updateObj.setUploadTime(new java.util.Date());
//////		updateObj.setPurchaseWeb("https://myweb/activity?005");
////		updateObj.setMemberId(2);
////		ActivityInfoBean resultUdt = activityInfo.update(updateObj);
////		System.out.println(resultUdt);
//
////r6		
////		boolean clickUdt = activityInfo.updateClick(31);
////		System.out.println(clickUdt);
//		
//// r7		
////		ActivityInfoBean deleteObj = activityInfo.delete(18);
////		System.out.println("delete Item: " + deleteObj);
//		
//// r8		
////		Object clickAmtTotal = activityInfo.countClickAmt(15);
////		System.out.println(clickAmtTotal);
//		
//// r9
////		Object howManyOwnByMember = activityInfo.countActivityAmtById(2);
////		System.out.println(howManyOwnByMember);
//
////r10		
////		List<ActivityInfoBean> activityListByMemberId = activityInfo.listActivityById(1, 2);
////		System.out.println(activityListByMemberId);
//		
//// r11
////		List<ActivityInfoBean> activityByLocList = activityInfo.listActivityByLoc(2);
////		System.out.println(activityByLocList);
//
//// r12		
////		Object activityAmtCount1 = activityInfo.countActivityAmtByTagId(1);
////		Object activityAmtCount2 = activityInfo.countActivityAmtByTagId(2);
////		System.out.println("tagId 1 Amt:" + activityAmtCount1);
////		System.out.println("tagId 2 Amt:" + activityAmtCount2);
//		
//// r13		
////		List<ActivityInfoBean> activityList = activityInfo.listActivityByTagId(1);
////		System.out.println(activityList);
//		
//// r14
//		List<Object> idWithoutTimeList = activityInfo.listIdWithoutTime();
//		System.out.println(idWithoutTimeList);
//		
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.getSessionFactory().getCurrentSession().close();
//		HibernateUtil.closeSessionFactory();
//	}

	@Override
	public ActivityInfoBean select(Integer activityId) {
		ActivityInfoBean r1 = this.getSession().get(ActivityInfoBean.class, activityId);
		if(activityId != null && r1.getActivityId() != null) {
			return r1;
		}
		return null;
	}

	@Override
	public List<ActivityInfoBean> select(Integer start, Integer total) {
		if(start != null && total != null) {
			List<ActivityInfoBean> r2 = this.getSession().createQuery("FROM ActivityInfoBean", ActivityInfoBean.class)
				.setFirstResult(start)
				.setMaxResults(total)
				.list();
			return r2;
		}
		return null;
	}
	
	@Override
	public Object countTotal() {
		Object r3 = this.getSession().createQuery("SELECT count(*) FROM ActivityInfoBean").getSingleResult();
		return r3;
	}

	@Override // r4
	public ActivityInfoBean insert(ActivityInfoBean bean) {
		if(bean != null && bean.getMemberId() != null && bean.getLocationId() != null) {
			bean.setUploadTime(new java.util.Date());
			bean.setClickAmt(clickAmt);
			Serializable pk = this.getSession().save(bean);
			System.out.println("pk = " + pk);
			return bean;
		}
		return null;
	}

	@javax.transaction.Transactional
	@Override
	public ActivityInfoBean update(ActivityInfoBean bean) { // 從活動編號查詢
		if(bean != null && bean.getMemberId() != null && bean.getActivityId() != null) {
			ActivityInfoBean r5 = this.getSession().createQuery("FROM ActivityInfoBean WHERE activityId = :activityId", ActivityInfoBean.class)
				.setParameter("activityId", bean.getActivityId())
				.uniqueResult();
			if(r5 != null && r5.getMemberId().equals(bean.getMemberId())) {// 確認身分
				bean.setTagId(bean.getTagId()==null? r5.getTagId(): bean.getTagId());
				bean.setBandPost(bean.getBandPost()==null? r5.getBandPost(): bean.getBandPost());
				bean.setHost(bean.getHost()==null? r5.getHost(): bean.getHost());
				bean.setPlayer(bean.getPlayer()==null? r5.getPlayer(): bean.getPlayer());
				bean.setTheme(bean.getTheme()== null? r5.getTheme(): bean.getTheme());
				bean.setSubTitle(bean.getSubTitle()==null? r5.getSubTitle(): bean.getSubTitle());
				bean.setActivityIntro(bean.getActivityIntro()==null? r5.getActivityIntro(): bean.getActivityIntro());
				bean.setBandIntro(bean.getBandIntro()==null? r5.getBandIntro(): bean.getBandIntro());
				bean.setLocationId(bean.getLocationId()==null? r5.getLocationId(): bean.getLocationId());
				bean.setTape(bean.getTape()==null? r5.getTape(): bean.getTape());
				bean.setUploadTime(new java.util.Date());
				bean.setPurchaseWeb(bean.getPurchaseWeb()==null? r5.getPurchaseWeb(): bean.getPurchaseWeb());
				bean.setClickAmt(bean.getClickAmt()==0? r5.getClickAmt(): bean.getClickAmt());
				bean.setPhoto(bean.getPhoto()==null? r5.getPhoto(): bean.getPhoto());
				return (ActivityInfoBean) this.getSession().merge(bean);
			}
		} 
		return null;
	}
	@Transactional
	@Override
	public boolean updateClick(Integer activityId) {
		if(activityId != null) {
			System.out.println("activityId = " + activityId);
			Integer r6 = this.getSession().createQuery("UPDATE ActivityInfoBean aty SET aty.clickAmt = aty.clickAmt + 1 WHERE activityId = :activityId")
				.setParameter("activityId", activityId).executeUpdate();
			if(r6.equals(1)) {
				System.out.println("update clickAmt success!");
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Integer activityId) {
		if(activityId != null) {
			ActivityInfoBean r7 = this.getSession().get(ActivityInfoBean.class, activityId);
			if(r7 != null) {
				this.getSession().delete(r7);
				return true;
			}
		}
		return false;
	}
	@Override
	public Object countClickAmt(Integer activityId) {
		if(activityId != null) {
			Object r8 = this.getSession().createQuery("SELECT clickAmt FROM ActivityInfoBean WHERE activityId = :activityId")
					.setParameter("activityId", activityId)
					.uniqueResult();
			return r8;
		}
		return null;
	}
	@Override
	public Object countActivityAmtById(Integer memberId) {
		if(memberId != null) {
			Object r9 = this.getSession().createQuery("SELECT count(*) FROM ActivityInfoBean WHERE memberId = :memberId")
				.setParameter("memberId", memberId)
				.uniqueResult();
			if(r9 != null) {
				return r9;
			}
		}
		return null;
	}
	@Override
	public List<ActivityInfoBean> listActivityByMemberId(Integer memberId, Integer total) {
		if(memberId != null) {
			List<ActivityInfoBean> r10 = this.getSession().createQuery("FROM ActivityInfoBean WHERE memberId = :memberId ORDER BY DATE(uploadTime) ASC", ActivityInfoBean.class)
				.setParameter("memberId", memberId)
				.setMaxResults(total)
				.list();
			if(r10 != null) {
				return r10;
			}
		}
		return null;
	}
	
	@Override
	public Object countActivityAmtByLocId(Integer locationId) {
		if(locationId!=null) {
			Object r11_1 = this.getSession().createQuery("SELECT count(*) FROM ActivityInfoBean WHERE locationId=:locationId")
				.setParameter("locationId", locationId)
				.uniqueResult();
			if(r11_1!=null) {
				return r11_1;
			}
		}
		return null;
	}
	@Override
	public List<ActivityInfoBean> listActivityByLoc(Integer locationId) {
		if(locationId != null) {
			List<ActivityInfoBean> r11 = this.getSession().createQuery("FROM ActivityInfoBean WHERE locationId = :locationId ORDER BY clickAmt DESC", ActivityInfoBean.class)
				.setParameter("locationId", locationId)
				.list();
			if(r11 != null) {
				return r11;
			}
		}
		return null;
	}
	@Override
	public Object countActivityAmtByTagId(Integer tagId) {
		if(tagId != null) {
			Object r12 = this.getSession().createQuery("SELECT count(*) FROM ActivityInfoBean WHERE tagId = :tagId")
				.setParameter("tagId", tagId)
				.uniqueResult();
			if(r12 != null) {
				return r12;
			}
		}
		return null;
	}
	@Override
	public List<ActivityInfoBean> listActivityByTagId(Integer tagId) {
		if(tagId != null) {
			List<ActivityInfoBean> r13 = this.getSession().createQuery("FROM ActivityInfoBean WHERE tagId = :tagId ORDER BY clickAmt DESC", ActivityInfoBean.class)
				.setParameter("tagId", tagId)
				.list();
			if(r13 != null) {
				return r13;
			}
		}
		return null;
	}
	@Override // 4 8 9 13 15 16 19   20 30 31 35 36 38 
	public List<Object> listIdWithoutTime() {
		List<Object> r14 = this.getSession().createQuery(
				"SELECT activityId FROM ActivityInfoBean WHERE activityId NOT IN ("
				+ " SELECT ac.activityId FROM ActivityInfoBean ac, TimeInfoBean ti WHERE ac.activityId = ti.activityId) ORDER BY activityId", Object.class)
			.list();
		if(r14 != null) {
			return r14;
		}
		return null;
	}
	
	@Override // SELECT TagInfo + ActivityInfo + TimeInfo
	public List<MainPage> listDefForMainPage(Integer total)  {
		if(total != null) { // NEW tw.org.rrg.caa.domain.ActivityInfoBean (
			today = new java.util.Date();
			System.out.println("date today is: " + today);
			List<Object[]> r15 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND loc.locationId=ac.locationId "
																+ "AND time.showDate >= :today ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setMaxResults(total)
				.getResultList();
			System.out.println("r15= " + r15);
			if(r15 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r15) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					// method1 直接先Encode
//					String encodePhoto = Base64.getEncoder().encodeToString((byte[])result[7]);
//					mainContainer.setPhoto(encodePhoto);
					// method2 byte陣列方式傳送由jsp decode
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					// fail
//					byte[] a = (byte[]) result[6];
//					Encoder b = Base64.getEncoder();
//					byte[] picResult = b.encode(a);
					// fail
//					byte[] encode64 = org.apache.commons.codec.binary.Base64.encodeBase64((byte[]) result[6]);
//					try {
//						String encodeResult = new String(encode64, "UTF-8");
//						mainContainer.setPhoto(encodeResult);
//						list.add(mainContainer);
//						
//					} catch(Exception e) {
//						e.printStackTrace();
//					}
					// cannot cast
//					try {
//						Blob blob = (Blob) result[6];
//						InputStream inputStream = blob.getBinaryStream();
//						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//						byte[] buffer = new byte[4096];
//						int bytesRead = -1;
//						while( (bytesRead= inputStream.read(buffer)) != -1) {
//							outputStream.write(buffer, 0, bytesRead);
//						}
//						System.out.println("outputStream = " + outputStream);
//						byte[] imageBytes = outputStream.toByteArray();
//						System.out.println("imageBytes = " + imageBytes);
//						String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//						
//						mainContainer.setPhoto(base64Image);
//						inputStream.close();
//						outputStream.close();
//					} catch(Exception e) {
//						e.printStackTrace();
//					}
					
				}
				return list;
			}
		} else { // 9/4 嘗試 total為null時
			System.out.println("date today is: " + today);
			List<Object[]> r15 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND loc.locationId=ac.locationId "
																+ "AND time.showDate >= :today ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setMaxResults(3)
				.getResultList();
			System.out.println("r15= " + r15);
			if(r15 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r15) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					// method1 直接先Encode
//					String encodePhoto = Base64.getEncoder().encodeToString((byte[])result[7]);
//					mainContainer.setPhoto(encodePhoto);
					// method2 byte陣列方式傳送由jsp decode
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
				}
			}

		}
		return null;
	}
	@Override
	public Object selectOnePic(Integer activityId) {
		Object r16 = this.getSession().createQuery("SELECT photo FROM ActivityInfoBean WHERE activityId = :activityId")
			.setParameter("activityId", activityId)
			.uniqueResult();
		if(r16 != null) {
			return r16;
		}
		return null;
	}
	
	@Override // 直接做一個SELECT TimeInfo + ActivityInfo?
	public List<MainPage> listByDateOption(Integer year, Integer startMonth, Integer endMonth, Integer total) { // 1-3, 4-6, 7-9, 10-12
		if(year != null && startMonth!=null && endMonth != null) {// [1, 11, 2, 40]
			System.out.println("enter hibernate to filter year and month"); // 傳入total指定顯示幾筆?
			System.out.println("date today is: " + today);
			List<Object[]> r17 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId = time.activityId AND ac.locationId=loc.locationId "
																+ "AND YEAR(showDate)=:year AND MONTH(showDate) BETWEEN :startMonth AND :endMonth"
																+ " AND time.showDate >= :today ORDER BY clickAmt DESC", Object[].class)
				.setParameter("year", year)
				.setParameter("startMonth", startMonth)
				.setParameter("endMonth", endMonth)
				.setParameter("today", today)
				.setMaxResults(total)
				.getResultList();
			
			System.out.println("year= " + year);
			System.out.println("startMonth= " + startMonth);
			System.out.println("endMonth= " + endMonth);
			System.out.println("r17= " + r17);
			if(r17 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r17) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]);//
					
					mainContainer.setHost((String) result[3]);
					mainContainer.setPlayer((String) result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
				}
				return list;
			}
		} else if(year!=null && startMonth==null && endMonth==null) { // 僅選年份
			List<Object[]> r17 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId = time.activityId AND ac.locationId=loc.locationId "
																+ "AND YEAR(showDate)=:year AND time.showDate >= :today "
																+ "ORDER BY clickAmt DESC", Object[].class)
				.setParameter("year", year)
				.setParameter("today", today)
				.setMaxResults(total)
				.getResultList();
				System.out.println("r17= " + r17);
			if(r17 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r17) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]);//
					
					mainContainer.setHost((String) result[3]);
					mainContainer.setPlayer((String) result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
				}
				System.out.println("only year");
				return list;
			}
		} else {
			System.out.println("no date option?");
		}
		return null;
	}
	
	@Override // region接前端傳的area, 為便利不改名
	public List<MainPage> listByRegion(String region, Integer total) {
		if(region!=null && !region.isEmpty()) { // 傳入total指定顯示幾筆?
			if(region.equals("north")) {
				System.out.println("Region is north?? Answer: " + region);
				List<Object[]> r18 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%基隆%' OR showAddr LIKE '%台北%' OR showAddr LIKE '%臺北%' "
																	+ "OR showAddr LIKE '%新北%' OR showAddr LIKE '%桃園%' OR showAddr LIKE '%新竹%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r18= " + r18);
				if(r18 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r18) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r18 == null
			} // region is north
			
			if(region.equals("central")) {
				System.out.println("Region is central? Answer: " + region);
				List<Object[]> r18 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%苗栗%' OR showAddr LIKE '%台中%' OR showAddr LIKE '%臺中%' OR showAddr LIKE '%彰化%' "
																	+ "OR showAddr LIKE '%雲林%' OR showAddr LIKE '%南投%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r18= " + r18);
				if(r18 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r18) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r18 == null
			} // region is central
			
			if(region.equals("south")) {
				System.out.println("Region is south? Answer: " + region);
				List<Object[]> r18 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%嘉義%' OR showAddr LIKE '%台南%' OR showAddr LIKE '%臺南%' OR showAddr LIKE '%高雄%' "
																	+ "OR showAddr LIKE '%屏東%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r18= " + r18);
				if(r18 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r18) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);//
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r18 == null
			} // region is south
			
			if(region.equals("east")) {
				System.out.println("Region is east? Answer: " + region);
				List<Object[]> r18 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%宜蘭%' OR showAddr LIKE '%花蓮%' OR showAddr LIKE '%台東%' "
																	+ "OR showAddr LIKE '%臺東%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r18= " + r18);
				if(r18 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r18) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);//
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r18 == null
			} // region is east
			
		}
		return null;
	}
	
	@Override // 修改地區成英文，加上未過期條件
	public List<MainPage> listByDateAndRegOption(Integer year, Integer startMonth, Integer endMonth, String region, Integer total) {
		if(year!=null && startMonth!=null && endMonth!=null && region!=null && !region.isEmpty()) {
			if(region.equals("north")) { // 篩選為北區
				System.out.println("Region is north? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year AND MONTH(showDate) BETWEEN :startMonth AND :endMonth "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%基隆%' OR showAddr LIKE '%台北%' OR showAddr LIKE '%臺北%' OR showAddr LIKE '%新北%' OR showAddr LIKE '%桃園%' "
																	+ "OR showAddr LIKE '%新竹%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("startMonth", startMonth)
					.setParameter("endMonth", endMonth)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is north
			
			if(region.equals("central")) { // 篩選為中區
				System.out.println("Region is central?? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year AND MONTH(showDate) BETWEEN :startMonth AND :endMonth "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%苗栗%' OR showAddr LIKE '%台中%' OR showAddr LIKE '%臺中%' OR showAddr LIKE '%彰化%' "
																	+ "OR showAddr LIKE '%雲林%' OR showAddr LIKE '%南投%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("startMonth", startMonth)
					.setParameter("endMonth", endMonth)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is 中
			
			if(region.equals("south")) { // 篩選為南區
				System.out.println("Region is south? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year AND MONTH(showDate) BETWEEN :startMonth AND :endMonth "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%嘉義%' OR showAddr LIKE '%台南%' OR showAddr LIKE '%臺南%' OR showAddr LIKE '%高雄%' "
																	+ "OR showAddr LIKE '%屏東%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("startMonth", startMonth)
					.setParameter("endMonth", endMonth)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is 南
			
			if(region.equals("east")) { // 篩選為東區
				System.out.println("Region is east? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year AND MONTH(showDate) BETWEEN :startMonth AND :endMonth "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%宜蘭%' OR showAddr LIKE '%花蓮%' OR showAddr LIKE '%台東%' "
																	+ "OR showAddr LIKE '%臺東%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("startMonth", startMonth)
					.setParameter("endMonth", endMonth)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);//
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is east
			
		} else if(year!=null && startMonth==null && endMonth==null && region!=null && !region.isEmpty()){
			// 年、地區都有值, 月沒值
			if(region.equals("north")) { // 篩選為北區
				System.out.println("Region without month is north? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%基隆%' OR showAddr LIKE '%台北%' OR showAddr LIKE '%臺北%' OR showAddr LIKE '%新北%' OR showAddr LIKE '%桃園%' "
																	+ "OR showAddr LIKE '%新竹%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);//
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is 北
			
			if(region.equals("central")) { // 篩選為中區
				System.out.println("Region without month is central? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%苗栗%' OR showAddr LIKE '%台中%'  OR showAddr LIKE '%臺中%' OR showAddr LIKE '%彰化%' "
																	+ "OR showAddr LIKE '%雲林%' OR showAddr LIKE '%南投%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);//
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is central
			
			if(region.equals("south")) { // 篩選為南區
				System.out.println("Region without month is south? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%嘉義%' OR showAddr LIKE '%台南%' OR showAddr LIKE '%臺南%' OR showAddr LIKE '%高雄%'"
																	+ "OR showAddr LIKE '%屏東%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);//
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is south
			
			if(region.equals("east")) { // 篩選為東區
				System.out.println("Region without month is east? Answer: " + region);
				List<Object[]> r19 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																	+ "FROM ActivityInfoBean ac, TagInfoBean tag, LocationInfoBean loc, TimeInfoBean time "
																	+ "WHERE tag.tagId=ac.tagId AND ac.locationId=loc.locationId AND ac.activityId=time.activityId "
																	+ "AND YEAR(showDate)=:year "
																	+ "AND loc.locationId in (SELECT locationId FROM LocationInfoBean WHERE "
																	+ "showAddr LIKE '%宜蘭%' OR showAddr LIKE '%花蓮%' OR showAddr LIKE '%台東%' "
																	+ " OR showAddr LIKE '%臺東%') "
																	+ "AND time.showDate >= :today ORDER BY ac.clickAmt DESC", Object[].class)
					.setParameter("year", year)
					.setParameter("today", today)
					.setMaxResults(total)
					.getResultList(); // add MaxResults?
				System.out.println("r19= " + r19);
				if(r19 != null) {
					List<MainPage> list = new ArrayList<>();
					for(Object[] result: r19) {
						//另類的View
						MainPage mainContainer = new MainPage();
						mainContainer.setActivityId((Integer) result[0]);
						mainContainer.setBandPost((String) result[1]);
						mainContainer.setTagName((String) result[2]);//
						
						mainContainer.setHost((String) result[3]);
						mainContainer.setPlayer((String) result[4]);
						
						mainContainer.setTheme((String) result[5]);
						mainContainer.setSubTitle((String)result[6]);
						mainContainer.setActivityIntro((String)result[7]);
						mainContainer.setClickAmt((Integer)result[8]);
						mainContainer.setPhoto((byte[])result[9]);
						mainContainer.setShowAddr((String)result[10]);
						list.add(mainContainer);
					}
					return list;
				} // r19 == null
			} // region is east
		}
		return null;
	}
	
	@Override // +LocationInfo
	public List<List<ActivityInfoBean>> listByLocKeyword(List<List<Object>> listId) {
		if(listId!=null && !listId.isEmpty()) {
			System.out.println("enter hibernate");
			System.out.println("listId= " + listId);
			// 先從Location找關鍵字的locationId
			// 哪些活動使用這個locationId
			List<List<ActivityInfoBean>>  activityList = new ArrayList<List<ActivityInfoBean>>();
			String hql20 = " FROM ActivityInfoBean WHERE locationId=:locationId";
			for(List<Object> result1: listId) { // [[1, ..., ], [..., ..., ]]
				System.out.println("result1= " + result1); // [1]
				for(Object result2: result1 ) { // 1
					System.out.println("result2= " + result2);
					List<ActivityInfoBean> r20 = this.getSession()
							.createQuery(hql20, ActivityInfoBean.class)
							.setParameter("locationId", result2)
							.list();
//					System.out.println(r18);
//					activityList.add(r18);
					activityList.add(r20);
				}
			}
			return activityList;
		}
		return null;
	}
	
	@Override
	public Object isIdExist(Integer activityId) {
		if(activityId!=null) {
			Object r21 = this.getSession().createQuery("FROM ActivityInfoBean WHERE activityId = :activityId")
				.setParameter("activityId", activityId)
				.uniqueResult();
			if(r21 !=null) {
				return r21;
			} else {
				return null;
			}
		}
		return null;
	}
	
	@Override
	public ActivityInfoDetail listActivityDetailByAcId(Integer activityId) {
		if(activityId != null) {
			System.out.println("activityId != null");
			Object[] r22 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.photo, ac.bandIntro, ac.purchaseWeb, ac.clickAmt"
										+ ", time.showDate, loc.showAddr, loc.showPlace, time.enterTime, time.showTime, time.showTotalTime "
										+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
										+ "WHERE ac.tagId = tag.tagId AND ac.activityId = time.activityId AND ac.locationId=loc.locationId  AND ac.activityId=:activityId", Object[].class)
				.setParameter("activityId", activityId)
				.uniqueResult();
			if(r22!=null) {
				System.out.println("r22 != null");
				List<TicketSettingBean> ticketSetting = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId=:activityId", TicketSettingBean.class)
					.setParameter("activityId", activityId)
					.list();
				System.out.println("ticketSetting= " + ticketSetting);
				System.out.println(r22[0]);
				ActivityInfoDetail detail = new ActivityInfoDetail();
				detail.setActivityId((Integer)r22[0]);
				detail.setBandPost((String)r22[1]);
				detail.setTagName((String)r22[2]);
				detail.setHost((String)r22[3]);
				detail.setPlayer((String)r22[4]);
				detail.setTheme((String)r22[5]);
				detail.setSubTitle((String)r22[6]);
				detail.setActivityIntro((String)r22[7]);
				detail.setPhoto((byte[])r22[8]);
				detail.setBandIntro((String)r22[9]);
				detail.setPurchaseWeb((String)r22[10]);
				detail.setClickAmt((Integer)r22[11]);
				detail.setShowDate((java.util.Date)r22[12]);
				detail.setShowAddr((String)r22[13]);
				detail.setShowPlace((String)r22[14]);
				detail.setEnterTime((java.time.LocalTime)r22[15]);
				detail.setShowTime((java.time.LocalTime)r22[16]);
				detail.setShowTotalTime((Integer)r22[17]);
				detail.setTicketSettingInfo(ticketSetting);
				
				return detail;
			}
		}
		return null;
	}


	@Override
	public List<MainPage> searchBySubTitle(String subTitle, Integer total) {
		if(subTitle!=null && !subTitle.isEmpty() && total!=null) {
			System.out.println("date today is: " + today);
			List<Object[]> r23 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND subTitle LIKE :subTitle ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("subTitle", "%" + subTitle + "%")
				.setMaxResults(total)
				.getResultList();
			System.out.println("r23= " + r23);
			if(r23 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r23) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		} else if(total==null) {
			System.out.println("date today is: " + today);
			List<Object[]> r23 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND subTitle LIKE :subTitle ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("subTitle", "%" + subTitle + "%")
				.setMaxResults(10)
				.getResultList();
			System.out.println("r23= " + r23);
			if(r23 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r23) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		}
		return null;
	}

	@Override
	public List<MainPage> searchByPlayer(String player, Integer total) {
		if(player!=null && !player.isEmpty() && total!=null) {
			System.out.println("date today is: " + today);
			List<Object[]> r24 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND player LIKE :player ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("player", "%" + player + "%")
				.setMaxResults(total)
				.getResultList();
			System.out.println("r24= " + r24);
			if(r24 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r24) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		} else if(total==null) {
			System.out.println("date today is: " + today);
			List<Object[]> r24 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND player LIKE :player ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("player", "%" + player + "%")
				.setMaxResults(10)
				.getResultList();
			System.out.println("r24= " + r24);
			if(r24 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r24) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		}
		return null;
	}
	
	@Override
	public List<MainPage> searchByTag(String tagName, Integer total) {
		if(tagName!=null && !tagName.isEmpty() && total!=null) {
			System.out.println("date today is: " + today);
			List<Object[]> r25 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc  "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND tagName LIKE :tagName ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("player", "%" + tagName + "%")
				.setMaxResults(total)
				.getResultList();
			System.out.println("r25= " + r25);
			if(r25 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r25) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		} else if(total==null) {
			System.out.println("date today is: " + today);
			List<Object[]> r25 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc  "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND tagName LIKE :tagName ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("tagName", "%" + tagName + "%")
				.setMaxResults(10)
				.getResultList();
			System.out.println("r25= " + r25);
			if(r25 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r25) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		}
		return null;
	}

	@Override
	public List<MainPage> listActivityByTagId(Integer tagId, Integer total) {
		if(tagId != null && total != null) {
			System.out.println("date today is: " + today);
			List<Object[]> r26 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND ac.tagId = :tagId ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("tagId", tagId)
				.setMaxResults(total)
				.getResultList();
			System.out.println("r26= " + r26);
			if(r26 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r26) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		} else if(total==null) {
			System.out.println("date today is: " + today);
			List<Object[]> r26 = this.getSession().createQuery("SELECT ac.activityId, ac.bandPost, tag.tagName, ac.host, ac.player, ac.theme, ac.subTitle, ac.activityIntro, ac.clickAmt, ac.photo, loc.showAddr "
																+ "FROM ActivityInfoBean ac, TagInfoBean tag, TimeInfoBean time, LocationInfoBean loc "
																+ "WHERE ac.tagId = tag.tagId AND ac.activityId=time.activityId AND ac.locationId=loc.locationId "
																+ "AND time.showDate >= :today AND ac.tagId = :tagId ORDER BY clickAmt DESC", Object[].class)
				.setParameter("today", today)
				.setParameter("tagId", tagId)
				.setMaxResults(10)
				.getResultList();
			System.out.println("r26= " + r26);
			if(r26 != null) {
				List<MainPage> list = new ArrayList<>();
				for(Object[] result: r26) {
					//另類的View
					MainPage mainContainer = new MainPage();
					mainContainer.setActivityId((Integer) result[0]);
					mainContainer.setBandPost((String) result[1]);
					mainContainer.setTagName((String) result[2]); //
					
					mainContainer.setHost((String)result[3]);
					mainContainer.setPlayer((String)result[4]);
					
					mainContainer.setTheme((String) result[5]);
					mainContainer.setSubTitle((String)result[6]);
					mainContainer.setActivityIntro((String)result[7]);
					mainContainer.setClickAmt((Integer)result[8]);
					mainContainer.setPhoto((byte[])result[9]);
					mainContainer.setShowAddr((String)result[10]);
					list.add(mainContainer);
					
				}
				return list;
			}
		}
		return null;
	}
}
