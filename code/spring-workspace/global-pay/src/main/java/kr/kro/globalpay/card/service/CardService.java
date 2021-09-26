package kr.kro.globalpay.card.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.currency.vo.RefundHistoryVO;

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
	 * #{cardNo},  #{currencyEn}
	 */
	int findOneBalance(String cardNo, String currencyEn);
	
	/**
	 * 외화별 수익률 구하기
	 */
	Map<String, Double> selectProfitRate(String cardNo, String currencyEn);

	/**
	 * 카드 거래 내역 조회
	 */
	HashMap<String, Object> selectAllTransaction(String cardNo);
	
	
	
}
