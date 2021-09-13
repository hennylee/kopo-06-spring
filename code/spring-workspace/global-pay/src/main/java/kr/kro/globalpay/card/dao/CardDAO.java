package kr.kro.globalpay.card.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;

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
	
	/**
	 * 카드 잔액 0원으로 초기화
	 */
	void insertZeroBalance(String cardNo);

	/**
	 * 사용자별 외화 잔액(+ 순위) 조회  
	 * @param id
	 * @return
	 */
	List<CardBalanceVO> cardBalanceById(String id);
	
	/**
	 * 사용자의 특정 외화 조회
	 */
	int findOneBalance(ChargeHistoryVO charge);
	
	
}
