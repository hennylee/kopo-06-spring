package kr.kro.globalpay.currency.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kro.globalpay.card.dao.CardDAO;
import kr.kro.globalpay.currency.dao.CurrencyDAO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;
import kr.kro.globalpay.currency.vo.OpenbankAccountVO;
import kr.kro.globalpay.currency.vo.RefundHistoryVO;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDAO dao;
	
	@Autowired
	private CardDAO cardDao;
	
	@Override
	public List<NationCodeVO> nationAll() {
		List<NationCodeVO> nationList = dao.nationAll();
		return nationList;
	}

	@Override
	public List<ExchangeRateVO> findCurrencyByNation(String currencyEn) {
		List<ExchangeRateVO>  list = dao.findCurrencyByNation(currencyEn);
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
		
		// 7. 결과 데이터 & 페이지 로딩 => commit 이후 시행되어야 하므로 controller에서 별도 시행
		// int balance = cardDao.findOneBalance(charge);
				
	}


	@Override
	public ExchangeRateVO selectCurRate(String currencyEn) {
		ExchangeRateVO vo = dao.selectCurRate(currencyEn);
		return vo;
	}

	@Override
	public void changeMoney(OpenbankAccountVO account, CardBalanceVO card, RefundHistoryVO refund) {
		// 4. 계좌에서 해당 금액 출금시키기 => UPDATE ?? 아직 미정
		dao.updateAccountBalance(account);
		
		// 5. 거래 기록에 입력하기 => INSERT
		dao.insertRefund(refund);
		
		// 6. 카드 외화 잔액 변동시키기 => UPDATE
		dao.updateCardBalance(card);
		
		// 7. 결과 데이터 & 페이지 로딩 => commit 이후 시행되어야 하므로 controller에서 별도 시행
		// int balance = cardDao.findOneBalance(charge);
	}

	@Override
	public List<ExchangeRateVO> selectAllCurRate() {
		List<ExchangeRateVO> list = dao.selectAllCurRate();
		return list;
	}


}
