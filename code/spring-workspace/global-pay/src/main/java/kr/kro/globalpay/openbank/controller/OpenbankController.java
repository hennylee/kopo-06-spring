package kr.kro.globalpay.openbank.controller;

import java.net.http.HttpRequest;
import java.util.HashMap;

import javax.servlet.http.HttpUtils;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.kro.globalpay.currency.vo.CallbackVO;

@Controller
public class OpenbankController {

	@GetMapping("/openbank")
	public String openbank() {
		
		return "/openbank/index";
	}
	

	@GetMapping("/register")
	public String register() {
		
		return "/openbank/register";
	}
	
	/*
	HashMap<String, String> authHeaders = new HashMap<>();
    authHeaders.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");

    HashMap<String, Object> authParams = new HashMap<>();
    authParams.put("code", reqParams.get("code"));
    authParams.put("client_id", clientId);
    authParams.put("client_secret", clientSecret);
    authParams.put("grant_type", "authorization_code");
    authParams.put("redirect_uri", redirectUri);


    JSONObject authRes = HttpUtils.httpPost("https://testapi.openbanking.or.kr/oauth/2.0/token", authHeaders, authParams);
    String accessToken = (String) authRes.get("access_token");
    String refreshToken = (String) authRes.get("refresh_token");
    String userSeqNo = (String) authRes.get("user_seq_no");
    String scope = (String) authRes.get("scope");
    String tokenType = (String) authRes.get("token_type");
	 */
	

	//http://localhost:9997/global-pay/callback?
	//code=v9L982eZj6u8TJoWJAKRgSDp82SigT
	//&scope=inquiry%20login%20transfer
	//&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY
	
	 @RequestMapping("/callback") 
	 public String callback(@RequestParam("code") String code){
		 
		 
		 //http://localhost:9997/global-pay/callback?
		 //code=X96iUrwRjMG3pRT9mvohm3PcSc588t
		 //&scope=inquiry%20login%20transfer
		 //&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY
		 
		 
		 // 응답
		 
		 /*
		  {
"access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwOTk3ODkzIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2Mzg3MDUzNzUsImp0aSI6IjU3YjdkNGFjLWZlNjAtNGJlNS1iYzZmLWU3ZGY2NzE4MzVkZCJ9.0boIeKyrjkONCI82I2wNNXGIO7xkJvOlgTuh8phpStI",
"token_type": "Bearer",
"refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwOTk3ODkzIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2Mzk1NjkzNzUsImp0aSI6IjlmODBiMmVhLWNiMWUtNDMwYi04YTViLTRmOTNiYTEwNzRkMSJ9.WUKqm77Sf1t9jk6d1K9nI0AQ7kvni4RTHhYrozHu1n4",
"expires_in": 7775999,
"scope": "inquiry login transfer",
"user_seq_no": "1100997893"
		  */
		
		 return "redirect:https://testapi.openbanking.or.kr/oauth/2.0/token";
		 
	 }
	
	
	
	
}
