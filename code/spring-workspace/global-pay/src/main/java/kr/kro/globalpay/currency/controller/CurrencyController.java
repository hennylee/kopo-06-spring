package kr.kro.globalpay.currency.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;

@Controller
public class CurrencyController {
	
	@Autowired
	private CurrencyService service;
	
	/**
	 *  currency 메인 화면
	 * @return
	 */
	@RequestMapping("/currency")
	public String dashboard() {
		
		return "currency/index";
	}
	
	/**
	 * 외화 충전 1단계
	 * @return
	 */
	@GetMapping("/charge")
	public ModelAndView selectNation() {
		
		// 국가 리스트 불러오기
		List<NationCodeVO> nationList = service.nationAll();
		
		ModelAndView mav = new ModelAndView("currency/charge");
		mav.addObject("nationList", nationList);
		
		return mav;
	}
	
	
	/**
	 * currency 충전 2단계 페이지 로딩
	 * @param nation
	 * @return
	 */
	
	@PostMapping("/charge2")
	public ModelAndView selectAmount(@RequestParam("nationEn") String nationEn) {
		
		
		// 현재 환율 띄우기
		List<ExchangeRateVO> list = service.findCurrencyByNation(nationEn);
		ModelAndView mav = new ModelAndView("currency/charge2");
		
		String json = new Gson().toJson(list);
		mav.addObject("json", json);
		
		return mav;
	}
	
	
	
	
	/**
	 * 외화 충전 2단계 처리 + 3단계 페이지 로딩
	 */
	@PostMapping("/charge3")
	public void changeMoney() {
		
		// 1. 입력받은 금액 받기
		
		
		// 2. 선택한 연결 계좌 받기
		
		
		// 3. 계좌에서 해당 금액 출금시키기
		
		
		// 4. 거래 기록에 입력하기
		
		
		// 5. 카드 외화 잔액 변동시키기
		
	}
	
}
