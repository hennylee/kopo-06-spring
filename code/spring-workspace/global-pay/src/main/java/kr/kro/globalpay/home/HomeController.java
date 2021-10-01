package kr.kro.globalpay.home;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kro.globalpay.currency.service.CurrencyService;

@Controller
public class HomeController {

	@Autowired
	private CurrencyService service;

	
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
