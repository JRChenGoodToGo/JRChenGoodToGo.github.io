package tw.org.iii.cma.MusicWeb.C.Controller;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;
import tw.org.iii.cma.MusicWeb.C.Service.MemberInfoService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(path=("/member"))
public class LoginController {
	
	@Autowired
	private MemberInfoService memberInfoService;
	
	// 版本1 登入檢驗並回傳成功/失敗結果
//	@PostMapping(path="/login") 
//	public ResponseEntity<?> login(String account, String passwd){
//		MemberInfoBean login = memberInfoService.login(account,passwd);
//		Dictionary<String, String> dict = new Hashtable<String, String>();
//		if(login!=null) {
//			dict.put("state", "login successful");
//			return ResponseEntity.ok(dict);
//		} else {
//			System.out.println("error");
//			dict.put("state", "login fail");
//			return new ResponseEntity<>(dict, HttpStatus.BAD_REQUEST);
//			
//		}
	////版本2: 回傳輸入帳密 JSON
	@PostMapping(path="/login")
		public ResponseEntity<MemberInfoBean> login(String account, String passwd){
		MemberInfoBean login = memberInfoService.login(account,passwd);
			if(login!=null) {
				return ResponseEntity.ok(login);
			} else {
				System.out.println("error");
				return ResponseEntity.noContent().build();
			}
		}
		
		
	}

//	@Autowired
//	private MessageSource messageSource;
//	
//	@RequestMapping(path = {"/login"}, method = RequestMethod.POST)
//	public String method(String username, String password, Model model, 
//			HttpSession session, Locale locale) {
//		System.out.println(username);
//		System.out.println(password);
//		
//		
//		Map <String, String> errors = new HashMap<String, String>();
//		model.addAttribute("errors", errors); 
//		// 用model裝map的值 model[errors[username, ...], [k,v] , ,]
//		if(username == null || username.length()==0) {
//			errors.put("username", messageSource.getMessage("login.username.required", null, locale));
//		}
//		if(password == null || password.length()==0) {
//			errors.put("password", messageSource.getMessage("login.password.required", null, Locale.TAIWAN));
//		}
////		System.out.println("errors = " + errors);
//		if(errors != null && !errors.isEmpty()) { // errors一定存在?
//			return "/login";
//		} 
//		
//		
//		MemberInfoBean loginCheck = memberInfo.login(username, password);
//		if(loginCheck != null) {
//			session.setAttribute("user", loginCheck); // set 整個bean?
////			System.out.println("----");
////			System.out.println(session);
////			System.out.println("----");
////			Cookie cookie = new Cookie("loggedInCookie", loginCheck.getName().toString());
////			cookie.setMaxAge(60);
////			cookie.setPath("/pages");
////			session.setAttribute("loginStatus", cookie);
////			System.out.println("cookie= " + cookie);
//			return "redirect:/";
//		} else {
//			System.out.println("wrong user");
//			errors.put("password", messageSource.getMessage("login.fail", null, locale));
//			return "/login";
//		}
//	}

