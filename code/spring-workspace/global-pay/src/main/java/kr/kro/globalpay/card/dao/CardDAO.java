package kr.kro.globalpay.card.dao;

import org.springframework.stereotype.Repository;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;

@Repository
public interface CardDAO {
	/**
	 * 카드 데이터 입력
	 */
	int insertCard(CardVO card);
	
	
	/**
	 * 카드 신청 내역 데이터 입력
	 */
	int insertRegister(RegisterVO register);
	
	/**
	 * 카드 번호 중복 체크
	 */
	int cardNoCheck(String cardNO);
	
	/**
	 * ID로 카드 정보 찾기
	 */
	CardVO findById(String memberId);
	
}
