package kr.kro.globalpay;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kro.globalpay.board.dao.BoardDAO;
import kr.kro.globalpay.board.service.BoardService;
import kr.kro.globalpay.board.vo.BoardVO;

public class BoardTest extends Configure{
	
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BoardService boardService;
	
	// 전체게시글 조회
	@Ignore
	@Test
	public void 전체게시글조회Test() throws Exception {
		List<BoardVO> list = boardService.selectAllBoard();
		
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	// 새글 등록 테스트
	@Ignore
	@Test
	public void 새글등록Test() throws Exception {
		
		BoardVO board = new BoardVO();
		board.setTitle("제목test..");
		board.setContent("내용test..");
		board.setWriter("test");
		
		boardService.insert(board);
	}
	
}
