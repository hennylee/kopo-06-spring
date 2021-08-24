package kr.ac.mlec.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class MemberController {
	
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
	}
	
/*
<5. Model 객체를 받아서 공유영역 등록하기> */
	@RequestMapping("/join.do")
	public String join(MemberVO vo, Model model) {
		
		model.addAttribute("vo", vo);
		
		return "form/memberInfo";
	}
	
	
/*
<4. 자바빈즈 단위로 받고 ModelAndView에 등록하기>
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form/memberInfo"); // setViewName 에는 forward 시킬 주소값 대입하기
		mav.addObject("vo", vo);
		
		return mav;
	}
*/
	
/* 
<3. 자바빈즈 단위로 받아서 자동으로 등록시키기>
	@RequestMapping("/join.do")
	public String join(
			@ModelAttribute("member") // 공유영역에 등록될 이름을 사용자 정의값으로 등록하는 방법이다.
			MemberVO vo 			  // id, pw, name으로 전송된 값이 자동으로 MemberVO와 매칭되어 들어온다.
	) { 

//		 	1. 자동으로 매개변수에 들어있는 자바빈즈를 request 공유영역에 등록한다.
//		 	2. 자바빈즈 클래스의 첫글자만 소문자로 변경되어 key값으로 등록되기 때문에 JSP에서 받을때는 memberVO로 받아야 한다.
//		 	3. 만약 @ModelAttribute을 등록했다면 해당 이름이 key로 request 공유영역에 등록된다.
		
		return "/form/memberInfo";
	}
*/
	
	
/*
<2. 단일 파라미터로 받아서 request 영역에 등록하기>

	@RequestMapping("/join.do")
	public String join(
	
			@RequestParam("id") String id
			, @RequestParam("pw") String pw
			, @RequestParam("name") String name
			, HttpServletRequest request 
	) {
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		
		request.setAttribute("vo", vo);
		
		return "/form/memberInfo";
	}
*/
	
	
	
/*
<1. 기존 방식>

	@RequestMapping("/join.do")
	public String join(HttpServletRequest request) {
		
		// web.xml filter에서 이미 처리함
//		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		
		System.out.println(vo);
		
		request.setAttribute("vo", vo);
		
		return "/form/memberInfo";
	}
*/
	
}
