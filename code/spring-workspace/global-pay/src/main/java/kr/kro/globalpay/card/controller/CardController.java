package kr.kro.globalpay.card.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardController {

	@RequestMapping("/card")
	public String index() {
		return "/card/index";
	}
	
	@RequestMapping("/issue")
	public String opening() {
		return "/card/issue";
	}
}
