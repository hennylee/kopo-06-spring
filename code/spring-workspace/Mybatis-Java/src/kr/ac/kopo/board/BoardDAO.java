package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;

public class BoardDAO {
	
	private SqlSession session;
	
	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void work() {
//		insert();
//		selectAll();
//		selectOne();
		selectOne2();
//		selectNos();
//		selectWhere();
	}
	
	
	private void selectWhere() {
		
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere", "제목1");
		
		BoardVO vo = new BoardVO();
//		vo.setTitle("제목1");
		vo.setWriter("홍길동");
		
		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere2", vo);
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	private void selectNos() {
		
		/*
		<vo로 넘기는 방식>
		
		BoardVO board = new BoardVO();
		board.setNos(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 22});
		
		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos", board);
		 */
		
		/* < arraylist로 넘기는 방식 > */
		List<Integer> nos = new ArrayList<>();
		nos.add(1);
		nos.add(2);
		nos.add(3);
		nos.add(4);
		nos.add(5);
		
		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos2", nos);
		
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	private void selectOne() {
		BoardVO board = new BoardVO();
		board.setNo(2);
		
		BoardVO result = session.selectOne("board.BoardDAO.selectOne3", board);
		System.out.println("selectOne : " + result);
	}
	private void selectOne2() {
		BoardVO board = new BoardVO();
		board.setNo(2);
		
		Map<String, Object> map = session.selectOne("board.BoardDAO.selectOne4", board);
		
		Set<String> keys = map.keySet();
		
		for(String key : keys) {
//			System.out.println(key );
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	private void selectAll() {
		List<BoardVO> list = session.selectList("board.BoardDAO.selectAll"); // 자동으로 명시적 형변환 되어 있음
	}
	
	private void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("객체로 삽입...");
		board.setWriter("홍길동");
		board.setContent("삽입되었나?");
		
		session.insert("board.BoardDAO.insert", board);
		session.commit();
		
		System.out.println("삽입완료...");
	}
	
}
