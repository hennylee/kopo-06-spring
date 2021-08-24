package aop.age.xml;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {
	
	private int age;

	@Override
	public void setAge(int age) {
		this.age = age;
		System.out.println("Man : setAge()...");
	}

}
