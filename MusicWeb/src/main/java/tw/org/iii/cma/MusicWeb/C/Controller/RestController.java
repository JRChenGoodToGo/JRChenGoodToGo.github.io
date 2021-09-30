package tw.org.iii.cma.MusicWeb.C.Controller;

import java.net.URI;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import tw.org.iii.cma.MusicWeb.C.Controller.ActivityInfoDetail;
import tw.org.iii.cma.MusicWeb.C.Controller.MainPage;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;
import tw.org.iii.cma.MusicWeb.domain.CollectId;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;
import tw.org.iii.cma.MusicWeb.C.Service.ActivityInfoService;
import tw.org.iii.cma.MusicWeb.C.Service.CollectInfoService;
import tw.org.iii.cma.MusicWeb.C.Controller.UploadAc;

import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;
import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;
import tw.org.iii.cma.MusicWeb.domain.OrderInfoBean;
import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;
import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

import tw.org.iii.cma.MusicWeb.C.Service.LocationInfoService;
import tw.org.iii.cma.MusicWeb.C.Service.MemberInfoService;
import tw.org.iii.cma.MusicWeb.C.Service.OrderInfoService;
import tw.org.iii.cma.MusicWeb.C.Service.TagInfoService;
import tw.org.iii.cma.MusicWeb.C.Service.TicketSettingService;
import tw.org.iii.cma.MusicWeb.C.Service.TimeInfoService;
import tw.org.iii.cma.MusicWeb.C.Controller.LoginController;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(path = ("/pages/showactivity"))
public class RestController {

	@Autowired
	private ActivityInfoService activityInfo;

	@Autowired
	private CollectInfoService collectInfo;

	@Autowired
	private MemberInfoService memberInfo;

	private final String SITE = "http://localhost:8081/labboot";
	
	private MemberInfoBean memberInfoBean = new MemberInfoBean();
	@Autowired
	private MemberInfoService memberInfoService;
	
	
	
	@PostMapping(path="/login")
	public ResponseEntity<?> login(@RequestBody MemberInfoBean bean){
		String account=bean.getAccount();
		String passwd=bean.getPasswd();
	MemberInfoBean result = memberInfoService.login(account,passwd);
		if(result!=null) {
			Integer id = result.getMemberId();
			URI uri = URI.create(SITE + "/member/login/success" + id);
			String ok= "ok";
			return ResponseEntity.created(uri).body(result); //>> OK
		} else {
			System.out.println("error");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	

	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody MemberInfoBean bean) {
		if (bean != null && bean.getAccount() != null && !bean.getAccount().isEmpty() && bean.getEmail() != null
				&& !bean.getEmail().isEmpty() && bean.getPasswd() != null && !bean.getPasswd().isEmpty()
				&& bean.getName() != null && !bean.getName().isEmpty()) {
			
		boolean accountExist = memberInfo.isAccountExist(bean.getAccount());
		
		if(!accountExist) {
		
			MemberInfoBean checkUser = memberInfo.register(bean);
			Integer id= checkUser.getMemberId();
			System.out.println(checkUser);
			System.out.println("Yes you can insert");
			URI uri = URI.create(SITE + "/pages/showactivity/register/success"+id);
			String ok= "ok";
			return ResponseEntity.created(uri).body(checkUser); // >>ok
		}
		else {
			System.out.println("error");
			return new ResponseEntity<>("register error", HttpStatus.BAD_REQUEST);
		}}System.out.println("fail");
		return ResponseEntity.noContent().build();}

	@GetMapping(path="/count-total")
	public ResponseEntity<?> countAmt() {
		Object activityAmt = activityInfo.countActivityAmt();
		if(activityAmt!=null) {
			return ResponseEntity.ok("Total Activity Amt is: " + activityAmt);
		}
		System.out.println("bad");
		return ResponseEntity.noContent().build();
	}
	// 主頁的顯示Def活動方法，照點擊次數列出未過期(今日以後)的活動
	@GetMapping(path="/def/{total}")
	public ResponseEntity<List<MainPage>> listDefMainPage(
					@PathVariable("total") Integer total) {
		
//		System.out.println("hola1");
//		System.out.println(total);
		List<MainPage> activityList = activityInfo.listDefForMainPage(total);
//		Object count = activityInfo.countActivityAmt();
//		System.out.println("total amount is: " + count);
		if(activityList!=null && !activityList.isEmpty()) {
			return ResponseEntity.ok(activityList);
		} else {
			System.out.println("??");
			return ResponseEntity.notFound().build();
		}
	} 
	// 主頁的顯示活動方法
	@GetMapping(path="/area/{area}/{total}") // test filter region
	public ResponseEntity<List<MainPage>> listByRegion(
					@PathVariable("area") String area, 
					@PathVariable("total") Integer total){
		List<MainPage> listByRegion = activityInfo.listByRegion(area, total);
		if(listByRegion!=null && !listByRegion.isEmpty()) {
			return ResponseEntity.ok(listByRegion);
		} else {
			System.out.println("no data?");
			return ResponseEntity.noContent().build();
		}
	}
	// 主頁的顯示活動方法
	@GetMapping(path="/year/{year}/{total}")
	public ResponseEntity<List<MainPage>> listByDate(
					@PathVariable("year") Integer year, 
					@PathVariable("total") Integer total) {
		
		
		List<MainPage> listByDate = activityInfo.listByDateOption(year, null, null, total);
		if(listByDate!=null) {
			System.out.println("only filter year");
			return ResponseEntity.ok(listByDate);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// 主頁的顯示活動方法 season為Q1~Q4
	@GetMapping(path="/year-season/{year}-{season}/{total}")
	public ResponseEntity<List<MainPage>> listByDate(
					@PathVariable("year") Integer year, 
					@PathVariable("season") String season, 
					@PathVariable("total") Integer total) {
		
		Integer startMonth=1, endMonth=3;
		
		if(season.equals("Q1")) {//前端給什麼name? -> 'Q1'
			startMonth = 1;
			endMonth = 3;
		} else if(season.equals("Q2")) {
			startMonth = 4;
			endMonth = 6;
		} else if(season.equals("Q3")) {
			startMonth = 7;
			endMonth = 9;
		} else {//4
			startMonth = 10;
			endMonth = 12;
		}
		
		List<MainPage> listByDate = activityInfo.listByDateOption(year, startMonth, endMonth, total);
		if(listByDate!=null && !listByDate.isEmpty()) {
			System.out.println("only filter year and month");
			return ResponseEntity.ok(listByDate);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// 主頁的顯示活動方法
	@GetMapping(path="/year-season-area/{year}-{season}-{area}/{total}") // filter year, month, region
	public ResponseEntity<List<MainPage>> listByDateAndReg(
					@PathVariable("year") Integer year, 
					@PathVariable("season") String season, 
					@PathVariable("area") String region, 
					@PathVariable("total") Integer total){
		
		Integer startMonth=1, endMonth=3;
		
		if(season.equals("Q1")) {//前端給什麼name? -> 'Q1' 
			startMonth = 1;
			endMonth = 3;
		} else if(season.equals("Q2")) {
			startMonth = 4;
			endMonth = 6;
		} else if(season.equals("Q3")) {
			startMonth = 7;
			endMonth = 9;
		} else {//4
			startMonth = 10;
			endMonth = 12;
		}

		List<MainPage> listByDateAndRegOption = activityInfo.listByDateAndRegOption(year, startMonth, endMonth, region, total);
		if(listByDateAndRegOption!=null && !listByDateAndRegOption.isEmpty()) {
			System.out.println("filter year, month and region");
			return ResponseEntity.ok(listByDateAndRegOption);
		} else {
			return  ResponseEntity.noContent().build();
		}
	}
	
	// 主頁的顯示活動方法
	@GetMapping(path="/year-area/{year}-{area}/{total}") // filter year and region
	public ResponseEntity<List<MainPage>> listByDateAndReg(
					@PathVariable("year") Integer year, 
					@PathVariable("area") String region, 
					@PathVariable("total") Integer total){
		
		List<MainPage> listByDateAndRegOption = activityInfo.listByDateAndRegOption(year, null, null, region, total);
		if(listByDateAndRegOption!=null && !listByDateAndRegOption.isEmpty()) {
			System.out.println("filter year and region");
			return ResponseEntity.ok(listByDateAndRegOption);
		} else {
			return  ResponseEntity.noContent().build();
		}
	}
	
	// 列出所有活動，排序依照活動編號
	@RequestMapping(path="/start-total/{start}-{total}") // zero-base
	public ResponseEntity<List<ActivityInfoBean>>  listAllActivity(
					@PathVariable("start") Integer start, 
					@PathVariable("total") Integer total) {
		System.out.println("hola2");
		List<ActivityInfoBean> activityList4 = activityInfo.listActivity(start, total);
//		byte[] photo = activityList4.get(0).getPhoto();
//		String encodePhoto = Base64.getEncoder().encodeToString(photo);
		Object count = activityInfo.countActivityAmt();
		System.out.println("total amount is: " + count);
		if(activityList4!=null && !activityList4.isEmpty()) {
			return ResponseEntity.ok(activityList4);
		}
		System.out.println("start position out of bound");
		return ResponseEntity.badRequest().build();
	}
	// 根據活動編號挑出該筆活動資訊表資料
	@GetMapping(path="/acId/{activityId}")
	public ResponseEntity<?> selectOneByAcId(@PathVariable("activityId") Integer id) {
		if(id!=null) {
			ActivityInfoBean activity = activityInfo.selectActivityById(id);
			if(activity != null) {
				System.out.println(activity);
				return ResponseEntity.ok(activity);
			} else {
				System.out.println("no such Id");
				return ResponseEntity.notFound().build();
			}
		} else {
			System.out.println("please check id");
			return ResponseEntity.notFound().build();
		}
	}
	// 根據會員編號列出所擁有的活動
	@GetMapping(path="/memId-total/{memberId}-{total}") // change position
	public ResponseEntity<?> listAcByMemberId(
					@PathVariable("memberId") Integer memberId, 
					@PathVariable("total") Integer total) {
		List<ActivityInfoBean> activityList = activityInfo.listActivityPerMember(memberId, total);
		if(activityList != null && !activityList.isEmpty()) {
			return ResponseEntity.ok(activityList);
		} else {
			System.out.println("no such data");
			return ResponseEntity.noContent().build();
		}
	}
	
	// 更新方法，非首頁
	@PutMapping(path="/update/{memberId}")
	public ResponseEntity<?> updateAcByMemberId(
					@PathVariable("memberId") Integer memberId, 
					@RequestBody ActivityInfoBean bean) {
		ActivityInfoBean update = activityInfo.updateActivity(memberId, bean);
		if(update != null && update.getActivityId()!=null) {
			
			return ResponseEntity.ok(bean);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// 詳細活動資訊頁面
	@GetMapping(path="/detail/{activityId}") // {..., ..., }
	public ResponseEntity<ActivityInfoDetail> listActivityDetail(@PathVariable("activityId") Integer activityId) {
		if(activityId!=null) {
			ActivityInfoDetail acDetail = activityInfo.listActivityDetailByAcId(activityId);
			if(acDetail!=null) {
				return ResponseEntity.ok(acDetail);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	// 根據地區計算活動數量
	@GetMapping(path="/count-loc") // /count-loc?id=1
	public ResponseEntity<?> countActivityAmtByLocId(Integer id) {
		Object countByLocId = activityInfo.countActivityAmtByLocId(id);
		if(countByLocId!=null) {
			return ResponseEntity.ok(String.format(
					" <h3>Total Activity Amount of Corresponding <label style='color:violet'>LocationId</label> '%d' is: ", id)
					+"<label style='color:violet'>" +  countByLocId + "</label></h3>");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	// 根據標籤計算活動數量
	@GetMapping(path="/count-tag") // /count-tag?id=1
	public ResponseEntity<?> countActivityAmtByTagId(Integer id) {
		Object countByTagId = activityInfo.countActivityAmtByTagId(id);
		if(countByTagId!=null) {
			return ResponseEntity.ok(String.format(
					" <h3>Total Activity Amount of Corresponding <label style='color:violet'>TagId</label> '%d' is: ", id) 
					+"<label style='color:violet'>" + countByTagId + "</label></h3>");
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	//------------------ 9/2 截止點 ------------------
	// 以地區或標籤推薦
	@GetMapping(path="/detail/recommand")
	public void method() {
		
	}
	
	// 增加點擊次數
	@GetMapping(path="/click/{activityId}")
	public ResponseEntity<?> addClickAmt(@PathVariable("activityId") Integer activityId) {
		boolean clickAdd = activityInfo.addClick(activityId);
		System.out.println(clickAdd);
		if(clickAdd) {
			return ResponseEntity.ok(String.format("<h3>Add ClickAmt of Activity ID "
													+ "<label style='color:violet'> '%d' </label> Successful "
												 + "</h3>", activityId) );
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// 9/4 不需要
	@GetMapping(path="/{area}/{year}/{season}/{total}") // test filter region
	public ResponseEntity<List<MainPage>> listDef(
					@PathVariable("area") String area, 
					@PathVariable("year") Integer year, 
					@PathVariable("season") String season, 
					@PathVariable("total") Integer total){
		
		System.out.println(area);
		System.out.println(year);
		System.out.println(season);
		System.out.println(total);
		
		if(area!=null && year==null && season==null) {
			List<MainPage> listByRegion = activityInfo.listByRegion(area, total);
			if(listByRegion!=null && !listByRegion.isEmpty()) {
				return ResponseEntity.ok(listByRegion);
			} else {
				System.out.println("no data?");
				return ResponseEntity.noContent().build();
			}
			
		} else if(area==null && year!=null && season==null){
			List<MainPage> listByYear = activityInfo.listByDateOption(year, null, null, total);
			if(listByYear!=null) {
				return ResponseEntity.ok(listByYear);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else if (area==null && year==null && season!=null){
			Integer startMonth=1, endMonth=3;
			
			if(season.equals("Q1")) {//前端給什麼name? -> 'Q1'
				startMonth = 1;
				endMonth = 3;
			} else if(season.equals("Q2")) {
				startMonth = 4;
				endMonth = 6;
			} else if(season.equals("Q3")) {
				startMonth = 7;
				endMonth = 9;
			} else {//4
				startMonth = 10;
				endMonth = 12;
			}
			
			List<MainPage> listBySeason = activityInfo.listByDateOption(year, startMonth, endMonth, total);
			if(listBySeason != null) {
				return ResponseEntity.ok(listBySeason);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else {
			List<MainPage> listDef = activityInfo.listDefForMainPage(total);
			if(listDef != null) {
				return ResponseEntity.ok(listDef);
			} else {
				return ResponseEntity.noContent().build();
			}
		}
	}

	
	
	
	@Autowired
	private OrderInfoService orderInfo;
	private final String orderSITE = "http://localhost:8082";

	
	// 9/4
	// V客戶購票後存入訂購資訊及更新庫存
	@PostMapping(path={"/ticketing/confirm/update/{activityId}"})
	public ResponseEntity<?> ticketing(@PathVariable("activityId") Integer activityId, 
							@RequestBody OrderInfoBean orderBean) {
		
		OrderInfoBean insertResult = orderInfo.insert(orderBean);
		if(insertResult != null) {
			Integer orderId = insertResult.getOrderId();
			URI uri = URI.create(orderSITE + "/ticketing/confirm/update/" + orderId);
			return ResponseEntity.created(uri).body(insertResult);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// V更新訂單資訊、同時變更庫存資訊
	@PutMapping(path="/ticketing/{activityId}/{ticketKind}")
	public ResponseEntity<?> updateTicketingInfo(
					@PathVariable("activityId") Integer activityId, 
					@PathVariable("ticketKind") String ticketKind, 
					@RequestBody OrderInfoBean orderBean) {
		OrderInfoBean orderUpdate = orderInfo.update(ticketKind, orderBean);
		if(orderUpdate != null) {
			return ResponseEntity.ok(orderUpdate);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	//--------9/5--------
	
	
	// 在首頁按下收藏進行插入
	@PostMapping(path="/collect")
	public ResponseEntity<CollectInfoBean> toCollect(
					@RequestBody CollectId collectId) {
		System.out.println(collectId);
		System.out.println("ready to insert");
		
		CollectInfoBean collectInfoInsert = collectInfo.insertCollectInfo(collectId.getMemberId(), collectId.getActivityId());
		System.out.println("insert success: " + collectInfoInsert);
		if(collectInfoInsert != null) {
			return ResponseEntity.ok(collectInfoInsert);
		} else {
			return ResponseEntity.badRequest().build(); 
		}
		
	}
	// 9/6
	// 在首頁取消收藏
	@DeleteMapping(path="/uncollect/{memberId}-{activityId}")
	public ResponseEntity<?> toCollect(@PathVariable("memberId") Integer memberId,
							@PathVariable("activityId") Integer activityId) {
		boolean deleteResult = collectInfo.deleteCollectInfo(memberId, activityId);
		if(deleteResult) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 依照副標題搜尋頁面功能
	@GetMapping(path="/subTitle/{subTitle}")
	public ResponseEntity<List<MainPage>> listBySubTitle(@PathVariable("subTitle") String subTitle) {
		List<MainPage> searchSubTitle = activityInfo.searchBySubTitle(subTitle, null);
		if(searchSubTitle != null) {
			return ResponseEntity.ok(searchSubTitle);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	// 依照歌手名稱搜尋頁面功能
	@GetMapping(path="/player/{player}")
	public ResponseEntity<List<MainPage>> listByPlayer(@PathVariable("player") String player) {
		List<MainPage> searchPlayer = activityInfo.searchByPlayer(player, null);
		if(searchPlayer != null) {
			return ResponseEntity.ok(searchPlayer);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	// 依照標籤名稱搜尋
	@GetMapping(path="/tag/{tagName}")
	public ResponseEntity<List<MainPage>> listByTag(@PathVariable("tagName") String tagName) {
		List<MainPage> searchTag = activityInfo.searchByTag(tagName, null);
		if(searchTag != null) {
			return ResponseEntity.ok(searchTag);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	//-----------9/6 21:00 ----------------
	// 依照標籤編號計算活動數量
	@GetMapping(path="/count-by-tagId/{tagId}")
	public ResponseEntity<?> countActivityByTagId(@PathVariable("tagId") Integer tagId) {
		Object countActivityByTagId = activityInfo.countActivityAmtByTagId(tagId);
		if(countActivityByTagId!= null) {
			return ResponseEntity.ok(String.format("The amount of activity with tagId %d is ", tagId) + countActivityByTagId + " unit");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// 依照標籤編號找活動
	@GetMapping(path="/tagId-total/{tagId}-{total}")
	public ResponseEntity<List<MainPage>> listActivityByTagId(
					@PathVariable("tagId") Integer tagId,
					@PathVariable("total") Integer total) {
		List<MainPage> activityListByTagId = activityInfo.listActivityByTagId(tagId, total);
		if(activityListByTagId != null && !activityListByTagId.isEmpty()) {
			return ResponseEntity.ok(activityListByTagId);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
		
}