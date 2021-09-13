package kr.kro.globalpay.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kro.globalpay.shopping.dao.ShoppingDAO;
import kr.kro.globalpay.shopping.vo.ProductVO;

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
	
	
	

}
