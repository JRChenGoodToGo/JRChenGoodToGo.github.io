package tw.org.iii.cma.MusicWeb.C.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;
import tw.org.iii.cma.MusicWeb.C.Service.MemberInfoService;

@Controller
public class RegisterController{

	@Autowired
	private MemberInfoService memberInfo;
	
	@PostMapping(path= {"/customer/pages/register.controller"})
	public String method(MemberInfoBean bean, BindingResult bindingResult, String passwdConfirm, Model model, HttpSession session) {
		
//		System.out.println(bean == null); // false
//		System.out.println(bean.equals(null)); // false
		
//		System.out.println("account= " + bean.getAccount());
//		System.out.println("account blank= " + bean.getAccount().isBlank()); // true
//		System.out.println("account empty= " + bean.getAccount().isEmpty()); // true
//		System.out.println("email= " + bean.getEmail());
//		System.out.println("passwd= " + bean.getPasswd());
//		System.out.println("name= " + bean.getName());
		
//		System.out.println("passwdConfirm= " + passwdConfirm == null); // false
//		System.out.println("passwdConfirm isEmpty= " + passwdConfirm.isEmpty()); // true
		System.out.println("bindingResult= " + bindingResult);
		
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
		
		if(bindingResult!=null && bindingResult.hasFieldErrors()) {
			if(bindingResult.hasFieldErrors("account")) {
				errors.put("account", "account must be filled in!");
			}
		}
		// 都要有值
		if(bean==null || bean.getAccount().isEmpty() || bean.getEmail().isEmpty() || 
				bean.getPasswd().isEmpty() || bean.getName().isEmpty() || passwdConfirm.isEmpty()) {
			errors.put("nullData", "data must be filled in!");
			System.out.println("bean == null");
		}
		// 密碼輸入兩次須一樣
		if(!passwdConfirm.equals(bean.getPasswd())) {
			errors.put("passwdConfirm", "Passwd is not consistent with above one");
		}
		
//		System.out.println(errors);
		// 有任何錯誤停在register頁面
		if(errors != null && !errors.isEmpty()) {
			return "/customer/pages/register";
		}
		
		// 都有值判斷是否可註冊
		if(!bean.getAccount().isEmpty() && !bean.getEmail().isEmpty() 
				&& !bean.getPasswd().isEmpty() && !bean.getName().isEmpty()) {
			boolean accountExist = memberInfo.isAccountExist(bean.getAccount());
			if(!accountExist) {
				MemberInfoBean checkUser = memberInfo.register(bean);
				System.out.println(checkUser);
			}
		}
		return "/customer/secure/login";
	}
}
