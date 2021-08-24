package kr.ac.kopo;

import kr.ac.kopo.board.BoardDAO;

public class MybatisMain {
	
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		dao.work();
	}
}
