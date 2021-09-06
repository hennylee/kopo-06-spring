package kr.kro.globalpay.board.service;

import java.util.List;

import kr.kro.globalpay.board.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> selectAllBoard();
	BoardVO selectByNo(int no);
	void insert(BoardVO board);
}
