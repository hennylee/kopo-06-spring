package kr.kro.globalpay;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kro.globalpay.member.dao.MemberDAO;
import kr.kro.globalpay.member.service.MemberService;
import kr.kro.globalpay.member.vo.MemberVO;
import kr.kro.globalpay.member.vo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml", "classpath:config/spring/spring-security.xml"}) // locations와 mapper를 다 읽음
public class MemberTest {
	
	@Autowired
	private MemberDAO dao; // 마이바티스 안쓰고 JPA를 사용하게 될 경우 등을 대비하여 인터페이스를 받아야 한다. (묵시적 형변환)
	
	@Autowired
	private MemberService service;
	 
	@Ignore
	@Test
	public void 아이디중복체크Test() throws Exception {
		String id = "hanny";
		int cnt = dao.idCheck("hanny");
		
		System.out.println(cnt);
		
	}
	
//	@Ignore
	@Test
	public void 회원가입Test() throws Exception {
		
		MemberVO vo = new MemberVO();
		vo.setId("test");
		vo.setPassword("test");
		vo.setName("테스트 유저");
		vo.setEmail("test@test.com");
		vo.setPhone("010-2121-0000");
		vo.setAuthority(Role.ROLE_USER);
		vo.setType("홈페이지 회원가입");
		
		int cnt = dao.join(vo);
		
		System.out.println(vo);
		
	}
	
	@Ignore
	@Test
	public void 로그인Test() throws Exception {
		
		String id = "gildong";
		String pw = "gildong1234";

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(pw);
		MemberVO member = dao.login(vo);
		
		System.out.println(member);
		
	}
}
