package kr.kro.globalpay.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kro.globalpay.member.service.MemberService;
import kr.kro.globalpay.member.vo.MemberVO;

//@Controller
public class MemberController2 {

//	@Autowired
	private MemberService service;
	
	
	
	
	
	
	
	/*
	@GetMapping("/login")
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(MemberVO member, Model model, HttpSession session) {
		
		MemberVO userVO = service.login(member);
		
		// 로그인 실패
		if(userVO == null) {
			String msg = "아이디 또는 패스워드가 잘못되었습니다.";
			model.addAttribute("msg", msg);
			return "login/login";
		}
		
		// 로그인 성공 => 세션에 등록
		/*
		 * 세션 객체 얻어오는 방법
		 * 1) HttpServletRequest request를 통해 얻어오기
		 * HttpSession session = request.getSession();
		 * 
		 * 2) 곧바로 HttpSession 객체를 받아오기
		 * 
		 */
	
	/*
		session.setAttribute("userVO", userVO);
		
		return "redirect:/";
	}
	*/
	
	
	/*
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	*/
}
