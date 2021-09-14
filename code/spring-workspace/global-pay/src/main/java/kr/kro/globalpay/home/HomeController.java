package kr.kro.globalpay.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/member")
	public @ResponseBody String member() {
		
		return "member페이지";
	}
	
	@RequestMapping("/loginError")
	public @ResponseBody String loginError() {
		return "권한에 맞지 않는 페이지 입니다.";
	}
}
