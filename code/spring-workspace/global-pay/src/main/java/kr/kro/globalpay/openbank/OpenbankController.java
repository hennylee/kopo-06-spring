package kr.kro.globalpay.openbank;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class OpenbankController {
	
	private static String CLIENT_ID = "f07ebe18-950e-41d5-895d-d7588dac259d";
	private static String CLIENT_SECRET = "25ec313a-a0e1-4818-b7b7-6b06b76ff984";
	private static String GRANT_TYPE = "authorization_code";
	private static String REDIRECT_URI = "http://localhost:9997/global-pay/callback";
	private static String STATE = "b80BLsfigm9OokPTjy03elbJqRHOfGSY";
	
	
	@RequestMapping("/callback")
	public JSONObject callback(@RequestParam String code) {
		
		JSONObject jsonObj = null; // 반환값
		
		// 응답
		//http://localhost:9997/global-pay/callback?
		// code=9nqvCRhEwCCOPWUwA5o6vsVgKLIR9p
		// &scope=inquiry%20login%20transfer
		// &state=b80BLsfigm9OokPTjy03elbJqRHOfGSY
		
		// 요청 URL
		StringBuilder apiURL = new StringBuilder("https://testapi.openbanking.or.kr/oauth/2.0/token");

		apiURL.append("&code=" + code);
		apiURL.append("&client_id=" + CLIENT_ID);
		apiURL.append("&client_secret=" + CLIENT_SECRET);
		apiURL.append("&grant_type=" + GRANT_TYPE);
		apiURL.append("&redirect_uri=" + REDIRECT_URI);
		
		
		try {
			URL url = new URL(apiURL.toString());
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			
		    String param = "code=" + code
							+ "&client_id=" + CLIENT_ID
							+ "&client_secret=" + CLIENT_SECRET
							+ "&grant_type=" + GRANT_TYPE
							+ "&redirect_uri=" + REDIRECT_URI;
		    
			
		    OutputStream out_stream = http.getOutputStream();

		    out_stream.write( param.getBytes("UTF-8") );
		    out_stream.flush();
		    out_stream.close();



			int responseCode = http.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
//			BufferedReader br;
			
			// 정상 호출이라면?
			/*
			if (responseCode == "O0001") {
				br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			}
			// 에러가 발생했다면?
			else {
				br = new BufferedReader(new InputStreamReader(http.getErrorStream()));
			}
			*/
			
			/*
			br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			
			String inputLine;
			StringBuffer res = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}

			br.close();
			
			JSONParser parsing = new JSONParser();
			Object obj = parsing.parse(res.toString());
			jsonObj = (JSONObject) obj;
			*/
			
		    InputStream is      = null;
		    BufferedReader in   = null;
		    String data         = "";

		 

		    is  = http.getInputStream();
		    in  = new BufferedReader(new InputStreamReader(is), 8 * 1024);

		 

		    String line = null;
		    StringBuffer buff   = new StringBuffer();

		 

		    while ( ( line = in.readLine() ) != null )
		    {
		        buff.append(line + "\n");
		    }
		    data    = buff.toString().trim();
		    System.out.println(data);


			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonObj;
		
		
	}
	

}
