package aop.anno;

public class Manager implements Employee {

	@Override
	public void work() {
		System.out.println("팀원들과 회의를 합니다.");
	}

}
