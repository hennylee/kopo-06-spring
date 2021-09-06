package kr.kro.globalpay.currency.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<NationCodeVO> nationAll() {
		List<NationCodeVO> nationList = sqlSessionTemplate.selectList("currency.CurrencyDAO.nationAll");
		return nationList;
	}

	@Override
	public List<ExchangeRateVO> findCurrencyByNation(String nation) {
		List<ExchangeRateVO> list = sqlSessionTemplate.selectList("currency.CurrencyDAO.selectByNation", nation);
		return list;
	}

}
