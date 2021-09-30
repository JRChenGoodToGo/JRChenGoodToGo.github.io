package tw.org.iii.cma.MusicWeb.C.Controller;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;
import tw.org.iii.cma.MusicWeb.C.Service.ActivityInfoService;

@Controller
public class TryUploadController {

	@Autowired
	private ActivityInfoService activityInfoService;
	
	@PostMapping("/users/save") 
	public String method(ActivityInfoBean bean, @RequestParam("img") MultipartFile multipartFile) throws Exception {
		
		System.out.println("prepare store stuff");
		System.out.println("multipart= " + multipartFile + //@46bfda4
						   " length= " + multipartFile.getSize()); // 123928
		System.out.println("multipart bytes= " + multipartFile.getBytes());
		// directory: "user-photos/" + activityId
		// fileName: my bear.jpg
		// file
		byte[] multiByte = multipartFile.getBytes();
		String encodeMultiByte = Base64.getEncoder().encodeToString(multiByte);
		System.out.println(encodeMultiByte);
//		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		System.out.println(bean.getTagId());
		System.out.println(bean.getHost());
		System.out.println(bean.getPlayer());
		System.out.println(bean.getLocationId());
		System.out.println(bean.getMemberId());
		System.out.println(multiByte);
		
//		// [109, 121, 32, 98, 101, 97, 114, 46, 106, 112, 103]
//		System.out.println(bean.getPhoto());
//		char out[] = new char[bean.getPhoto().length * 2];
//	    for (int i = 0; i < bean.getPhoto().length; i++) {
//	        out[i * 2] = "0123456789ABCDEF".charAt((bean.getPhoto()[i] >> 4) & 15);
//	        out[i * 2 + 1] = "0123456789ABCDEF".charAt(bean.getPhoto()[i] & 15);
//	    }
//		System.out.println(out); // 6D7920626561722E6A7067
//		Path path = Paths.get("/" + "user-photos/" + fileName);
//		System.out.println("path= " + path);
		
		
		// fail
//		try{
//			byte[] fileByte = multipartFile.getBytes();
//			for(byte result: fileByte) {
//				System.out.println(result);
//				bean.setTagId(bean.getTagId());
//				bean.setBandPost(fileName);
//				bean.setHost(bean.getHost());
//				bean.setPlayer(bean.getPlayer());
//				bean.setBandIntro(Byte.toString(result) );
//				bean.setMemberId(bean.getMemberId());
//				bean.setLocationId(bean.getLocationId());
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		// fail
//		try(InputStream inputStream = multipartFile.getInputStream()){
//			System.out.println(inputStream);
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		};
		
		
		ActivityInfoBean insertObj = new ActivityInfoBean();
		insertObj.setTagId(bean.getTagId());
		insertObj.setBandPost(bean.getBandPost());
		insertObj.setHost(bean.getHost());
		insertObj.setPlayer(bean.getPlayer());
		insertObj.setTheme(bean.getTheme());
		insertObj.setSubTitle(bean.getSubTitle());
		insertObj.setActivityIntro(bean.getActivityIntro());
		insertObj.setBandIntro(bean.getBandIntro());
		insertObj.setLocationId(bean.getLocationId());
		insertObj.setTape(bean.getTape());
		insertObj.setPurchaseWeb(bean.getPurchaseWeb());
		insertObj.setMemberId(bean.getMemberId());
		insertObj.setPhoto(multiByte);
		ActivityInfoBean insert = activityInfoService.insertActivity(insertObj);
		System.out.println(insert);
		
		return "redirect:/";
	}
}
