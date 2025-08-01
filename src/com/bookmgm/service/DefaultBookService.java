package com.bookmgm.service;

import java.util.List;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.BookVo;
import com.bookmgm.repository.AladinBookRepositoryImpl;
import com.bookmgm.repository.InMemoryBookRepositoryImpl;
import com.bookmgm.repository.Yes24BookRepositoryImpl;

import db.GenericRepositoryInterface;

public class DefaultBookService implements BookService {
	BookManagementApplication bma;
	GenericRepositoryInterface<BookVo> repository;
	
	public DefaultBookService() {}
	public DefaultBookService(BookManagementApplication bma) {
		this.bma = bma;
		//repository = new InMemoryBookRepository(); //DefaultBookService 객체가 생성될 때 바로 사용 가능한 상태로 초기화하기 위해서
	}
	
	/**
	 * 도서 출력 - 검색, 수정 시 결과 출력
	 * param book
	 */
	public void printBook(BookVo book) {
		System.out.println();
        System.out.println("📚═══════════════════════════════════════════════════════════════════════════📚");
        System.out.println("                            📖 검색 결과 📖");
        System.out.println("📚═══════════════════════════════════════════════════════════════════════════📚");
        System.out.println("순번\t도서ID\t제목\t저자\t가격\tISBN\t등록일");
        System.out.println("──────────────────────────────────────────────────────────────────────────────");
        
        // 도서 목록 출력
        System.out.print(
                        book.getRno()+ "\t" +
                        book.getBid()+ "\t" +
                        book.getTitle()+ "\t" +
                        book.getAuthor()+ "\t" +
                        book.getPrice()+ "\t" +
                        String.valueOf(book.getIsbn())+ "\t" +
                        book.getBdate()+ "\n\n"
        );
	}
	
	public BookVo createBook() {
		BookVo book = new BookVo();
		
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
			repository = new InMemoryBookRepositoryImpl();
		} else if(rno == 2) {
			repository = new AladinBookRepositoryImpl();
		} else if(rno == 3) {
			repository = new Yes24BookRepositoryImpl();
		} else {
		repository = new AladinBookRepositoryImpl();
		}
	}

	@Override
	public void register() {
		BookVo book = createBook();
		if(repository.insert(book) != 0) {
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
			List<BookVo> list = repository.findAll();
			// 헤더 출력
	        System.out.println();
	        System.out.println("📚═══════════════════════════════════════════════════════════════════════════📚");
	        System.out.println("                            📖 도서 목록 📖");
	        System.out.println("📚═══════════════════════════════════════════════════════════════════════════📚");
	        System.out.println("순번\t도서ID\t제목\t저자\t가격\tISBN\t등록일");
	        System.out.println("──────────────────────────────────────────────────────────────────────────────");
	        
	        // 도서 목록 출력
	        list.forEach(book -> {
	            System.out.print(
	                            book.getRno()+ "\t" +
	                            book.getBid()+ "\t" +
	                            book.getTitle()+ "\t" +
	                            book.getAuthor()+ "\t" +
	                            book.getPrice()+ "\t" +
	                            String.valueOf(book.getIsbn())+ "\t" +
	                            book.getBdate()+ "\n\n"
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
			System.out.print("도서번호(3자리) > ");
			BookVo book = repository.find(bma.scan.next());
			if(book.getBid() != null ) {
				printBook(book);
			}
		} else {
			System.out.println("🚫등록된 도서가 존재하지 않습니다.");
		}
		
		bma.showMenu();
	}
	
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.print("도서번호(3자리) > ");
			String bidInput = bma.scan.next();
	        BookVo book = repository.find(bidInput);
            
			if(book.getBid() != null) {
				BookVo updatedBook = createBook();
				book.setTitle(updatedBook.getTitle());
				book.setAuthor(updatedBook.getAuthor());
				book.setPrice(updatedBook.getPrice());
				
				repository.update(book);
				System.out.println("✅도서가 수정되었습니다.");
				BookVo refreshedBook = repository.find(bidInput);
				printBook(refreshedBook);
				
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
			System.out.print("도서번호(3자리) > ");
			BookVo book = repository.find(bma.scan.next());
			if(book.getBid() != null) {
				repository.remove(book.getBid());
				System.out.println("✅도서가 삭제되었습니다.");
				
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
		repository.close();
		System.exit(0);
	}

	@Override
	public int getCount() {
		return repository.getCount();
	}
	
}
