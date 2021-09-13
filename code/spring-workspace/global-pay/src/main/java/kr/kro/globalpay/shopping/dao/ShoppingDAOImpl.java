package kr.kro.globalpay.shopping.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kro.globalpay.shopping.vo.ProductVO;

@Repository
public class ShoppingDAOImpl implements ShoppingDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ProductVO> selectByShop(String shopCode) {
		List<ProductVO> list = sqlSessionTemplate.selectList("shopping.ShoppingDAO.selectByShop", shopCode);
		return list;
	}

	
	@Override
	public List<ProductVO> selectAllProduct() {
		List<ProductVO> list = sqlSessionTemplate.selectList("shopping.ShoppingDAO.selectAllProduct");
		return list;
	}

}
