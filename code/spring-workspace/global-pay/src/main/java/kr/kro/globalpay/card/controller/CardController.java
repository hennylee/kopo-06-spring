package kr.kro.globalpay.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kro.globalpay.card.service.CardService;
import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.OpenbankAccountVO;

@Controller
public class CardController {
	
	@Autowired
	private CardService service;
	
	@Autowired
	private CurrencyService curService;
	

	/**
	 * 카드 메인 페이지
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/card")
	public ModelAndView index(Model model, Authentication authentication) {
		
		List<OpenbankAccountVO> accounts = null;
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String memberId = userDetails.getUsername();
		
		ModelAndView mav = new ModelAndView("card/index");
		if(memberId != null) {
			
			// 1. 로그인한 고객의 카드 정보 불러오기
			CardVO card = service.findById(memberId);
			mav.addObject("cardVO", card);
			
			// 2. 카드 잔액 랭킹 정보 불러오기
			List<CardBalanceVO> balances = service.cardBalanceById(memberId);
			mav.addObject("balances", balances);
			
			// 3. 고객의 연결 계좌 불러오기
			accounts = curService.findAccountsByID(memberId);
			
		}
		
		mav.addObject("accounts", accounts);
		
		return mav;
	}
	
	/**
	 * 카드 발급 페이지
	 * @return
	 */
	@GetMapping("/issue")
	public String issueForm() {
		return "card/issue";
	}
	
	/**
	 * 카드 발급 처리
	 * @param register
	 * @param card
	 * @param session
	 * @return
	 */
	@PostMapping("/issue")
	public String issue(RegisterVO register, CardVO card, Authentication authentication) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		String memberId = userDetails.getUsername();
		
		service.issue(register, card, memberId);
		
		return "redirect:/card";
	}
	
}
