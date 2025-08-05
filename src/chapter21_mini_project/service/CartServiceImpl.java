package chapter21_mini_project.service;

import java.util.List;
import java.util.Scanner;

import chapter21_mini_project.app.BookShoppingMallSystem;
import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import chapter21_mini_project.model.MemberVo;
import chapter21_mini_project.repository.CartRepository;
import chapter21_mini_project.repository.CartRepositoryImpl;
import chapter21_mini_project.repository.MemberRepository;
import chapter21_mini_project.repository.MemberRepositoryImpl;

public class CartServiceImpl implements CartService {
	Scanner scan;
	CartRepository repository = new CartRepositoryImpl();
	MemberRepository memberRepository = new MemberRepositoryImpl();
	BookShoppingMallSystem bsm;
	
	public CartServiceImpl() {};
	public CartServiceImpl(BookShoppingMallSystem bsm) {
		this.scan = bsm.scan;
		this.bsm = bsm;
	};

	@Override
	public void menuCartItemList(String userid) {
		List<CartVo> cart = repository.menuCartItemList(userid);
	    System.out.println("🥝 장바구니 상품 목록 : ");
	    
	    System.out.println("--------------------------------------------");
	    System.out.printf("%-10s | %-5s | %-6s\n", "도서ID", "수량", "합계");
	    for (CartVo cartItem : cart) {
	        System.out.printf("%-10s  | %-5d  | %-6d\n", 
	                          cartItem.getIsbn(), 
	                          cartItem.getQuantity(), 
	                          cartItem.getTotal());
	    }

	    System.out.println("--------------------------------------------");
		
		bsm.showMenu();
		
	}
	@Override
	public void menuCartClear(String userid) {
		System.out.println("장바구니에 모든 항목을 삭제하시겠습니까? Y  |  N");
		String delYN = scan.next();
		if(delYN.equals("Y")) {
			repository.menuCartClear(userid);
			System.out.println("장바구니에 모든 항목을 삭제했습니다.");
		} else if (delYN.equals("N")) {
			bsm.showMenu();
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		
		bsm.showMenu();
	}
	
	@Override
	public void menuCartAddItem(String userid) {
		List<BookVo> bookVo = repository.bookListAll();
		bookVo.forEach(bookList -> {
			System.out.print( bookList.getIsbn() + " | "
							+ bookList.getTitle() + " | "
							+ bookList.getPrice() + " | "
							+ bookList.getAuthor() + " | "
							+ bookList.getDetail() + " | "
							+ bookList.getPublisher() + " | "
							+ bookList.getBdate() + " \n "
			);
			
		});
		
		System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
		
		//유효성 검사 추가해야함
		CartVo cart = new CartVo();
		cart.setUserid(userid);
		cart.setIsbn(scan.next().trim());
		cart.setQuantity(1);
		
		repository.menuCartAddItem(cart);
		
		System.out.println(cart.getIsbn() + "도서가 장바구니에 추가되었습니다.");
		
		bsm.showMenu();
	}
	
	@Override
	public void menuCartRemoveItemCount(String userid) {
		
		System.out.print("장바구니에서 수량을 변경할 도서의 ID를 입력하세요 : ");
		
		//유효성 검사 추가해야함
		CartVo cart = new CartVo();
		cart.setUserid(userid);
		cart.setIsbn(scan.next().trim());
		cart.setQuantity(1);
		
		repository.menuCartRemoveItemCount(cart);
		
		System.out.println(cart.getIsbn() + "도서가 수량 변경되었습니다.");
		
		bsm.showMenu();
	}
	
	@Override
	public void menuCartRemoveItem(String userid) {
		System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
		
		CartVo cart = new CartVo();
		cart.setUserid(userid);
		cart.setIsbn(scan.next().trim());
		cart.setQuantity(1);
		
		System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N");
		String delYN = scan.next();
		if(delYN.equals("Y")) {
			repository.menuCartRemoveItem(cart);
			System.out.println(cart.getIsbn() + " 도서가 장바구니에서 삭제되었습니다.");
			bsm.showMenu();
		} else if (delYN.equals("N")) {
			bsm.showMenu();
		} else {
			System.out.println("잘못된 입력입니다.");
			bsm.showMenu();
		}
	}
	
	@Override
	public void menuCartBill(String userid) {
		String name;
		String phone;
		String address;
		String orderDate = java.time.LocalDate.now().toString();
		MemberVo member = memberRepository.getMemberById(userid);
		
		// 장바구니 목록 조회
	    List<CartVo> cartList = repository.menuCartItemList(userid);
	    int totalAmount = 0;
	    
		name = member.getUsername();
		phone = member.getPhone();
		address = null;

		
		System.out.println("배송받을 분은 고객정보와 같습니까? Y | N ");
		
		String input = scan.next();
		if(input.equals("N")) {
			System.out.print("배송받을 고객명을 입력하세요 : ");
			name = scan.next();
			System.out.print("배송받을 고객의 연락처를 입력하세요 : ");
			phone = scan.next();
			System.out.print("배송받을 고객의 배송지를 입력해주세요 : ");
			scan.nextLine();  
			address = scan.nextLine();  
		} else if(input.equals("Y")) {
			System.out.print("배송받을 고객의 배송지를 입력해주세요 : ");
			scan.nextLine();
			address = scan.nextLine();
			name = member.getUsername();
			phone = member.getPhone();
		} else {
			System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
		    bsm.showMenu();
		}
		
		System.out.println("\n----------------------------------------------------");
		System.out.println("📦 주문이 완료되었습니다!");
		System.out.println("----------------------------------------------------");
		System.out.println("▶ 수령인 이름   : " + name);
		System.out.println("▶ 연락처        : " + phone);
		System.out.println("▶ 배송지        : " + address);
		System.out.println("▶ 주문일        : " + orderDate);
		System.out.println("----------------------------------------------------");
		System.out.printf("%-10s | %-4s | %-6s\n", "도서ID", "수량", "합계");

		for (CartVo c : cartList) {
		    totalAmount += c.getTotal();

		    System.out.printf("%-10s | %-4d | %-6d\n",
		            c.getIsbn(), c.getQuantity(), c.getTotal());
		}

		System.out.println("----------------------------------------------------");
		System.out.println("💰 주문 총 금액 : " + totalAmount + "원");
		System.out.println("----------------------------------------------------");

		// 메인 메뉴로 이동
		bsm.showMenu();

	}
	
	@Override
	public void menuExit() {
		System.out.println("프로그램이 종료되었습니다. 이용해주셔서 감사합니다.");
		System.exit(0);		
	}


}
