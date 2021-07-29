package di.xml01;

public class Car {
	private Tire tire;
	
	public Car() {
		System.out.println("Car() 호출...");
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) 호출...");
	}
	
	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

