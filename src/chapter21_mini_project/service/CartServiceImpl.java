package chapter21_mini_project.service;

import java.util.List;
import java.util.Scanner;

import chapter21_mini_project.app.BookShoppingMallSystem;
import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import chapter21_mini_project.repository.CartRepository;
import chapter21_mini_project.repository.CartRepositoryImpl;

public class CartServiceImpl implements CartService {
	Scanner scan;
	CartRepository repository = new CartRepositoryImpl();
	BookShoppingMallSystem bsm;
	
	public CartServiceImpl() {};
	public CartServiceImpl(BookShoppingMallSystem bsm) {
		this.scan = bsm.scan;
		this.bsm = bsm;
	};

	@Override
	public void cartList(String userid) {
		List<CartVo> cart = repository.cartList(userid);
		System.out.println("🥝 장바구니 상품 목록 : ");
		
		System.out.println("----------------------------------");
		System.out.println("ISBN\t\t수량");
		System.out.println("----------------------------------");
		cart.forEach(cartlist -> {
			System.out.print(cartlist.getIsbn() + " \t" );
			System.out.print(cartlist.getQuantity() + " \n" );
		});
		System.out.println("----------------------------------");
		
		bsm.showMenu();
		
	}
	@Override
	public void clear(String userid) {
		System.out.println("장바구니에 모든 항목을 삭제하시겠습니까? Y  |  N");
		String delYN = scan.next();
		if(delYN.equals("Y")) {
			repository.clear(userid);
			System.out.println("장바구니에 모든 항목을 삭제했습니다.");
		} else if (delYN.equals("N")) {
			bsm.showMenu();
		} else {
			System.out.println("잘못된 입력입니다.");
			bsm.showMenu();
		}
	}
	
	@Override
	public void add(String userid) {
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
		
		repository.add(cart);
		
		System.out.println(cart.getIsbn() + "도서가 장바구니에 추가되었습니다.");
		
		bsm.showMenu();
	}
	
	@Override
	public void reduce(String userid) {
		
		System.out.print("장바구니에서 수량을 변경할 도서의 ID를 입력하세요 : ");
		
		//유효성 검사 추가해야함
		CartVo cart = new CartVo();
		cart.setUserid(userid);
		cart.setIsbn(scan.next().trim());
		cart.setQuantity(1);
		
		repository.reduce(cart);
		
		System.out.println(cart.getIsbn() + "도서가 수량 변경되었습니다.");
		
		bsm.showMenu();
	}
	
	@Override
	public void remove(String userid) {
		System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
		
		CartVo cart = new CartVo();
		cart.setUserid(userid);
		cart.setIsbn(scan.next().trim());
		cart.setQuantity(1);
		
		System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N");
		String delYN = scan.next();
		if(delYN.equals("Y")) {
			repository.remove(cart);
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
	public void receipt(String userid) {
		
	}
	
	@Override
	public void exit() {
		System.out.println("프로그램이 종료되었습니다. 이용해주셔서 감사합니다.");
		System.exit(0);		
	}


}
