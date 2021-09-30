package tw.org.iii.cma.MusicWeb.C.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckLoginController {

	@RequestMapping(path= {"/customer/pages/checklogin/collection"})
	public String loginCheck1(HttpSession session) {
		System.out.println("loginCheckController");
		
		Object user = session.getAttribute("user");
		
		
		System.out.println("user= " + user);
		if(user!= null) {
			return "/customer/pages/collection";
		}
		
		return "/customer/secure/login";
	}
	@RequestMapping(path= {"/customer/pages/checklogin/activitymanaging"})
	public String loginCheck2(HttpSession session) {
		System.out.println("loginCheckController");
		
		Object user = session.getAttribute("user");
		
		
		System.out.println("user= " + user);
		if(user!= null) {
			return "/customer/pages/activitymanaging";
		}
		
		return "/customer/secure/login";
	}

}
