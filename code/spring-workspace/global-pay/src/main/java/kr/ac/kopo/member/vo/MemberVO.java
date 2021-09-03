package kr.ac.kopo.member.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class MemberVO {
	
	@Pattern(regexp = "^[a-z0-9]*$", message = "영문 소문자와 숫자만 사용가능합니다.")
	@NotEmpty(message = "id는 필수항목입니다.")
	private String id;

	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영문과 숫자만 사용가능합니다.")
	@NotEmpty(message = "password는 필수항목입니다.")
	private String password;
	
	@NotEmpty(message = "이름은 필수항목입니다.")
	private String name;
	
	@NotEmpty(message = "생년월일은 필수항목입니다.")
	private String birthDate;
	
	@NotEmpty(message = "성별은 필수항목입니다.")
	private char gender;
	
	@Pattern(regexp = "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", message = "유효하지 않은 이메일 형식입니다.")
	@NotEmpty(message = "이메일은 필수항목입니다.")
	private String email;
	
	private String addr1;
	private String addr2;
	
	private String zip;
	
	
	@NotEmpty(message = "전화번호는 필수항목입니다.")
	private String phone;
	
	private String authority;
	
	private String type;
	
	
	private char privacyAgree;
	
	private char openbankAgree;
	
	
	private String regDate;
	
}
