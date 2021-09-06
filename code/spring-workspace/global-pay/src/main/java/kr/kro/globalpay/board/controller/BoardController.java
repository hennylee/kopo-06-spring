package kr.kro.globalpay.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.kro.globalpay.board.service.BoardService;
import kr.kro.globalpay.board.vo.BoardVO;
import kr.kro.globalpay.member.vo.MemberVO;

//@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/board")
	public ModelAndView selectAll() {
		List<BoardVO> list = service.selectAllBoard();
		
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", list);
		
		return mav;
	}
	
	
	
	@RequestMapping("/board/detail")
	public void selectByNo(@RequestParam("no") int no) {
		
		System.out.println(no);
		System.out.println("상세 게시글 조회...");
	}
	/*
	@RequestMapping("/board/detail")
	public void selectByNo(HttpServletRequest request) {
		int no = Integer.parseInt(request.getParameter("no")); // 넘겨준 글번호 알아오기 => request객체 얻어오는 방법 
	}
	*/
	
	
	
	@RequestMapping("/board/{no}")
	public ModelAndView selectByNo2(@PathVariable("no") int no) {
		
		BoardVO vo = service.selectByNo(no);

		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", vo);
		
		return mav;
	}

	
	//@RequestMapping(method = RequestMethod.GET , value = "/board/write") // value 대신 path를 써도 된다.
	/* 기존의 방식
	@GetMapping("/board/write")
	public String writeForm() {
		return "board/write";
	}
	*/
	@GetMapping("/board/write")
	public String writeForm(Model model, HttpSession session) {
		BoardVO board = new BoardVO();
		MemberVO member = (MemberVO)session.getAttribute("userVO");
		board.setWriter(member.getId());
		
		model.addAttribute("boardVO", board); // 공유 영역에 객체를 등록
		return "board/write";
	}
	
	
	//@RequestMapping(value = "board/write", method = RequestMethod.POST )
	/* 기존의 방식
	@PostMapping("/board/write") // 4.3버전부터 새로 생긴 어노테이션으로 대체 가능하다.
	public String write(BoardVO board, Model model) { // 스프링에서는 parameter받을 때, vo로 받으면 자동으로 매칭된다.
		
		System.out.println(board);
		System.out.println("post board/write");
		
		return "redirect:/board";
	}
	*/
	@PostMapping("/board/write") 
	public String write(@Valid BoardVO board, Errors error) { // Errors를 상속받은 BindingResult를 사용해도 된다. 
		
		
		if(error.hasErrors()) {
			System.out.println("오류 발생");
			return "board/write";
		}
		
		service.insert(board);
		
		return "redirect:/board";
	}
	

}
