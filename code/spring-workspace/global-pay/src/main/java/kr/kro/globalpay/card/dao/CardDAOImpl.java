package kr.kro.globalpay.card.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;

@Repository
public class CardDAOImpl implements CardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertCard(CardVO card) {
		int result = sqlSessionTemplate.insert("card.CardDAO.insertCard", card);
		return result;
	}

	@Override
	public int insertRegister(RegisterVO register) {
		int result = sqlSessionTemplate.insert("card.CardDAO.insertRegister", register);
		return result;
	}

	@Override
	public int cardNoCheck(String cardNo) {
		int cnt = sqlSessionTemplate.selectOne("card.CardDAO.cardNoCheck", cardNo);
		return cnt;
	}

	@Override
	public CardVO findById(String memberId) {
		CardVO card = sqlSessionTemplate.selectOne("card.CardDAO.findById", memberId);
		return card;
	}

	@Override
	public void insertZeroBalance(String cardNo) {
		sqlSessionTemplate.insert("card.CardDAO.insertZeroBalance", cardNo);
	}

	@Override
	public List<CardBalanceVO> cardBalanceById(String id) {
		 List<CardBalanceVO> list = sqlSessionTemplate.selectList("card.CardDAO.cardBalanceById", id);
		return list;
	}

	@Override
	public int findOneBalance(ChargeHistoryVO charge) {
		
		System.out.println(charge.getCardNo());
		System.out.println(charge.getCurrencyCode());
		
		int balance = sqlSessionTemplate.selectOne("card.CardDAO.findOneBalance", charge);
		
		return balance;
	}

}
