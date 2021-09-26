package kr.kro.globalpay.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import kr.kro.globalpay.member.vo.MemberVO;

public class MyHandler extends TextWebSocketHandler {
	
	private List<WebSocketSession> sessionList = new ArrayList<>();
    private Map<String, MemberVO> usersMap = new HashMap<>();
    private Gson gson = new Gson();
	
	

	// 클라이언트와 커넥션이 연결된 후 수행되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished : "+session);
		System.out.println("접속 id : "+session.getId());
	}

	// 클라이언트가 서버로 메시지를 전송했을 때 실행되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage : "+session+", message : "+message);
		String msg = message.getPayload();
		System.out.println("msg : "  + msg);
		System.out.println("실행");
	}

	// 클라이언트와 연결을 끊었을때 수행되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("handleTextMessage : "+session+", status : "+status);
		System.out.println("afterConnectionClosed");
	}

	
}
