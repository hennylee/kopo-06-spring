package kr.kro.globalpay.shopping.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kro.globalpay.shopping.dao.ShoppingDAO;
import kr.kro.globalpay.shopping.vo.ProductVO;
import kr.kro.globalpay.shopping.vo.RegisterAlarmVO;

@Service
public class ShoppingSeriviceImpl implements ShoppingService {
	
	@Autowired
	private ShoppingDAO dao;
	
	@Override
	public List<ProductVO> selectByShop(String shopCode) {
		List<ProductVO> list = dao.selectByShop(shopCode);
		return list;
	}

	@Override
	public List<ProductVO> selectAllProduct() {
		List<ProductVO> list = dao.selectAllProduct();
		return list;
	}

	@Override
	@Transactional
	public int addFavourite(Map<String, Object> map) {
		
		int cnt = -1;
		
		// 이미 담겨있는지 확인하기
		int existCnt = dao.countFavoiriteById(map);
		
		if(existCnt == 0) {
			cnt = dao.addFavourite(map);
		}
		
		return cnt;
	}

	@Override
	public List<ProductVO> selectAllFavoiriteById(String id) {
		List<ProductVO> list = dao.selectAllFavoiriteById(id);
		return list;
	}

	@Override
	public int registerAlarm(RegisterAlarmVO vo) {
		
		int cnt = -1;
		
		// 이미 담겨있는지 확인하기
		int existCnt = dao.countAlarmById(vo);
		
		// db에 등록하기
		if(existCnt == 0) {
			cnt = dao.registerAlarm(vo);
		}
		
		return cnt;
	}
	
	
	

}
