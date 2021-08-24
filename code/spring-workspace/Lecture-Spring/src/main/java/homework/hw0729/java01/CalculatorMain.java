package homework.hw0729.java01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MyCalculator calc = context.getBean("myCalculator", MyCalculator.class);
		calc.printAll();
	}
}
