package homework.hw0729.xml01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class MyCalculator {
	
	// 멤버변수
	private int num1;
	
	private int num2;
	
	private Calculator calc; 
	
	// 생성자
	public MyCalculator() {
		System.out.println("MyCalculator()...");
	}
	
	public MyCalculator(Calculator calc) {
		this.calc = calc;
		System.out.println("MyCalculator(Calculator)...");
	}
	
	// setter
	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	
	public void printAll() {
		System.out.println("더하기 : " + calc.add(num1, num2));
		System.out.println("나누기 : " + calc.div(num1, num2));
		System.out.println("곱하기 : " + calc.mul(num1, num2));
		System.out.println("빼기 : " + calc.minus(num1, num2));
	}

	
}
