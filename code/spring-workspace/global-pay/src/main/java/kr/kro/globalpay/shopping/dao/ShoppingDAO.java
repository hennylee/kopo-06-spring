package kr.kro.globalpay.shopping.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kro.globalpay.shopping.vo.ProductVO;
import kr.kro.globalpay.shopping.vo.RegisterAlarmVO;

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
	
	/**
	 * 찜목록에 추가
	 */
	int addFavourite(Map<String, Object> map);
	
	/**
	 * 찜목록에 추가된 상품인지 확인하기
	 * @param map
	 * @return
	 */
	int countFavoiriteById(Map<String, Object> map);
	
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
	
	int countAlarmById(RegisterAlarmVO vo);
	
	
}
