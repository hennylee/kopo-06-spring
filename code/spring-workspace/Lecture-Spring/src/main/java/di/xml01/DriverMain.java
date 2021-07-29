package di.xml01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
	
	public static void main(String[] args) {

/*
 *  1. 기존 방식
 */
		/*
		Tire tire = new HankookTire();
		Car car = new Car();
		car.setTire(tire);
		car.printTireBrand();
		*/
		

/*
 *  2. 스프링 컨테이너를 가지고 외부에서 의존 객체를 주입하는 방법을 실습해보자
 */
//		/*
		ApplicationContext context = new GenericXmlApplicationContext("di-xml01.xml");
//		Tire tire = (Tire) context.getBean("tire");
//		Car car = (Car) context.getBean("car");
//		car.setTire(tire);
//		car.printTireBrand();
//		*/
		
		
		
/*
 *  3. 스프링 컨테이너를 가지고 외부에서 의존 객체를 주입하는 방법을 실습해보자 + setter 주입까지 실행해보자
 */
		/*
		ApplicationContext context = new GenericXmlApplicationContext("di-xml01.xml");
		Car car = (Car) context.getBean("car2");
		car.printTireBrand();
		*/
	}
	
}
