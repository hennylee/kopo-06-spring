package di.basic;


/*
 * 의존 주입 : 의존성을 가지고 있는 객체(Tire)가 외부에서값을 가지고 오는 것
 */
public class Car {
	
	// 의존 관계 발생
	private Tire tire;

	public Car() {
		// 의존 관계 설정 => 개발자가 직접 설정하는 방법
		tire = new HankookTire();
//		tire = new KumhoTire();
	}
	
	
	// 1. 생성자 주입방식
	public Car(Tire tire) {
		super();
		this.tire = tire;
	}
	

	// 2. setter 생성자 주입방식
	public void setTire(Tire tire) {
		this.tire = tire;
	}


	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
