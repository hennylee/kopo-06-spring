package di.xml02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
	
	public static void main(String[] args) {
		
/*
 *  기존의 생성자 주입 방식
 */
		/*
		ApplicationContext context = new GenericXmlApplicationContext("di-xml02.xml");
		Tire tire = new HankookTire();
		Car car = new Car(tire);
		car.printTireBrand();
		*/

		
/*
 *  스프링 컨텍스트 주입 방식
 */
		ApplicationContext context = new GenericXmlApplicationContext("di-xml02.xml");
		Car car = context.getBean("car2", Car.class);
		car.printTireBrand();
		
	}
	
}
