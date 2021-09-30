package tw.org.iii.cma.MusicWeb.C.Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;
import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;
import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;
import tw.org.iii.cma.MusicWeb.C.Service.ActivityInfoService;
import tw.org.iii.cma.MusicWeb.C.Service.LocationInfoService;
import tw.org.iii.cma.MusicWeb.C.Service.TimeInfoService;

@Controller
public class ShowActivityController {

	@Autowired
	private ActivityInfoService activityInfo;
	@Autowired
	private TimeInfoService timeInfo;
	@Autowired
	private LocationInfoService locationInfo;
	
	@GetMapping(path= {"/customer/pages/showactivity.page"})
	public String method(ActivityInfoBean bean, Model model, HttpSession session) throws Exception {
		
		List<MainPage> activityList3 = activityInfo.listDefForMainPage(3); // 傳入total指定筆數
		Object count = activityInfo.countActivityAmt();
		
		// 方法一在Controller Encode
		// 方法二在jsp頁面Decode
//		ActivityInfoBean activity = activityInfo.selectActivityById(55); // photo 顯示[55, 98, ..]
//		byte[] photo = activity.getPhoto(); // [B@42b88823
//		String encodePhoto2 = Base64.getEncoder().encodeToString(photo); //顯示在網頁為 iVBORw0KGgo... 
//		BufferedImage image = ImageIO.read(new ByteArrayInputStream(photo));
		
		System.out.println("count= " + count);
		// 活動資訊的標籤編號顯示標籤名稱。 從活動資訊創查詢? 須再多創一個Class做getter, setter取資料
		model.addAttribute("activityList", activityList3); // 傳整個bean  
//		model.addAttribute("photoModel", new String(photo, "UTF-8")); // 操作byte[]會出現亂碼
		System.out.println("hola");
//		return "/pages/activity"; // try single extract
		return "/customer/pages/mainpage"; // try several result
	}
	
	@RequestMapping(path= {"/customer/pages/showactivity/filter"})
	public String filtYear(Integer year, String month, String region, Model model) {
		System.out.println("Hi");
		System.out.println(year);
		System.out.println(month==null);
		System.out.println(region);
		
		Integer startMonth=1, endMonth=3;
		
		if(month.equals("Q1")) {//前端給什麼name? -> 'Q1'
			startMonth = 1;
			endMonth = 3;
		} else if(month.equals("Q2")) {
			startMonth = 4;
			endMonth = 6;
		} else if(month.equals("Q3")) {
			startMonth = 7;
			endMonth = 9;
		} else if(month.equals("Q4")) {//4
			startMonth = 10;
			endMonth = 12;
		} else {
			startMonth=null;
			endMonth=null;
		}

		
		if(year!=null && region.equals("地區")){ // 判斷年月
			List<MainPage> list = activityInfo.listByDateOption(year, 1, 2, 4); // startMonth, endMonth待補上邏輯
			if(!list.isEmpty()) {
				model.addAttribute("activityList", list);
			} else {
				return "redirect:/customer/pages/showactivity.page"; // null傳default
			}
		} else if(!region.equals("地區") && year==null && startMonth==null && endMonth==null) { // 僅判斷地區
			System.out.println("has region to filt");
			// 如何從 北中南 關鍵字搜尋各區域??
			// 從[Id list]去抓? [1, 4, 5], 程式只撈一個關鍵字
			// MainPage迴圈繞關鍵字?
			// V MainPage set HQL語法結果
			List<MainPage> showAddrByKeyword = activityInfo.listByRegion(region, 4);
			if(!showAddrByKeyword.isEmpty()) {
				model.addAttribute("activityList", showAddrByKeyword);
			} else {
				return "redirect:/customer/pages/showactivity.page"; // null傳default
			}
		} else if(!region.equals("地區") && year!=null) { // 判斷年月+地區
			List<MainPage> showDateAndRegOption = activityInfo.listByDateAndRegOption(year, startMonth, endMonth, region, 4);
			if(!showDateAndRegOption.isEmpty()) {
				model.addAttribute("activityList", showDateAndRegOption);
			} else {
				System.out.println("no data");
				return "redirect:/customer/pages/showactivity.page"; // null傳default
			}
		} else { // 沒年份也沒地區
			return "redirect:/customer/pages/showactivity.page"; // 傳default
		}
		return "/customer/pages/mainpage";
	}
	
}


// 封存jsp頁面用法
//InputStream inputStream = new ByteArrayInputStream(photo, 0, photo.length);
//BufferedImage bi = ImageIO.read(inputStream);
//Image image = (Image) bi;
//out.print(image);

