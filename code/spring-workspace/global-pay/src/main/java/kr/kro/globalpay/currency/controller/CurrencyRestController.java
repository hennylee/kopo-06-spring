package kr.kro.globalpay.currency.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.CallbackVO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;

@RestController
public class CurrencyRestController {

	@Autowired
	private CurrencyService service;
	
	/**
	 * currency 충전 2단계
	 * @param nation
	 * @return
	 */
	
	@PostMapping("/charge")
	public List<ExchangeRateVO> selectAmount(@RequestParam("nationEn") String nationEn) {
		
		// 현재 환율 띄우기
		List<ExchangeRateVO> list = service.findCurrencyByNation(nationEn);
		
		return list;
	}
	
	 
}