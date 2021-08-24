package homework.hw0729.xml02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("hw0729-xml02.xml");
		MyCalculator calc = context.getBean("myCalc", MyCalculator.class);
		calc.printAll();
	}
}
