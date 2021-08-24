package aop.pojo;

public class Manager implements Employee {

	@Override
	public void work() {
		Action.gotoOffice(); // 개발자가 직접 작성하지 않으면 공통코드 주입이 불가능하다는 단점이 있다. => 책임이 개발자에게 있음 
		System.out.println("팀원들과 회의를 합니다.");
		Action.getoffOffice();
	}

}
