package homework.hw0729.java01;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public Calculator() {
		System.out.println("Calculator()...");
	}
	
	public int add(int num1, int num2) {
		return (num1 + num2);
	}
	
	public int mul(int num1, int num2) {
		return (num1 * num2);
	}
	
	public int minus(int num1, int num2) {
		return (num1 - num2);
	}
	
	public int div(int num1, int num2) {
		return (num1 / num2);
	}
}
