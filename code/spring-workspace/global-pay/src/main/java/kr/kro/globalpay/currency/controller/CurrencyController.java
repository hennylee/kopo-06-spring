package kr.kro.globalpay.currency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.NationCodeVO;

@Controller
public class CurrencyController {
	
	@Autowired
	private CurrencyService service;
	
	// currency 메인 화면
	@RequestMapping("/currency")
	public String dashboard() {
		
		return "currency/index";
	}
	
	// currency 충전 1단계
	@RequestMapping("/charge")
	public ModelAndView selectNation() {
		
		// 국가 리스트 불러오기
		List<NationCodeVO> nationList = service.nationAll();
		
		ModelAndView mav = new ModelAndView("currency/charge/charge_1");
		mav.addObject("nationList", nationList);
		
		return mav;
	}
	
	@PostMapping("/charge2")
	public String selectAmount(@RequestParam("nation") String nation) {
		
		// 무슨 화폐 선택했는지 확인하기 => @RequestParam("nation")
		
		// 현재 환율 띄우기
		service.findCurrencyByNation(nation);
		
		// 환율 계산하기?
		
		
		
		
		return "currency/charge/charge_2";
	}
	
	
}
