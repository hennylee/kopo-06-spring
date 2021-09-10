package kr.kro.globalpay.currency.service;

import java.util.List;

import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;
import kr.kro.globalpay.currency.vo.OpenbankAccountVO;

public interface CurrencyService {
	
	/**
	 *  환율 국가 리스트
	 * @return
	 */
	List<NationCodeVO> nationAll();	
	
	/**
	 *  선택한 국가의 환율 조회
	 * @param nationEn
	 * @return
	 */
	List<ExchangeRateVO> findCurrencyByNation(String nationEn);
	
	/**
	 *  로그인한 id로 연결한 계좌 전체 조회
	 * @param id
	 * @return
	 */
	List<OpenbankAccountVO> findAccountsByID(String id);
	
	/**
	 * 환전 처리
	 */
	void changeMoney(OpenbankAccountVO account, CardBalanceVO card, ChargeHistoryVO charge);
	
}
