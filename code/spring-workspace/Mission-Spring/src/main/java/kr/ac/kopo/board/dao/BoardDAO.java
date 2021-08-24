package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	
	/**
	 * 전체 게시글 조회
	 * @return DB에서 반환된 BoardVO List가 반환됨
	 */
	List<BoardVO> searchAll();
	
	/**
	 * 상세 게시글 조회
	 * @return DB에서 조회된 BoardVO가 반환됨
	 */
	BoardVO searchByNo(int no);
}
