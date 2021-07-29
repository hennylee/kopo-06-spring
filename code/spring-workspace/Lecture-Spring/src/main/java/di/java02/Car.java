package di.java02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	@Qualifier("hankook") // tire 여러개중에 특정 값 선택
	private Tire tire;

	
	public Car() {
		System.out.println("Car()...");
	}
	
	
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}
	

	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()....");
	}


	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
