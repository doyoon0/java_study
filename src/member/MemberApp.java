package member;

import java.util.List;
import java.util.Scanner;

public class MemberApp {
	Scanner scan = new Scanner(System.in);
	public static final int INSERT = 1;
	public static final int LIST = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	public static final int EXIT = 9;
	MemberDao memberDao;
	
	public MemberApp() {
		memberDao = new MemberDao();
		showMenu();
		selectMenu();
	}

	public void selectMenu() {
		System.out.print("메뉴> ");
		int menuNo = scan.nextInt();
		switch(menuNo) {
			case INSERT : insert(); break;
			case LIST : list(); break;
			case UPDATE : update(); break;
			case DELETE : delete(); break;
			case EXIT : exit(); break;
		}
	}

	public void showMenu() {
		System.out.println();
		System.out.println("**************************************");
		System.out.println("\t1. 등록");
		System.out.println("\t2. 조회(전체)");
		System.out.println("\t3. 수정");
		System.out.println("\t4. 삭제");
		System.out.println("\t9. 종료");
		System.out.println("**************************************");
	}
	
	public void insert() {
		MemberVo member = new MemberVo();
		System.out.println("=> 이름, 이메일을 입력해주세요");
		System.out.print("이름> ");
		member.setName(scan.next());
		
		System.out.print("이메일> ");
		member.setEmail(scan.next());
		
		int result = memberDao.insert(member);
		if(result == 1) {
			System.out.println("=> 등록 성공!!");
		} else {
			System.out.println("=> 등록 실패!!");
		}
		
		selectMenu();
	}
	
	public void list() {
		List<MemberVo> list = memberDao.listAll();
		if(list.size() != 0) {
			System.out.println("*************************************************************");
			System.out.println("no\tId\tName\tEmail\t\tCredate");
			System.out.println("*************************************************************");
			list.forEach((member) -> {
				System.out.print(member.getRno() +"\t");
				System.out.print(member.getMemberId() +"\t");
				System.out.print(member.getName() +"\t");
				System.out.print(member.getEmail() +"\t\t");
				System.out.print(member.getCreatedAt() +"\n");
			});
			
		} else {
			System.out.println("=> 등록된 데이터가 없습니다.");
		}
		
		showMenu();
		selectMenu();
	}
	
	public void update() {
		//업데이트 가능 여부 확인 : 
		System.out.print("[검색]아이디> ");
		
		MemberVo member = memberDao.search(scan.nextInt());
		if(member.getMemberId() != 0) {
			//업데이트 할 데이터 입력
			System.out.println("[(구)" + member.getName() + ", " + member.getEmail() + "] " + "=> 이름, 이메일을 입력해주세요");
			System.out.print("[수정]이름> ");
			member.setName(scan.next());
			
			System.out.print("[수정]이메일> ");
			member.setEmail(scan.next());
			
			int result = memberDao.update(member);
			if(result == 1) {
				System.out.println("=> 업데이트 성공!!");
			} else {
				System.out.println("=> 업데이트 실패!!");
			}
		} else {
			System.out.println("=> 등록된 데이터가 없습니다.");
		}
		
		showMenu();
		selectMenu();
		
	}
	
	public void delete() {
		System.out.print("[삭제]아이디> ");		
		int result = memberDao.delete(scan.nextInt());
		
			if(result == 1) {
				System.out.println("=> 삭제 성공!!");
			} else {
				System.out.println("=> 삭제 실패!!");
			}
		
		showMenu();
		selectMenu();
	}
	

	private void exit() {
		System.exit(0);
	}
}
