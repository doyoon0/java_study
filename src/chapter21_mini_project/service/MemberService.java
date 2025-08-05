package chapter21_mini_project.service;

import chapter21_mini_project.model.MemberVo;

public interface MemberService {
	MemberVo memberCheck(String username, String phone);
	public void menuGuestInfo(MemberVo member);
}
