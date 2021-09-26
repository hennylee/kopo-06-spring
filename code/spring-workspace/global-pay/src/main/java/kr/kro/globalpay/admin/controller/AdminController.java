package kr.kro.globalpay.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kro.globalpay.admin.service.AdminService;
import kr.kro.globalpay.currency.service.CurrencyService;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;

@Controller
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("admin")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("admin/currency")
	public String currency(Model model) {
		
		List<ExchangeRateVO> list = adminService.selectAllCurrency();
		model.addAttribute("list", list);
		
		return "admin/currency/list";
	}
}
