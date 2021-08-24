package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service // 스프링 컨테이너에서 라이프 사이클 관리
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = boardDAO.searchAll();
		return list;
	}

	public BoardVO selectByNo(int no) {
		BoardVO vo = boardDAO.searchByNo(no);
		return vo;
	}

}
