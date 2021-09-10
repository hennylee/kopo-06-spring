package kr.kro.globalpay.currency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kro.globalpay.currency.dao.CurrencyDAO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;
import kr.kro.globalpay.currency.vo.OpenbankAccountVO;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDAO dao;
	
	@Override
	public List<NationCodeVO> nationAll() {
		List<NationCodeVO> nationList = dao.nationAll();
		return nationList;
	}

	@Override
	public List<ExchangeRateVO> findCurrencyByNation(String nationEn) {
		List<ExchangeRateVO>  list = dao.findCurrencyByNation(nationEn);
		return list;
	}

	@Override
	public List<OpenbankAccountVO> findAccountsByID(String id) {
		List<OpenbankAccountVO> list = dao.findAccountsByID(id);
		return list;
	}

	@Override
	@Transactional
	public void changeMoney(OpenbankAccountVO account, CardBalanceVO card, ChargeHistoryVO charge) {

		// 4. 계좌에서 해당 금액 출금시키기 => UPDATE ?? 아직 미정
		dao.updateAccountBalance(account);
		
		// 5. 거래 기록에 입력하기 => INSERT
		dao.insertCharge(charge);
		
		// 6. 카드 외화 잔액 변동시키기 => UPDATE
		dao.updateCardBalance(card);
		
		// 7. 결과 데이터 & 페이지 로딩
		
				
	}


}
