package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

//@Service
public class MemberServiceImpl implements MemberService {

//	@Autowired
	private MemberDAO memberDAO; // 마이바티스 안쓰고 JPA를 사용하게 될 경우 등을 대비하여 인터페이스를 받아야 한다. (묵시적 형변환)
	
	/*
	public MemberVO login(MemberVO member) {
		
		MemberVO userVO = memberDAO.login(member);
		return userVO;
		
	}
	*/

	public int register(MemberVO member) {
		int result = memberDAO.register(member);
		return result;
	}

}
