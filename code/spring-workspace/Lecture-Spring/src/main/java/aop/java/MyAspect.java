package aop.java;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	
	@Before("execution(void aop.java.*.work(..))")
	public void gotoOffice() {
		System.out.println("출근을 합니다.");
	}
	
	@After("execution(void aop.java.*.work())")
	public void getoffOffice() {
		System.out.println("퇴근을 합니다.");
	}
	
}
