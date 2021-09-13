package kr.kro.globalpay.shopping.service;

import java.util.List;

import kr.kro.globalpay.shopping.vo.ProductVO;

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
}
