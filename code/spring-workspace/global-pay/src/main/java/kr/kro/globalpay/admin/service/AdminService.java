package kr.kro.globalpay.admin.service;

import kr.kro.globalpay.admin.vo.AdminVO;

public interface AdminService {
	int register(AdminVO admin);
	int idCheck(String id);
	AdminVO login(AdminVO admin);
}
