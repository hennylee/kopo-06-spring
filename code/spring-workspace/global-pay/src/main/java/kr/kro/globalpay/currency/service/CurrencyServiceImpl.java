package kr.kro.globalpay.currency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kro.globalpay.currency.dao.CurrencyDAO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;

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

}
