package di.java02;

import org.springframework.stereotype.Component;

@Component("hankook")
public class HankookTire implements Tire {

	public HankookTire() {
		System.out.println("HankookTire()...");
	}
	
	public String getBrand() {
		return "한국타이어";
	}

}
