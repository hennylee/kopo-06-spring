package di.xml02;

public class Car {
	private Tire tire;
	
	public Car() { 
		System.out.println("Car() 호출..."); 
	}
	 
	// 생성자 주입
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	
	public Car(Tire tire, Tire tire2) {
		System.out.println("Car(Tire, Tire) 호출...");
	}
	
	public Car(Tire tire, String str) {
		System.out.println("Car(Tire, String) 호출...");
	}
	
	public Car(String str, Tire tire) {
		System.out.println("Car(String, Tire) 호출...");
	}

	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

