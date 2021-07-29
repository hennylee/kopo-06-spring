package di.anno03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("myCar") // 별다른 id를 설정하지 않으면, id는 자동으로 car가 된다.
public class Car {
	
//	@Autowired
//	@Qualifier("hankookTire")
	private Tire tire;

	
	public Car() {
		System.out.println("Car()...");
	}
	
	
	@Autowired
	public Car(@Qualifier("kumhoTire") Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}
	

//	@Autowired
//	@Qualifier("hankookTire")
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()....");
	}


	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
