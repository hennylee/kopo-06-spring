package di.anno01;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * 의존 주입 : 의존성을 가지고 있는 객체(Tire)가 외부에서값을 가지고 오는 것
 */
public class Car {
	
	// 3. 멤버변수 자동 주입
//	@Autowired
	private Tire tire;

	
	public Car() {
		System.out.println("Car()...");
	}
	

	// 1. 자동 생성자 주입방식 : 1) type 매칭 => 2) id 이름 매칭
//	@Autowired
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}
	

	// 2. setter 생성자 자동 주입방식
//	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()....");
	}


	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
