package kr.kro.globalpay.card.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;

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

}
