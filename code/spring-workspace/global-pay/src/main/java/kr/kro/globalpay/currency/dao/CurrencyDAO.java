package kr.kro.globalpay.currency.dao;

import java.util.List;

import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;

public interface CurrencyDAO {
	// 환율 국가 리스트
	List<NationCodeVO> nationAll();
	
	// 선택한 국가의 환율 조회
	List<ExchangeRateVO> findCurrencyByNation(String nation);
}
