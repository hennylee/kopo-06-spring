package kr.kro.globalpay.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kro.globalpay.member.service.MemberService;
import kr.kro.globalpay.member.vo.MemberVO;
import kr.kro.globalpay.security.Role;

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
		member.setAuthority(Role.USER.getKey());
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
	
	
}

