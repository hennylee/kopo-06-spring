package di.java02;

import org.springframework.stereotype.Component;

@Component("kumho")
public class KumhoTire implements Tire {

	public KumhoTire() {
		System.out.println("KumhoTire()....");
	}
	
	public String getBrand() {
		return "금호타이어";
	}

}
