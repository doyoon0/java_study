package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.AladinBookRepository;
import com.bookmgm.repository.BookRepository;
import com.bookmgm.repository.InMemoryBookRepository;
import com.bookmgm.repository.Yes24BookRepository;

public class DefaultBookService implements BookService {
	BookManagementApplication bma;
	BookRepository repository;
	
	public DefaultBookService() {}
	public DefaultBookService(BookManagementApplication bma) {
		this.bma = bma;
		//repository = new InMemoryBookRepository(); //DefaultBookService 객체가 생성될 때 바로 사용 가능한 상태로 초기화하기 위해서
	}
	
	/**
	 * 도서 출력 - 검색, 수정 시 결과 출력
	 * param book
	 */
	public void printBook(Book book) {
		System.out.println("========================================");
		System.out.println("[" + book.getId() + "] "
				+ book.getTitle() + " - "
				+ book.getAuthor() + ", "
				+ book.getPrice()
				);
		System.out.println("========================================");
	}
	
	public Book createBook() {
		Random rd = new Random();
		Book book = new Book();
		book.setId(String.valueOf(rd.nextInt(1000, 9999)));
		
		System.out.print("도서명> ");
		book.setTitle(bma.scan.next());
		
		System.out.print("저자> ");
		book.setAuthor(bma.scan.next());
		
		System.out.print("가격> ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	/**
	 * 도서관 선택
	 */
	public void selectRepository() {
		System.out.println("========================================");
		System.out.println("1. 교육센터   2. 알라딘   3. 예스24");
		System.out.println("========================================");
		System.out.print("도서관 선택> ");
		int rno = bma.scan.nextInt();
		if(rno == 1) {
			repository = new InMemoryBookRepository();
		} else if(rno == 2) {
			repository = new AladinBookRepository();
		} else if(rno == 3) {
			repository = new Yes24BookRepository();
		}
		
	}

	@Override
	public void register() {
		selectRepository();
		Book book = createBook();
		if(repository.insert(book)) {
			//등록성공
			System.out.println("✅도서가 등록되었습니다.");
		} else {
			//등록실패
			System.out.println("❎도서가 등록되지않았습니다.");
		}
		
		bma.showMenu();
	}

	@Override
	public void list() {
		if(getCount()!=0) {
			List<Book> list = repository.selectAll();
			list.forEach(book -> {
				System.out.println("[" + book.getId() + "] "
						+ book.getTitle() + " - "
						+ book.getAuthor() + ", "
						+ book.getPrice()
						);
			});
		} else {
			System.out.println("🚫등록된 도서가 존재하지 않습니다.");
		}
		
		bma.showMenu();
	}

	@Override
	public void search() {
		if(getCount()!=0) {
			System.out.print("도서번호(4자리) > ");
			Book book = repository.select(bma.scan.next());
			if(book != null ) {
				printBook(book);
			}
		} else {
			System.out.println("🚫등록된 도서가 존재하지 않습니다.");
		}
		
		bma.showMenu();
	}

	/**
	 * Overloading
	 * @param book - old book 정보
	 * 도서 수정시 도서 정보를 일부 수정하여 반환
	 */
	public Book createBook(Book book) {
		
		System.out.print("도서명> ");
		book.setTitle(bma.scan.next());
		
		System.out.print("저자> ");
		book.setAuthor(bma.scan.next());
		
		System.out.print("가격> ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.print("도서번호(4자리) > ");
			Book book = repository.select(bma.scan.next());
			if(book != null) {
				repository.update(createBook(book));
				System.out.println("✅도서가 수정되었습니다.");
				printBook(book);
				
			} else {
				System.out.println("❎도서가 수정되지않았습니다.");
			}
			
		} else {
			System.out.println("🚫등록된 도서가 존재하지 않습니다.");
		}		
		
		bma.showMenu();
	}

	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.print("도서번호(4자리) > ");
			Book book = repository.select(bma.scan.next());
			if(book != null) {
				repository.remove(book);
				System.out.println("✅도서가 삭제되었습니다.");
				printBook(book);
				
			} else {
				System.out.println("❎도서가 삭제되지않았습니다.");
			}
			
		} else {
			System.out.println("🚫등록된 도서가 존재하지 않습니다.");
		}
		
		bma.showMenu();
		
	}

	@Override
	public void exit() {
		System.out.println("💬시스템이 종료됩니다.");
		System.exit(0);
	}

	@Override
	public int getCount() {
		if(repository == null) return 0;
		return repository.getCount();
	}
	
}
