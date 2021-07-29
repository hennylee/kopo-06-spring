package di.anno03;

import org.springframework.stereotype.Component;

@Component("tire")
public class NexenTire {
	public String getBrand() {
		return "넥센타이어";
	}
}
