package kr.kro.globalpay.admin.dao;

import kr.kro.globalpay.admin.vo.AdminVO;

public interface AdminDAO {
	int register(AdminVO admin);
	int idCheck(String id);
	AdminVO login(AdminVO admin);
}
