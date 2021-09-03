package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.MemberVO;

//@Repository // dao에 붙이는 어노테이션
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/*
	public MemberVO login(MemberVO member) {
		
		MemberVO userVO = sqlSessionTemplate.selectOne("member.MemberDAO.login", member);
		
		return userVO;
	}
	*/

	public int register(MemberVO member) {
		
		int result = sqlSessionTemplate.insert("member.MemberDAO.register" , member); // 실행된 결과 반환
		
		return result;
	}

}
