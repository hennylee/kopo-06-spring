package kr.kro.globalpay.card.service;

import javax.servlet.http.HttpSession;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;

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
}
