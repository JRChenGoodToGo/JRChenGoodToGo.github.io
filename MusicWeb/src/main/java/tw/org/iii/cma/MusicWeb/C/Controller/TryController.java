package tw.org.iii.cma.MusicWeb.C.Controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

//@RestController
@Controller
@RequestMapping
public class TryController {

	@RequestMapping("/customer/pages/testinterceptor.controller")
	public String method(Model model , @CookieValue(value="loginStatus", defaultValue = "hi") String loginStatus, 
						@SessionAttribute(name="sessionKey", required=false) String sessionKey , 
						HttpSession session) {
		System.out.println("Enter TryController");
		System.out.println("sessionKey= " + sessionKey);
		System.out.println("loginStatus= " + loginStatus);
		
		Object user = session.getAttribute("user");
		Object loginCookie = session.getAttribute("loginStatus");
		
		System.out.println("user= " + user);
		System.out.println("loginStatus= " + loginCookie);
		System.out.println(user == null); // 登入前true
		System.out.println(user != null);// 登入前false
//		System.out.println(user.equals(null)); // cause Exception
		System.out.println(loginCookie == null); //  login過之後就會維持有值
//		System.out.println(loginCookie.equals(null)); // cause Exception
		if(user!= null) {
			return "/customer/pages/collection";
		}
		
		return "redirect:/customer";
	}
}
