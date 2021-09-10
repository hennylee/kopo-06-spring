package kr.kro.globalpay.currency.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.currency.vo.NationCodeVO;
import kr.kro.globalpay.currency.vo.OpenbankAccountVO;

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

	@Override
	public List<OpenbankAccountVO> findAccountsByID(String id) {
		List<OpenbankAccountVO> list = sqlSessionTemplate.selectList("currency.CurrencyDAO.selectAccounts", id);
		return list;
	}

	@Override
	public void updateAccountBalance(OpenbankAccountVO account) {
		sqlSessionTemplate.update("currency.CurrencyDAO.updateAccountBalance", account);
	}

	@Override
	public void updateCardBalance(CardBalanceVO card) {
		sqlSessionTemplate.update("currency.CurrencyDAO.updateCardBalance", card);
	}

	@Override
	public void insertCharge(ChargeHistoryVO charge) {
		sqlSessionTemplate.insert("currency.CurrencyDAO.insertCharge", charge);
	}

	
}
