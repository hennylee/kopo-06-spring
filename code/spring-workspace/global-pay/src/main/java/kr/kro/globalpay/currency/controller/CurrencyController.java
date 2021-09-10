package kr.kro.globalpay.currency.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;
import kr.kro.globalpay.currency.vo.OpenbankAccountVO;

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
		
		// 
		
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
	public ModelAndView selectAmount(@RequestParam("nationEn") String nationEn, HttpSession session) {
		
		String id = (String) session.getAttribute("userId");
		
		// 선택한 국가 환율 띄우기
		List<ExchangeRateVO> currecies = service.findCurrencyByNation(nationEn);
		List<OpenbankAccountVO> accounts = null;
		
		// 연결 계좌 리스트
		if(id != null) {
			accounts = service.findAccountsByID(id);
		}
		
		// 페이지와 데이터 반환
		ModelAndView mav = new ModelAndView("currency/charge2");
		String json = new Gson().toJson(currecies); // 환율데이터 json 형식으로 변환
		mav.addObject("json", json);
		mav.addObject("accounts", accounts);
		
		if(accounts != null ) {
			mav.addObject("cardNo", accounts.get(0).getCardNo());
		}
		
		return mav;
	}
	
	
	
	
	/**
	 * 외화 충전 2단계 처리 + 3단계 페이지 로딩
	 */
	@Transactional
	@PostMapping("/charge3")
	public String changeMoney(CardVO card ,CardBalanceVO cardBalance, ChargeHistoryVO charge, @RequestParam("connectedAccount") String open){

		/*
		 		krAmount : wonAmount
				, feAmount : currencyAmount
				, connectedAccount : connectedAccount
				, currencyCode : selectedNameEn
				, exchangeRate : curRate
				, cardNo : cardNo
		 */
		OpenbankAccountVO account = new OpenbankAccountVO();

		String[] temp = open.split("   ");
		String bank = temp[0];
		String num = temp[1];
		
		// 1. 계좌 잔액에 업데이터할 내용
		account.setAccountBank(bank);
		account.setAccountNum(num);
		account.setBalance(charge.getKrAmount());
		
		
		// 2. 카드 잔액에 업데이트할 내용
		cardBalance.setBalance(charge.getFeAmount());
		
		
		// 3. 충전 내역 업데이트할 내용
		charge.setAccountBank(bank);
		charge.setAccountNo(num);
		
		service.changeMoney(account, cardBalance, charge);
		System.out.println("성공?");
		
		// 7. 결과 데이터 & 페이지 로딩
		
		return "currency/charge3";
		
	}
	
}
