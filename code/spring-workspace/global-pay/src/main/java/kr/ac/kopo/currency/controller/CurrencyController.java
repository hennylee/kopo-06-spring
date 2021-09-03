package kr.ac.kopo.currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrencyController {
	
	@RequestMapping("/currency/dashboard")
	public String dashboard() {
		return"currency/dashboard";
	}
}
