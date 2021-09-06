package kr.kro.globalpay.board.dao;

import java.util.List;

import kr.kro.globalpay.board.vo.BoardVO;

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
	
	/**
	 * 새글 등록
	 * @param board : DB에 등록할 제목, 내용, 글쓴이
	 */
	void insert(BoardVO board);
}
