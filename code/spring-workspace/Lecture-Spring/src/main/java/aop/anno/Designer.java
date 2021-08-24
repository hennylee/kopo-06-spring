package aop.anno;

public class Designer implements Employee {

	@Override
	public void work() {
		
		System.out.println("제품 디자인을 한다.");
		
	}

}
