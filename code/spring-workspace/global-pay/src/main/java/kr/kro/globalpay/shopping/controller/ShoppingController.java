package kr.kro.globalpay.shopping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.kro.globalpay.shopping.service.ShoppingService;
import kr.kro.globalpay.shopping.vo.ProductVO;
import kr.kro.globalpay.shopping.vo.RegisterAlarmVO;
import kr.kro.globalpay.util.LoginManager;

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
	
	
	  @RequestMapping("/shopping/addFavourite/{product}") 
	  public @ResponseBody int addFavourite(@PathVariable int product, Authentication authentication){
	  
		  
		  UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
		  String id = userDetails.getUsername();
		  
		  Map<String, Object> map = new HashMap<String, Object>(); 
		  map.put("id", id);
		  map.put("product", product);
		  
		  // 찜목록에 추가하기 
		  int cnt = service.addFavourite(map);
		  // cnt : -1(이미 존재하는 상품), 0(찜목록 추가 실패), 1(찜 성공)
		  
		  return cnt; 
	  }
	  
	  @RequestMapping("/shopping/favourite") 
	  public String favourite(Model model, Authentication authentication){
		  
		  UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
		  String id = userDetails.getUsername();
		  
		  List<ProductVO> list = service.selectAllFavoiriteById(id);
		  model.addAttribute("list", list);
		  
		  return "shopping/favourite"; 
	  }
	  
	  @PostMapping("/shopping/registerAlarm")
	  public @ResponseBody int registerAlarm(RegisterAlarmVO alarmVO, Authentication authentication) {
		  UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		  String id = userDetails.getUsername();
		  
		  if(id != null) {
			  alarmVO.setMemberId(id); // id확인해서 setter
			  System.out.println(alarmVO);
		  }
		  
		  int cnt = service.registerAlarm(alarmVO);
		  
		  // cnt : -1(이미 존재), 0(insert 실패), 1(insert 성공)
		  // 알람 등록 결과 안내하기
		  
		  return cnt;
	  }
	
	
}
