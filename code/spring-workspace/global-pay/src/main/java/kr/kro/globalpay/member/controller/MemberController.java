package kr.kro.globalpay.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.kro.globalpay.member.service.MemberService;
import kr.kro.globalpay.member.vo.MemberVO;
import kr.kro.globalpay.member.vo.Role;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	 
	/**
	 * 회원가입 폼
	 * @return
	 */
	@GetMapping("/join")
	public String join(Model model) {
		MemberVO vo = new MemberVO();
		
		model.addAttribute("memberVO", vo);
		
		return "member/join";
	}
	
	/**
	 * 회원가입 진행
	 * @param member
	 * @param error
	 * @return
	 */
	@PostMapping("/join")
	public String register(@Valid MemberVO member, Errors error) {

		if(error.hasErrors()) {
			return "member/join";
		}
		
		String rawPW = member.getPassword();
		String password = pwEncoder.encode(rawPW);
		
		member.setPassword(password);
		member.setAuthority(Role.ROLE_USER);
		member.setType("홈페이지 회원가입");
		
		service.join(member);
		
		return "redirect:/";
	}

	/**
	 * 로그인 폼
	 * @return
	 */
	@GetMapping("/login")
	public String loginForm() {
		return "member/login";
	}
	
	/**
	 * 로그인 처리
	 * @param member
	 * @param model
	 * @param session
	 * @return
	 */
	
	@PostMapping("/login")
	public String login(MemberVO member, Model model, HttpSession session) {
		

		// userVO : db 정보
		// member : 입력 정보
		
		MemberVO userVO = service.login(member);
		boolean isWritePw = false;
		
		String testRaw = "test";
		String encoded = pwEncoder.encode(testRaw);
		
		if(userVO != null) {
			isWritePw = pwEncoder.matches(member.getPassword(), userVO.getPassword());
		}
		
		// 로그인 실패
		if(!isWritePw) {
			String msg = "아이디 또는 패스워드가 잘못되었습니다.";
			model.addAttribute("msg", msg);
			
			return "member/login";
		}
		// 로그인 성공
		session.setAttribute("userId", userVO.getId()); // model에 등록하면 기본 영역인 request 공유영역에 등록됨
		session.setAttribute("userName", userVO.getName()); // model에 등록하면 기본 영역인 request 공유영역에 등록됨
		
		
		return "redirect:/";
	}
	
	
}

