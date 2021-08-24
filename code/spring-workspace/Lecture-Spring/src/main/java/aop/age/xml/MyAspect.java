package aop.age.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	
//	@After("execution(* aop.age.xml.*.setAge(..))")
	public void checkAdult(JoinPoint joinPoint) {
		System.out.println("checkAdult()...");
		
		Object[] args = joinPoint.getArgs();
		
		int age = (int)args[0];
		
		if(age >= 20) {
			System.out.println("성인입니다.");
		}
		else {
			System.out.println("미성년자입니다.");
		}
	}
	
	// 다른 방식으로 작성해보기 : @Around
	@Around("execution(* aop.test.*.setAge(..))")
	public void checkAdult2() {
		System.out.println("checkAdult2()...");
	}
	
}
