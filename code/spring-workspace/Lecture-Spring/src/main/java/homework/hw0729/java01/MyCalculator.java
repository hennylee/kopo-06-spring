package homework.hw0729.java01;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyCalculator {
	
	@Value("34")
	private int num1;
	
	@Value("4")
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