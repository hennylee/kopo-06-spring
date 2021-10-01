package kr.kro.globalpay.jwt.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kro.globalpay.jwt.service.JWTService;

@RestController
public class JWTController {
	
	@Autowired
    private JWTService jwtService;
 
    @GetMapping("/jwt/gen/token")
    public Map<String, Object> genToken(@RequestParam(value="cardNo") String cardNo, @RequestParam(value="cvc") String cvc ) {
        String token = jwtService.createToken(cardNo, cvc, (2 * 1000 * 60));
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("result", token);
        return map;
    }
 
    @ResponseBody
    @GetMapping("/jwt/get/subject")
    public Map<String, Object> getSubject(@RequestParam("token") String token) {
        String subject = jwtService.getSubject(token);
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("result", subject);
        return map;
    }
}
 