package kr.kro.globalpay.card.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kro.globalpay.card.service.CardService;
import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;

@Controller
public class CardController {
	
	@Autowired
	private CardService service;

	/**
	 * 카드 메인 페이지
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/card")
	public String index(HttpSession session, Model model) {
		
		String memberId = (String) session.getAttribute("userId");
		
		if(memberId != null) {
			
			// 1. 로그인한 고객의 카드 정보 불러오기
			CardVO card = service.findById(memberId);
			model.addAttribute("cardVO", card);
			
			// 2. 카드 잔액 랭킹 정보 불러오기
			List<CardBalanceVO> balances = service.cardBalanceById(memberId);
			model.addAttribute("balances", balances);
			System.out.println(balances);
		}
		
		
		
		return "card/index";
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
	public String issue(RegisterVO register, CardVO card, HttpSession session) {
		
		service.issue(register, card, session);
		
		return "redirect:/card";
	}
	
}
