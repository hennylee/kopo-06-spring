package di.java;

import org.springframework.stereotype.Component;

@Component
public class HankookTire implements Tire {

	public HankookTire() {
		System.out.println("HankookTire()...");
	}
	
	public String getBrand() {
		return "한국타이어";
	}

}
