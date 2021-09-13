package kr.kro.globalpay.card.service;

import java.util.List;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;

public interface CardService {
	
	/**
	 * 카드 발급하기
	 * @param register
	 * @param card
	 * @param session
	 */
	void issue(RegisterVO register, CardVO card, String id);
	
	/**
	 * ID로 카드 정보 찾기
	 */
	CardVO findById(String memberId);
	

	/**
	 * 카드 잔액 랭킹 출력
	 */
	List<CardBalanceVO> cardBalanceById(String id);
	
	/**
	 * 사용자의 특정 외화 조회
	 */
	int findOneBalance(ChargeHistoryVO charge);
	
}
