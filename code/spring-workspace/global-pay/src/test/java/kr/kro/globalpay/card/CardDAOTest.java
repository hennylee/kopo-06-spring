package kr.kro.globalpay.card;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kro.globalpay.card.dao.CardDAO;
import kr.kro.globalpay.card.vo.CardVO;
import kr.kro.globalpay.card.vo.RegisterVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml", "classpath:config/spring/spring-security.xml"}) // locations와 mapper를 다 읽음
public class CardDAOTest {

	@Autowired
	private CardDAO dao;
	
	@Ignore
	@Test
	public void 카드번호_중복_테스트() {
		String cardNo = "1235";
		int cnt = dao.cardNoCheck(cardNo);
		
		System.out.println(cnt);
		
	}
	
	@Ignore
	@Test
	public void 카드_등록_테스트() {
		
		// card_no, cvc, family_name, given_name, member_id
		
		CardVO card = new CardVO();
		card.setFamilyName("LEE");
		card.setGivenName("HAENEE");
		card.setCardNo("SAgdsga");
		card.setCvc("agdga");
		card.setMemberId("dagdg");
		int result = dao.insertCard(card);
		
		System.out.println(card);
		
		
	}
	
	@Ignore
	@Test
	public void 카드_신청내역_등록_테스트() {

		// no, zip, addr1, addr2, card_no, APPLICANT_ID
		
		RegisterVO register = new RegisterVO();
		register.setNo(1);
		register.setZip("124314");
		register.setAddr1("경기도라");
		register.setAddr2("고양시옹");
		register.setCardNo("2134");
		register.setApplicantId("hanny");

		int result2 = dao.insertRegister(register);

		System.out.println(register);
		
		
	}
	
}
