package kr.kro.globalpay;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kro.globalpay.board.vo.BoardVO;
import kr.kro.globalpay.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class) // spring기반의 junit 클래스를 이용해서 test 
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"}) // => spring기반이면 container에서 값을 가져와야 함 => spring-mvc.xml을 읽어와야함
public class MybatisTest {

	@Autowired // 주입
	private DataSource datasource;
	
	@Autowired
	private SqlSessionFactory sqlFactory;

	@Autowired // 스프링컨테이너에서 자동주입 받기
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Ignore // 테스트를 진행하지 않고 싶을때 사용하는 어노테이션
	@Test // 특정 메소드만 테스트를 실행할때 사용하는 어노테이션
	public void DataSource생성테스트() throws Exception {
		// System.out.println("datasource : " + datasource);
		assertNotNull(datasource); // datasource값이 null이 아니면 성공으로 판단 (값을 알 필요가 없을때 유용)
	}
	
	@Ignore
	@Test
	public void mybatis연동테스트() throws Exception {
//		assertNotNull(sqlFactory);
		assertNotNull(sqlSessionTemplate);
	}
	
	// 전체게시글 조회
	@Ignore
	@Test
	public void 전체게시글조회Test() throws Exception{
		List<BoardVO> list = sqlSessionTemplate.selectList("board.BoardDAO.selectAll");
		
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	// 상세 게시글 조회
	@Ignore
	@Test
	public void 상세게시글조회Test() throws Exception {
		BoardVO board = sqlSessionTemplate.selectOne("board.BoardDAO.selectByNo", 2);
		System.out.println(board);
	}
	
	// 로그인
	@Ignore
	@Test
	public void 로그인테스트() throws Exception {
		
		MemberVO member = new MemberVO();
		member.setId("test");
		member.setPassword("1111");
		
		MemberVO userVO = sqlSessionTemplate.selectOne("member.MemberDAO.login" , member);
		 
		assertNotNull(userVO);
		System.out.println("userVO : " + userVO);
		
	}
	
	// 새글 등록 테스트
	@Ignore
	@Test
	public void 새글등록Test() throws Exception {
		
		BoardVO board = new BoardVO();
		board.setTitle("제목test..");
		board.setContent("내용test..");
		board.setWriter("test");
		
		sqlSessionTemplate.insert("board.BoardDAO.insert" ,board);
	}
}
