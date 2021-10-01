package kr.kro.globalpay.jwt.service;

import org.springframework.stereotype.Service;

@Service
public interface JWTService {
	
    String createToken(String cardNo, String cvc, long ttlMillis);
    
    String getSubject(String token);
}
