package kr.kro.globalpay.card.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import kr.kro.globalpay.card.service.CardService;
import kr.kro.globalpay.card.vo.CardVO;

@RestController
public class CardRestController {
	
	@Autowired
	private CardService service;

	/**
	 * 현재 수익률 구하기
	 */
	@PostMapping("card/profit")
	public Map<String, Double> getProfitRate(@RequestParam("currencyEn") String currencyEn, Authentication authentication) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String id = userDetails.getUsername();
		
		
		CardVO card = new CardVO();
		if(id != null) {
			card = service.findById(id);
		}
		
		System.out.println(card);
		
		Map<String, Double> map = service.selectProfitRate(card.getCardNo(), currencyEn);
		
		
		return map;
	}
	
}
