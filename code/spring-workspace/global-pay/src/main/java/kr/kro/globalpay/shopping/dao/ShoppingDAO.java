package kr.kro.globalpay.shopping.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kro.globalpay.shopping.vo.ProductVO;

public interface ShoppingDAO {
	
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
