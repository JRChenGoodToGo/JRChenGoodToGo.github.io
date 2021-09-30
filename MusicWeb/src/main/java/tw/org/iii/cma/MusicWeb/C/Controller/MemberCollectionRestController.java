package tw.org.iii.cma.MusicWeb.C.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.org.iii.cma.MusicWeb.C.Service.CollectInfoService;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(path="/pages/activity/collection")
public class MemberCollectionRestController {

	@Autowired
	private CollectInfoService collectInfo;
	
	// 計算某會員收藏總數
	@GetMapping(path="/count-per-member/{memberId}")
	public ResponseEntity<?> countCollectAmt(@PathVariable("memberId") Integer memberId) {
		Object collectAmtCount = collectInfo.countCollectByMemberId(memberId);
		if(collectAmtCount != null) {
			return ResponseEntity.ok(String.format("<h3>The amount of collection from memberId %d is: ", memberId) + 
														"<label style='color:violet'>" + collectAmtCount + "</label>"
												 + "</h3>");
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// 列出某會員所收藏的CollectInfo資料
	@GetMapping(path="/list-per-member/{memberId}")
	public ResponseEntity<List<CollectInfoBean>> listCollectionByMemberId(@PathVariable("memberId") Integer memberId) {
		
		List<CollectInfoBean> collectionList = collectInfo.listAllCollection(memberId);
		if(collectionList != null && !collectionList.isEmpty()) {
			return ResponseEntity.ok(collectionList);
		} else {
			System.out.println("no such data");
			return ResponseEntity.noContent().build();
		}
	}
	// 列出某會員所收藏的詳細資料(同詳細活動資訊頁面)
	@GetMapping(path="/listDetail-per-member/{memberId}")
	public ResponseEntity<List<ActivityInfoDetail>> listDetailByMemberId(@PathVariable("memberId") Integer memberId) {
		
		List<ActivityInfoDetail> collectionList = collectInfo.listDetail(memberId);
		if(collectionList != null && !collectionList.isEmpty()) {
			return ResponseEntity.ok(collectionList);
		} else {
			System.out.println("no such data");
			return ResponseEntity.noContent().build();
		}
	}
	
	
	// 計算某活動被收藏數量
	@GetMapping(path="/count-per-activity/{activityId}")
	public ResponseEntity<?> countCollectedAmt(@PathVariable("activityId") Integer activityId) {
		Object collectedAmtCount = collectInfo.countCollectedAmt(activityId);
		if(collectedAmtCount!=null) {
			return ResponseEntity.ok(String.format("<h3>ActivityId %d was collected by :", activityId) + 
													"<label style='color:violet'>" + collectedAmtCount + "</label> person/people"
												 + "</h3>");
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// 列出某活動被收藏資料
	@GetMapping(path="/list-per-activity/{activityId}")
	public ResponseEntity<List<CollectInfoBean>> listWhoCollect(@PathVariable("activityId") Integer activityId) {
		List<CollectInfoBean> collectedDataList = collectInfo.listCollectedData(activityId);
		if(collectedDataList!=null && !collectedDataList.isEmpty()) {
			return ResponseEntity.ok(collectedDataList);
		} else {
			System.out.println("no such data");
			return ResponseEntity.noContent().build();
		}
	}
	// 在收藏頁取消收藏
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
}