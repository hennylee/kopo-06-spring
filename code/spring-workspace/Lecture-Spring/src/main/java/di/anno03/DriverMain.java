package di.anno03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
	public static void main(String[] args) {
		
		System.out.println("====================초기화==================");
		
		ApplicationContext context = new GenericXmlApplicationContext("di.anno03.xml");
		
		System.out.println("------------------car객체-------------------");
		
//		Car car = context.getBean("car", Car.class);
		Car car = context.getBean("myCar", Car.class);
		car.printTireBrand();
		
		System.out.println("------------------car02객체-----------------");
		
		Car02 car02 = context.getBean("car02", Car02.class);
		car02.printTireBrand();
		
		System.out.println("=========================================");
		
	}
}
