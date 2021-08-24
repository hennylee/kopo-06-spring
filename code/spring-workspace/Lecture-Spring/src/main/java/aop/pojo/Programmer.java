package aop.pojo;

public class Programmer implements Employee{

	@Override
	public void work() {
		
//		System.out.println("출근을 한다.");
		Action.gotoOffice();
		
		System.out.println("시스템 개발을 한다.");
		
//		System.out.println("퇴근을 한다.");
		Action.getoffOffice();
		
	}

}
