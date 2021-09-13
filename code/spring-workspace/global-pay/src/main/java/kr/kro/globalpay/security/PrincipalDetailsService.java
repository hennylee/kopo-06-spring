package kr.kro.globalpay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kro.globalpay.member.dao.MemberDAO;
import kr.kro.globalpay.member.vo.MemberVO;


/*
 *  login 요청이 오면 자동으로 UserDetailService 타입으로 IoC 되어있는 loadUserByUsername이 호출됨
 */

@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	
	// 시큐리티 세션 내부에 => Authentication / Authentication 내부에 => UserDetails
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("loadUserByUsername 실행 중....");
		MemberVO vo = new MemberVO();
		vo.setId(username);
		
		MemberVO member = dao.login(vo); // db에서 사용자 정보 select
		
		System.out.println(member);
		
		if(member != null) {
			return new PrincipalDetails(member);
		}
		
		System.out.println("--------------------------------------------------");
		
		return null;
	}

}
