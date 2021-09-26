package kr.kro.globalpay.card.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.kro.globalpay.card.dao.CardDAO;
import kr.kro.globalpay.card.util.LuhnAlgorithm;
import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;
import kr.kro.globalpay.currency.vo.CardBalanceVO;
import kr.kro.globalpay.currency.vo.ChargeHistoryVO;
import kr.kro.globalpay.util.RandomGenerator;

@Service
public class CardServiceImpl implements CardService {
	
	public final static String SALT = "깃우갹샤";

	@Autowired
	private CardDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@Override
	@Transactional
	public void issue(RegisterVO register, CardVO card, String id) {
		
		
	// 1. 카드 데이터 입력
		int result = -1;
		
		String cardNo = null;
		
		do {
			
			// 1-1. 카드 번호 생성
			String front = "4";
			front += RandomGenerator.numberGen(3, 2);
			
			String middle1 = RandomGenerator.numberGen(4, 1);
			String middle2 = RandomGenerator.numberGen(4, 1);
			
			String last = RandomGenerator.numberGen(3, 2);
			last += LuhnAlgorithm.getLastNum(front+middle1+middle2+last);
			
			cardNo = front + "-" + middle1 + "-" + middle2 + "-" + last;
			
			// 1-2. 카드 번호 중복 체크
			result = dao.cardNoCheck(cardNo);
			
			
		}while(result != 0);
		
		card.setCardNo(cardNo);
		
		// 1-3. CVC/CVC 번호 생성 + 암호화 : 앞 숫자 = 카드 뒤 4자리 + 암호코드 3자리
		// 고객의 카드 정보 페이지에서 cvc코드를 보여줘야 하기 때문에 암호화 처리하지 않음
		String cvc = RandomGenerator.numberGen(3, 1);
		card.setCvc(cvc);
		
		
		// 1-4. 세션 ID 입력
		card.setMemberId(id);
		
		// 1-5. 카드 데이터 입력
		dao.insertCard(card);
		
		
	// 2. 카드 신청 내역 데이터 입력
		// 2-1. 카드 번호 입력
		register.setCardNo(cardNo);
		
		// 2-2. 회원 ID 입력
		register.setApplicantId(id);
		
		dao.insertRegister(register);
		
	// 3. 카드 잔액 초기화
		dao.insertZeroBalance(cardNo);
		
	}

	@Override
	public CardVO findById(String memberId) {
		CardVO card = dao.findById(memberId);
		return card;
	}
	

	@Override
	public List<CardBalanceVO> cardBalanceById(String id) {
		List<CardBalanceVO> list = dao.cardBalanceById(id);
		return list;
	}

	@Override
	public int findOneBalance(String cardNo, String currencyEn) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cardNo", cardNo);
		map.put("currencyEn", currencyEn);
		
		int balance = dao.findOneBalance(map);
		
		return balance;
	}

	@Override
	@Transactional
	public Map<String, Double> selectProfitRate(String cardNo, String currencyEn) {
		
		// 1. 개별 수익률 구하기
		// 1) 1주당 평균가격
		double buyAvgPrice = dao.getBuyAvgPrice(currencyEn);
		System.out.println("1주당 평균가격 구하기 성공");
		
		// 2) 1주당 현재 팔때 가격
		double curSellPrice = dao.getCurSellPrice(currencyEn);
		System.out.println("1주당 현재 팔때 가격 구하기 성공");
		
		// 3) 1주당 손익, 손익률
		double profitLoss = curSellPrice - buyAvgPrice;
		double profitLossRate = Math.round(profitLoss / buyAvgPrice * 100);
		System.out.println("1주당 손익, 손익률 구하기 성공");
		
		// 4) 총 보유 외화 
		Map<String, String> map = new HashMap<String, String>();
		map.put("cardNo", cardNo);
		map.put("currencyEn", currencyEn);
		double total = dao.findOneBalance(map);
		System.out.println("총 보유 외화 구하기 성공");
		
		// 5) 총 손익
		double totalPL = profitLoss * total;
		System.out.println("총 손익 구하기 성공");
		
		Map<String, Double> result = new HashMap<String, Double>();
		result.put("buyAvgPrice", buyAvgPrice);
		result.put("curSellPrice", curSellPrice);
		result.put("profitLoss", profitLoss);
		result.put("profitLossRate", profitLossRate);
		result.put("total", total);
		result.put("totalPL", totalPL);
		
		System.out.println(map);
		return result;
	}
	

	/**
	 * 카드 거래내역 조회
	 * @param cardNo
	 * @return
	 */
	@Override
	public HashMap<String, Object> selectAllTransaction(String cardNo) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		// 1. 충전 내역 불러오기
		List<ChargeHistoryVO> charge = dao.selectAllHistory(cardNo);
		
		// 2. 환불 내역 불러오기
		
		
		// 3. 결제 내역 불러오기
		
		// map에 담기
		map.put("charge", charge);
		
		return map;
	}
	


}
