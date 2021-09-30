package tw.org.iii.cma.MusicWeb.C.Controller;



import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.org.iii.cma.MusicWeb.C.Controller.UploadAc;
import tw.org.iii.cma.MusicWeb.domain.*;

import tw.org.iii.cma.MusicWeb.C.Service.*;


@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(path="/pages/activity/edit")
public class UploadController {

	@Autowired
	private TagInfoService tagInfo;
	@Autowired
	private LocationInfoService locInfo;
	@Autowired
	private ActivityInfoService activityInfo;
	@Autowired
	private TimeInfoService timeInfo;
	@Autowired
	private TicketSettingService ticketSetting;
	
	private Integer clickAmt=0;
	
	private UploadAc uploadRes = new UploadAc(); // 萬惡
	private final String SITE = "http://localhost:8082";
	
	
	@PostMapping(path="/users/upload", produces = "application/json")
	public ResponseEntity<?> upload( @RequestBody UploadAc uploadReq,
						String ticketKind2, Float cost2, Integer storage2) {
		
		System.out.println("enter upload");
		
		LocationInfoBean locBean = new LocationInfoBean();
		TagInfoBean tagBean = new TagInfoBean();
		ActivityInfoBean acBean = new ActivityInfoBean();
		TimeInfoBean timeBean = new TimeInfoBean();
		TicketSettingBean tksBean = new TicketSettingBean();
		
		Object checkLocId = locInfo.findIdByAddr(uploadReq.getShowAddr());
		// 若使用者有輸入showAddr要抓使用者輸入的
		if(uploadReq.getShowAddr()!=null && !uploadReq.getShowAddr().isEmpty()
				&& checkLocId==null) {// 原本沒該筆資料
			// 會與使用者輸入的id衝突嗎? -> 會以新插入的為準設新id
			System.out.println("set new location");
			locBean.setShowAddr(uploadReq.getShowAddr());
			locBean.setShowPlace(uploadReq.getShowPlace()); // loc完成設定
			
			LocationInfoBean locInsert = locInfo.insertLocation(locBean); // loc insert成功
			Integer newLocId = locInsert.getLocationId();
			acBean.setLocationId(newLocId); // 設ac的locId為新拿到的ID
			
			// 有設新location才會在專屬類別插入新的
			uploadRes.setLocationId(newLocId);
			uploadRes.setShowAddr(locInsert.getShowAddr());
			uploadRes.setShowPlace(locInsert.getShowPlace());
		}
		if(checkLocId != null) {
			acBean.setLocationId((Integer)checkLocId);
		}
		
		Object checkTagId = tagInfo.findIdentifier(uploadReq.getTagName());
		// 若使用者有輸入tagName要抓使用者輸入的
		if(uploadReq.getTagName()!=null && !uploadReq.getTagName().isEmpty()
				&& checkTagId==null) {
			// 會與使用者輸入的id衝突嗎? -> 會以新插入的為準設新id
			System.out.println("set new tag");
			tagBean.setTagName(uploadReq.getTagName()); // tag完成設定
			TagInfoBean tagInsert = tagInfo.insertTag(tagBean); // tag insert成功
			Integer newTagId = tagInsert.getTagId(); 
			acBean.setTagId(tagInsert.getTagId()); // 設ac的tagId為新拿到的ID
			
			// 有設新tag才會在專屬類別插入新的
			uploadRes.setTagId(newTagId);
			uploadRes.setTagName(tagInsert.getTagName());
			
		}
		if(checkTagId != null) {
			acBean.setTagId((Integer)checkTagId);
		}
		
		// 將上傳資料設入活動資訊表
		acBean.setClickAmt(clickAmt); // 讓預設為0
		// 若無新設的loc, tag 設定為傳入的編號
		acBean.setLocationId(acBean.getLocationId()==null? uploadReq.getLocationId(): acBean.getLocationId());
		acBean.setTagId(acBean.getTagId()==null? uploadReq.getTagId(): acBean.getTagId());
		
		acBean.setPhoto(uploadReq.getPhoto());
		acBean.setHost(uploadReq.getHost());
		acBean.setPlayer(uploadReq.getPlayer());
		acBean.setTheme(uploadReq.getTheme());
		acBean.setSubTitle(uploadReq.getSubTitle());
		acBean.setActivityIntro(uploadReq.getActivityIntro());
		acBean.setBandIntro(uploadReq.getBandIntro());
		acBean.setTape(uploadReq.getTape());
		acBean.setPurchaseWeb(uploadReq.getPurchaseWeb());
		acBean.setMemberId(uploadReq.getMemberId());
		acBean.setClickAmt(uploadReq.getClickAmt());

		// 將上傳資料設入時間資訊表
		timeBean.setShowDate(uploadReq.getShowDate());
		timeBean.setEnterTime(uploadReq.getEnterTime());
		timeBean.setShowTime(uploadReq.getShowTime());
		timeBean.setShowTotalTime(uploadReq.getShowTotalTime());
		
		
		// 將上傳資料設入票券設定表
		tksBean.setSoldDeadline(uploadReq.getSoldDeadline());
		tksBean.setTicketKind(uploadReq.getTicketKind1());
		tksBean.setCost(uploadReq.getCost1());
		tksBean.setStorage(uploadReq.getStorage1());
		
		System.out.println("before insert acBean: " + acBean);
		System.out.println("before insert timeBean: " + timeBean);
		System.out.println("before insert tksBean: " + tksBean);
		
		ActivityInfoBean acInsert = activityInfo.insertActivity(acBean); // 插入成功
		TimeInfoBean timeInsert = timeInfo.insertTimeInfo(timeBean); // 插入成功
		TicketSettingBean tksInsert = ticketSetting.insertTicketSetting(tksBean); // 插入成功
		
		System.out.println(acInsert);
		System.out.println(timeInsert);	
		System.out.println(tksInsert);
		
		// 限定最多兩筆情況下可插入兩筆同活動編號的資料
		if(uploadReq.getTicketKind2()!=null && !uploadReq.getTicketKind2().isEmpty() 
				&& uploadReq.getCost2()!=null && uploadReq.getStorage2() !=null) {
			System.out.println("票種2存在");
			TicketSettingBean newTicketSetting = new TicketSettingBean();
			newTicketSetting.setTicketKind(uploadReq.getTicketKind2());
			newTicketSetting.setCost(uploadReq.getCost2());
			newTicketSetting.setStorage(uploadReq.getStorage2());
			newTicketSetting.setSoldDeadline(tksInsert.getSoldDeadline());
			newTicketSetting.setActivityId(tksInsert.getActivityId());
			TicketSettingBean tks2Insert = ticketSetting.insertTicketSetting(newTicketSetting);
			System.out.println(tks2Insert);
			
			// 在專屬類別設第二筆票種資料
			if(acInsert!=null && timeInsert!=null && tksInsert!=null) {
				System.out.println("插入第二筆票種資訊");
				uploadRes.setTicketKind2(tks2Insert.getTicketKind());
				uploadRes.setCost2(tks2Insert.getCost());
				uploadRes.setStorage2(tks2Insert.getStorage());
			}
		}
	
		// 僅回傳活動資訊表內容
//		if(acInsert!=null && timeInsert!=null && tksInsert!=null) {
//			Integer acId = acInsert.getActivityId();
//			URI uri = URI.create(SITE + "/users/save/" + acId);
//			return ResponseEntity.created(uri).body(acInsert);
//		} else {
//			return ResponseEntity.noContent().build();
//		}
		
		
		// 4, 5, 6 都有插入資料
		// 回傳此次上傳所有內容
		if(acInsert!=null && timeInsert!=null && tksInsert!=null) {
			System.out.println("preparing response");
			// 在專屬類別設各種插入資訊
			System.out.println(acInsert);
			Integer id = acInsert.getActivityId();
			uploadRes.setActivityId(id); // (Integer)acInsert.getActivityId()
			uploadRes.setPhoto(acInsert.getPhoto());
			uploadRes.setHost(acInsert.getHost());
			uploadRes.setPlayer(acInsert.getPlayer());
			uploadRes.setTheme(acInsert.getTheme());
			uploadRes.setSubTitle(acInsert.getSubTitle());
			uploadRes.setActivityIntro(acInsert.getActivityIntro());
			uploadRes.setBandIntro(acInsert.getBandIntro());
			
			// 若沒有新標籤而使用舊標籤，設入舊標籤內容
			// 上已插入新標籤內容如何因應? -> 先找到該筆id資料，設該筆tagName到回傳body身上
			uploadRes.setTagId(uploadRes.getTagId()==null? uploadReq.getTagId(): uploadRes.getTagId());
			uploadRes.setTagName(uploadRes.getTagName()==null? tagInfo.select(uploadReq.getTagId()).getTagName(): uploadRes.getTagName());
			
			uploadRes.setTape(acInsert.getTape());
			uploadRes.setPurchaseWeb(acInsert.getPurchaseWeb());
			uploadRes.setMemberId(acInsert.getMemberId());
			uploadRes.setClickAmt(acInsert.getClickAmt());
			
			// 若沒有新地區而使用舊地區內容，設入舊地區內容
			uploadRes.setLocationId(uploadRes.getLocationId()==null? uploadReq.getLocationId(): uploadRes.getLocationId());
			uploadRes.setShowAddr(uploadRes.getShowAddr()==null? locInfo.select(uploadReq.getLocationId()).getShowAddr(): uploadRes.getShowAddr());
			uploadRes.setShowPlace(uploadRes.getShowPlace()==null? locInfo.select(uploadReq.getLocationId()).getShowPlace(): uploadRes.getShowPlace());
			
			uploadRes.setShowDate(timeInsert.getShowDate());
			uploadRes.setEnterTime(timeInsert.getEnterTime());
			uploadRes.setShowTime(timeInsert.getShowTime());
			uploadRes.setShowTotalTime(timeInsert.getShowTotalTime());
			uploadRes.setSoldDeadline(tksInsert.getSoldDeadline());
			uploadRes.setTicketKind1(tksInsert.getTicketKind());
			uploadRes.setCost1(tksInsert.getCost());
			uploadRes.setStorage1(tksInsert.getStorage());

			
			Integer acId = acInsert.getActivityId();
			System.out.println("acId= " + acId);
			URI uri = URI.create(SITE + "/pages/showactivity/users/save/" + acId);
			
			return ResponseEntity.created(uri).body(uploadRes);
			
		} else { // 未插入資料
			return ResponseEntity.noContent().build();
		}
	}
}
