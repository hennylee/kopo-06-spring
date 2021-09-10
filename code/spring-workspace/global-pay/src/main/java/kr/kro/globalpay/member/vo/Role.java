package kr.kro.globalpay.member.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor
public enum Role {
	ROLE_USER("USER", "일반회원"), 
	ROLE_AMDIN("AMDIN", "관리자"),
	ROLE_MANAGER("MANAGER", "매니저"),
	ROLE_SELLER("SELLER", "판매자");

	private final String key;
	private final String title;
	
}
