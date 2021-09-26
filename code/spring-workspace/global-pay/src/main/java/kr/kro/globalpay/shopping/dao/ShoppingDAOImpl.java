package kr.kro.globalpay.shopping.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kro.globalpay.shopping.vo.ProductVO;
import kr.kro.globalpay.shopping.vo.RegisterAlarmVO;

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


	@Override
	public int addFavourite(Map<String, Object> map) {
		int cnt = sqlSessionTemplate.insert("shopping.ShoppingDAO.addFavourite", map);
		return cnt;
	}


	@Override
	public int countFavoiriteById(Map<String, Object> map) {
		int cnt = sqlSessionTemplate.selectOne("shopping.ShoppingDAO.countFavoiriteById", map);
		return cnt;
	}


	@Override
	public List<ProductVO> selectAllFavoiriteById(String id) {
		List<ProductVO> list = sqlSessionTemplate.selectList("shopping.ShoppingDAO.selectAllFavoiriteById", id);
		return list;
	}


	@Override
	public int registerAlarm(RegisterAlarmVO vo) {
		int cnt = sqlSessionTemplate.insert("shopping.ShoppingDAO.registerAlarm", vo);
		return cnt;
	}


	@Override
	public int countAlarmById(RegisterAlarmVO vo) {
		int cnt = sqlSessionTemplate.selectOne("shopping.ShoppingDAO.countAlarmById", vo);
		return cnt;
	}
	
}
