package chapter21_mini_project.app;

import java.util.Scanner;

import chapter21_mini_project.model.MemberVo;
import chapter21_mini_project.service.CartService;
import chapter21_mini_project.service.CartServiceImpl;
import chapter21_mini_project.service.MemberService;
import chapter21_mini_project.service.MemberServiceImpl;

public class BookShoppingMallSystem {
	public Scanner scan;
	private MemberVo memberCheck;
	public MemberService memberService;
	public CartService cartService;
	
	public static final int menuGuestInfo = 1;      		// 고객정보 확인하기
	public static final int menuCartItemList = 2;          	// 장바구니상품목록보기  
	public static final int menuCartClear = 3;         		// 장바구니 비우기
	public static final int menuCartAddItem = 4;           	// 바구니에 항목 추가하기
	public static final int menuCartRemoveItemCount = 5;    // 장바구니의 항목수량 줄이기
	public static final int menuCartRemoveItem = 6;        	// 장바구니의 항목 삭제하기
	public static final int menuCartBill = 7;       		// 영수증 표시하기
	public static final int menuExit = 8;          			// 종료
	
	public BookShoppingMallSystem() {
		scan = new Scanner(System.in);
		memberService = new MemberServiceImpl(this);
		cartService = new CartServiceImpl(this);
		memberCheck();
	}
	
	/*
	 * 사용자 확인
	 */
	public void memberCheck() {
		System.out.println("------------------");
		System.out.println("회원정보확인 ");
		System.out.println("------------------");
		
		while(memberCheck == null) {
			System.out.print("당신의 이름을 입력하세요 : ");
			String name = scan.next();
			
			System.out.print("연락처를 입력하세요(-포함) : ");
			String phone = scan.next();
			
			memberCheck = memberService.memberCheck(name, phone);
			
			if(memberCheck != null) {
				System.out.println("로그인 성공! 환영합니다, " + name + "님!");
				showMenu();
			} else {
				System.out.println("등록되지 않은 회원입니다. 다시 입력해주세요.");
				memberCheck = null;
				memberCheck();
			}
		}
		
		
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴 번호를 선택해주세요 > ");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			
			switch(menu) {
			case menuGuestInfo:
				memberService.menuGuestInfo(memberCheck);
				break;
			case menuCartItemList:
				cartService.menuCartItemList(memberCheck.getUserid());
				break;
			case menuCartClear:
				cartService.menuCartClear(memberCheck.getUserid());
				break;
			case menuCartAddItem:
				cartService.menuCartAddItem(memberCheck.getUserid());
				break;
			case menuCartRemoveItemCount:
				cartService.menuCartRemoveItemCount(memberCheck.getUserid());
				break;
			case menuCartRemoveItem:
				cartService.menuCartRemoveItem(memberCheck.getUserid());
				break;
			case menuCartBill:
				cartService.menuCartBill(memberCheck.getUserid());
				break;
			case menuExit:
				cartService.menuExit();
				break;
			default:
				System.out.println("=> 메뉴 준비중 입니다.");
			}
			
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요");
			scan.next();
			selectMenu();
		}
	}
	
	/*
	 * 메뉴 출력 
	 */
	public void showMenu() {
		System.out.println("***********************************************");
		System.out.println("  \tWelcome to Shopping Mall");
		System.out.println("  \tWelcome to Book Market");
		System.out.println("***********************************************");
		System.out.println(" 1. 고객 정보 확인하기\t4. 바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기\t\t8. 종료");
		System.out.println("***********************************************");
		
		selectMenu();
	}
}
