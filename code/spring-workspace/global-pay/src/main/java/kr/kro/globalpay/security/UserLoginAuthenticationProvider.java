package kr.kro.globalpay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kro.globalpay.member.dao.MemberDAO;
import kr.kro.globalpay.member.vo.MemberVO;

@Service
public class UserLoginAuthenticationProvider implements AuthenticationProvider  {
	
	@Autowired
	// DB의 값을 가져다주는 커스터마이징 클래스
	PrincipalDetailsService principalDetailsService;
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	
	// 실제 인증을 구현하는 로직 
	/*
	 * 파라미터로 받은 Authentication에는 사용자가 입력한 ID/패스워드 정보가 담겨 있음
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String id = authentication.getName();
		String pw = (String) authentication.getCredentials();
		System.out.println("authenticate 실행중....");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		/* DB에서 가져온 정보 */
		UserDetails userDetails = (UserDetails) principalDetailsService.loadUserByUsername(id);
		
		
		/* 인증 진행 */
		if (userDetails == null || !id.equals(userDetails.getUsername()) || !pwEncoder.matches(pw, userDetails.getPassword())) {
			System.out.println("로그인 실패!!!!!!!!!!!!!!!!!");
			System.out.println("userDetails : " + userDetails);
			System.out.println(userDetails.getUsername());
			System.out.println(pwEncoder.matches(pw, userDetails.getPassword()));
			
			throw new BadCredentialsException(id);
		} 
		


		/* 최종 리턴 시킬 새로만든 Authentication 객체 */
		Authentication newAuth = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		
		System.out.println("newAuth : " + newAuth);

		return newAuth;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// 스프링 Security가 요구하는 UsernamePasswordAuthenticationToken 타입이 맞는지 확인
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
