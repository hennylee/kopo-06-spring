package kr.kro.globalpay.currency;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.kro.globalpay.Configure;
import kr.kro.globalpay.card.dao.CardDAO;
import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.currency.dao.CurrencyDAO;
import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;
import kr.kro.globalpay.currency.vo.OpenbankAccountVO;

public class CurrencyDAOTest extends Configure{
	
	@Autowired
	private CurrencyDAO dao;
	
	@Autowired
	private CardDAO cardDao;
	
	
	
	@Autowired
	private CurrencyService service;
	
	@Ignore
	@Test
	public void 전체국가코드조회Test() throws Exception {
		List<NationCodeVO> list = service.nationAll();
		
		for(NationCodeVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Ignore
	@Test
	public void 국가별환율조회Test() throws Exception {
		String nation = "USD";
		List<ExchangeRateVO> list = dao.findCurrencyByNation(nation);
		
		for(ExchangeRateVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Ignore
	@Test
	public void 오픈뱅킹_잔액변경_테스트() throws Exception {
		OpenbankAccountVO account = new OpenbankAccountVO();
		account.setBalance(50);
		account.setAccountBank("카카오");
		account.setAccountNum("12121-12-1211212");
		
		dao.updateAccountBalance(account);
	}
	
	@Ignore
	@Test
	public void 카드_잔액변경_테스트() throws Exception {
		
		CardBalanceVO card = new CardBalanceVO();
		card.setBalance(50);
		card.setCardNo("1235");
		card.setCurrencyCode("USD");
		
		dao.updateCardBalance(card);
	}
	
	@Ignore
	@Test
	public void 카드_외화별_잔액조회() throws Exception {
		
		// chargeHistoryVO
		ChargeHistoryVO charge = new ChargeHistoryVO();
		charge.setCardNo("1235");
		charge.setCurrencyCode("USD");
		
		int d = cardDao.findOneBalance(charge);
		System.out.println(d);
	}

}
