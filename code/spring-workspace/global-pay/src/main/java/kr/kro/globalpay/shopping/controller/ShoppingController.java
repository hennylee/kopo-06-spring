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

import com.google.gson.Gson;

import kr.kro.globalpay.card.service.CardService;
import kr.kro.globalpay.card.vo.AvgPriceDTO;
import kr.kro.globalpay.currency.vo.ExchangeRateVO;
import kr.kro.globalpay.shopping.service.ShoppingService;
import kr.kro.globalpay.shopping.vo.FavouriteListVO;
import kr.kro.globalpay.shopping.vo.ProductVO;
import kr.kro.globalpay.shopping.vo.RegisterAlarmVO;

@Controller
public class ShoppingController {
	
	@Autowired
	private ShoppingService service;
	
	@Autowired
	private CardService cService;
	
	@RequestMapping("/shopping")
	public ModelAndView index() {
		
		// 쇼핑몰 조회
		
		// 상품 전체 조회
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
	  
	  @RequestMapping("/shopping/delFavourite/{no}")
	  public @ResponseBody String delFavourite(@PathVariable("no") int no, Authentication authentication) {
		  
			String msg = "";

			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String id = userDetails.getUsername();

			try {
				service.delFavourite(id, no);
				msg = "삭제가 완료되었습니다.";
			} catch (Exception e) {
				e.printStackTrace();
				msg = "삭제에 실패하였습니다.";
			}

			return msg;
	  }
	  
	  @RequestMapping("/shopping/favourite") 
	  public String favourite(Model model, Authentication authentication){
		  
		  UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
		  String id = userDetails.getUsername();
		  
		  List<FavouriteListVO> list = service.selectAllFavoiriteById(id);
		  model.addAttribute("list", list);
		  
		  return "shopping/favourite"; 
	  }
	  
	  
	  @RequestMapping("/shopping/alarm") 
	  public String alarm(Model model, Authentication authentication){
		  
		  UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
		  String id = userDetails.getUsername();
		  
		  // 회원의 알람 목록
		  List<RegisterAlarmVO> list = service.selectAllAlarmById(id);
		  model.addAttribute("list", list);
		  
		  
		  
		  return "shopping/alarm"; 
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
	  
	  @RequestMapping("/shopping/detail/{no}") 
	  public ModelAndView detail(@PathVariable int no, Authentication authentication){
		  
		  UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
		  String id = userDetails.getUsername();
		  
		  // 상품 전체 정보
		  ProductVO product = service.selectOneProduct(no);
		  
		  // 평균 구매가 
		  Map<String, Object> map = cService.selectMyAvgPrice(id, product.getCurrency());
		  AvgPriceDTO dto = (AvgPriceDTO) map.get("dto");
		  ExchangeRateVO vo = (ExchangeRateVO) map.get("vo");
		  List<ExchangeRateVO> list = (List<ExchangeRateVO>) map.get("list");
		  
		  String json = new Gson().toJson(list); // 환율데이터 json 형식으로 변환
		  
		  ModelAndView mav = new ModelAndView("shopping/detail");
		  
		  if(dto != null && !Double.isNaN(dto.getAvgPrice()) ) {
			  mav.addObject("dto", dto);
		  }
		  mav.addObject("product", product);
		  mav.addObject("json", json);
		  mav.addObject("vo", vo);
		  
		  
		  return mav; 
	  }
	  
	  @RequestMapping("/shopping/buy/{no}") 
	  public String buy(@PathVariable("no") int no, Authentication authentication){
		  
		  // 회원 id
		  UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
		  String id = userDetails.getUsername();
		  
		  // 결체 저리
		  service.updatePay(id, no);
		  
		  return "redirect:/shopping"; 
	  }
	
	
}
