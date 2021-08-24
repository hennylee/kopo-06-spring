package homework.hw0729.anno01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class MyCalculator {
	
	@Value("1")
	private int num1;
	
	@Value("3")
	private int num2;
	
	@Autowired
	private Calculator calc; 
	
	public MyCalculator() {
		System.out.println("MyCalculator()...");
	}
	
	
	public void printAll() {
		System.out.println("더하기 : " + calc.add(num1, num2));
		System.out.println("나누기 : " + calc.div(num1, num2));
		System.out.println("곱하기 : " + calc.mul(num1, num2));
		System.out.println("빼기 : " + calc.minus(num1, num2));
	}
}
