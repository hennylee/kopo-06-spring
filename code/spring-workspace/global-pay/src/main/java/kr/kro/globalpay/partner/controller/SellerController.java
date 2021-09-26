package kr.kro.globalpay.partner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partner/**")
public class SellerController {

	@RequestMapping("/")
	public String index() {
		return "partner/index";
	}

}
