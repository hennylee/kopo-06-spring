package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes({"userVO"}) // 디스패처 서블릿이 이 어노테이션을 보면 session객체에 올린다.  
							   // => 다만, HttpSession session.invalidate()를 사용할 수 없게 됨 => SessionStatus를 사용해야 한다.
							   // 1개일때는 ("userVO")라고만 작성해도 됨 
@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
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
		
		// 로그인 성공 => DispatcherServlet한테 시켜서 세션에 등록하기
		model.addAttribute("userVO", userVO); // model에 등록하면 기본 영역인 request 공유영역에 등록됨
		
		// 인터셉터를 거쳤는지 확인하기
		String dest = (String)session.getAttribute("dest");
		
		if(dest != null) {
			session.removeAttribute("dest");
			return "redirect:" + dest;
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		
		System.out.println("로그아웃 전 : " + sessionStatus.isComplete());
		sessionStatus.setComplete();
		System.out.println("로그아웃 후 : " + sessionStatus.isComplete());

		return "redirect:/";
	}
}