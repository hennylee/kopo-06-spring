package aop.pojo;

public class Designer implements Employee {

	@Override
	public void work() {
		
//		System.out.println("출근을 한다.");
		Action.gotoOffice();
		
		System.out.println("제품 디자인을 한다.");
		
//		System.out.println("퇴근을 한다.");
		Action.getoffOffice();
		
	}

}
