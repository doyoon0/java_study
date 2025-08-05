package chapter21_mini_project.repository;

import chapter21_mini_project.model.MemberVo;

public interface MemberRepository {
	public int menuGuestInfo(MemberVo member);
	public MemberVo getMemberById(String userid);
}
