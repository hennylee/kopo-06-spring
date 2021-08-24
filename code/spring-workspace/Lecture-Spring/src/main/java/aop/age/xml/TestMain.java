package aop.age.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop-age-xml.xml");
		
		Person p = context.getBean("man", Person.class);
		p.setAge(20);
	}
}
