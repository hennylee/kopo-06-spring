package kr.kro.globalpay.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kro.globalpay.board.vo.BoardVO;

//@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardVO> searchAll() {
		List<BoardVO> list = sqlSessionTemplate.selectList("board.BoardDAO.selectAll");
		return list;
	}

	public BoardVO searchByNo(int no) {
		BoardVO vo = sqlSessionTemplate.selectOne("board.BoardDAO.selectByNo", no);
		return vo;
	}

	public void insert(BoardVO board) {
		sqlSessionTemplate.insert("board.BoardDAO.insert", board);
	}
	

}
