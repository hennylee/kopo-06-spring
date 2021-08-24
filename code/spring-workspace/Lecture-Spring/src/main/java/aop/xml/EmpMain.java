package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
Spring AOP 특징
1. Runtime 기반
2. Proxy 기반
3. 인터페이스 기반 (반드시 인터페이스로 객체를 받아야 한다 , Employee e = xxx.getBean("programmer")


 */
public class EmpMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("aop-xml.xml");
		
//		Employee e = context.getBean("programmer", Employee.class);
		Employee e = context.getBean("designer", Employee.class);
		e.work();
		
	}
	
}
