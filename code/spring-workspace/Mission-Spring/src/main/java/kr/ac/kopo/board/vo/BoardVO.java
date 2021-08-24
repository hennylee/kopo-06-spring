package kr.ac.kopo.board.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class BoardVO {
	private int no;
	
	@Length(min=2, max=50, message="최소 2글자 이상 최대 40글자만 가능합니다.")
	@NotEmpty(message = "제목은 필수항목입니다.")
	private String title;
	
	@Pattern(regexp = "^[A-Za-z]*$", message = "특수기호는 사용할 수 없습니다.")
	@NotEmpty(message = "작성자는 필수항목입니다.")
	private String writer;
	
	@NotEmpty(message = "내용은 필수항목입니다.")
	private String content;
	
	private int viewCnt;
	private String regDate;
	
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + "]";
	}
	
	
	
	
}
