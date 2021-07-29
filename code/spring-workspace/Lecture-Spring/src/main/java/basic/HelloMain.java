package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		
		
		// 1. 기존 방식
		// Hello obj = new Hello();
		// obj.printMsg();
		
		// 2. xml에 만든 빈을 읽어오는 방식
		ApplicationContext context 
//						= new ClassPathXmlApplicationContext("beanContainer.xml"); // ClassPath를 기준으로 XML파일을 불러오겠다 (ClassPath : src/main/resources)
//						= new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml"); // 파일 경로를 기준으로 XML파일을 불러오겠다 
						= new GenericXmlApplicationContext("beanContainer.xml"); // 요즘 가장 많이 쓰는 방법
		
		Hello obj = (Hello) context.getBean("hello"); // getBean은 Object형이기 때문에 형변환 필수
		System.out.println(obj); // basic.Hello@6771beb3
		
		Hello obj2 = context.getBean("hello", Hello.class); // 형변환을 이런식으로도 할 수 있다.
		System.out.println(obj2); // basic.Hello@6771beb3
		
		Hello obj3 = context.getBean("hello2", Hello.class); 
		System.out.println(obj3); // basic.Hello@51399530
		
	}
}
