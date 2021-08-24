package kr.ac.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.mlec.form.MemberVO;

@Controller
@RequestMapping("/ajax")
public class ResBodyController {

	// 문자열 전송	
	@RequestMapping("/resBody.do")
	@ResponseBody // forward 시키지 않고 바로 문자열 응답시키는 방법
	public String resStringBody() {
		return "OK, 성공"; // 한글 text 인코딩은 spring-mvc.xml에서 처리함
	}
	
	
	// json 전송
	@RequestMapping("/resBody.json") // web.xml에서 url매핑에 .json도 추가해야 한다.
	@ResponseBody
	public Map<String, String> resJsonBody(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		return result; // json 데이터 인코딩은 spring-mvc.xml에서 처리함
		
	}
	
	// json VO 전송
	@RequestMapping("/resVOBody.json")
	@ResponseBody
	public MemberVO resJsonVOBody() {
		
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPw("1234"); // spring-mvc.xml에 등록해둔 jakson2 메시지 컨버터가 알아서 바꿔준다.
		
		return vo;
	}
	
	// List 전송
	@RequestMapping("/resStringListBody.json")
	@ResponseBody
	public List<String> resJsonStringListBody(){
		List<String> list = new ArrayList<String>();
		
		for(int i = 1; i <= 4; i++) {
			list.add(String.valueOf(i));
		}
		
		return list;
	}

	// List VO 전송
	@RequestMapping("/resVOListBody.json")
	@ResponseBody
	public List<MemberVO> resJsonVOListBody(){
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i = 1; i <= 4; i++) {
			
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setName("홍길동");
			vo.setPw("1234"); // spring-mvc.xml에 등록해둔 jakson2 메시지 컨버터가 알아서 바꿔준다.
			
			list.add(vo);
		}
		
		return list;
	}

}
