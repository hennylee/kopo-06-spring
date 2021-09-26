package kr.kro.globalpay.shopping.service;

import java.util.List;
import java.util.Map;

import kr.kro.globalpay.shopping.vo.ProductVO;
import kr.kro.globalpay.shopping.vo.RegisterAlarmVO;

public interface ShoppingService {
	/**
	 * shop 코드로 상품 조회
	 * @param shopCode
	 * @return
	 */
	List<ProductVO> selectByShop(String shopCode);
	
	/**
	 * 전체 상품 조회
	 * @return
	 */
	List<ProductVO> selectAllProduct();
	
	/**
	 * 찜목록에 추가
	 */
	int addFavourite(Map<String, Object> map);
	
	/**
	 * 찜 목록 조회
	 * @param id
	 * @return
	 */
	List<ProductVO> selectAllFavoiriteById(String id);
	

	/**
	 * 알람 신청하기
	 * @param vo
	 * @return
	 */
	int registerAlarm(RegisterAlarmVO vo);
}
