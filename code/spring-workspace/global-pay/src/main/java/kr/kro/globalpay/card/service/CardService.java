package kr.kro.globalpay.card.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;

public interface CardService {
	
	/**
	 * 카드 발급하기
	 * @param register
	 * @param card
	 * @param session
	 */
	void issue(RegisterVO register, CardVO card, HttpSession session);
	
	/**
	 * ID로 카드 정보 찾기
	 */
	CardVO findById(String memberId);
	

	/**
	 * 카드 잔액 랭킹 출력
	 */
	List<CardBalanceVO> cardBalanceById(String id);
}
