package kr.kro.globalpay.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kro.globalpay.shopping.service.ShoppingService;
import kr.kro.globalpay.shopping.vo.ProductVO;

@Controller
public class ShoppingController {
	
	@Autowired
	private ShoppingService service;

	@RequestMapping("/shopping")
	public ModelAndView index() {
		
		// 1. 쇼핑몰 코드로 상품 검색
		List<ProductVO> products = service.selectAllProduct();
		
		ModelAndView mav = new ModelAndView("shopping/index");
		mav.addObject("products", products);
		
		return mav;
	}
}
