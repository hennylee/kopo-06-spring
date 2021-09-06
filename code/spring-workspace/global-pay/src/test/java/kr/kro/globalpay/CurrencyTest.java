package kr.kro.globalpay;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kro.globalpay.board.vo.BoardVO;
import kr.kro.globalpay.currency.dao.CurrencyDAO;
import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"}) // locations와 mapper를 다 읽음
public class CurrencyTest {
	
	@Autowired
	private CurrencyDAO dao;
	
	@Autowired
	private CurrencyService service;
	
	@Ignore
	@Test
	public void 전체국가코드조회Test() throws Exception {
//		List<BoardVO> list = boardDAO.searchAll();
		List<NationCodeVO> list = service.nationAll();
		
		for(NationCodeVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void 국가별환율조회Test() throws Exception {
//		List<BoardVO> list = boardDAO.searchAll();
		String nation = "USD";
		List<ExchangeRateVO> list = service.findCurrencyByNation(nation);
		
		for(ExchangeRateVO vo : list) {
			System.out.println(vo);
		}
	}

}
