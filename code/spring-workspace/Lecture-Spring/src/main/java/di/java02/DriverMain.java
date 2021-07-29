package di.java02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Car car = context.getBean("car", Car.class);
		car.printTireBrand();
		
	}
	
}
