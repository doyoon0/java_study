package chapter21_mini_project.service;

import chapter21_mini_project.app.BookShoppingMallSystem;
import chapter21_mini_project.model.MemberVo;
import chapter21_mini_project.repository.MemberRepository;
import chapter21_mini_project.repository.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService{

	MemberRepository repository = new MemberRepositoryImpl();
	BookShoppingMallSystem bsm;
	
	public MemberServiceImpl() {};
    public MemberServiceImpl(BookShoppingMallSystem bsm) {
        this.bsm = bsm;
    };
	
	@Override
	public MemberVo memberCheck(String username, String phone) {
		MemberVo member = new MemberVo();
		member.setUsername(username);
		member.setPhone(phone);
		
		int result = repository.menuGuestInfo(member);
		
		if(result == 1) {
			return member;
		} else {
			return null;
		}
	}

	@Override
	public void menuGuestInfo(MemberVo member) {
		System.out.println("🥝현재 고객 정보 : ");
		
		if(member != null) {
			System.out.print("이름 : " + member.getUsername());
			System.out.println("  연락처 : " + member.getPhone());
			bsm.showMenu();
		} else {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}
	}

}
