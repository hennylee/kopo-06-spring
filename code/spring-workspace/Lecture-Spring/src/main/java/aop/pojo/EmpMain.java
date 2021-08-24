package aop.pojo;

public class EmpMain {
	
	public static void main(String[] args) {
		Employee p =  new Programmer();
		p.work();
		
		Employee d = new Designer();
		d.work();
		
	}
	
}
