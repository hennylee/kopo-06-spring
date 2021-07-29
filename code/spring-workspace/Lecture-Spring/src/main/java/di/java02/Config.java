package di.java02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.java02"})
@Configuration
public class Config {
	
	/*
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean
	@Qualifier("hankook") // 이름이 너무 기니까 hankook으로 사용
	public Tire hankookTire() {
		return new HankookTire();
	}
	
	@Bean
	@Qualifier("kumho")
	public Tire kumhoTire() {
		return new KumhoTire();
	}
	*/
	
}
