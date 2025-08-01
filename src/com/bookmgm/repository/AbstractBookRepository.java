package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmgm.model.BookVo;

import db.DBConn;
import db.GenericRepositoryInterface;

public abstract class AbstractBookRepository extends DBConn implements GenericRepositoryInterface<BookVo> {
	protected abstract String getTableName();
	protected abstract String getRepositoryName();
	
	public AbstractBookRepository() {
        System.out.println("** " + getRepositoryName() + " 도서관 생성 완료 **");
    }
	
	@Override
	public int insert(BookVo book) {
		int rows = 0;
		
		String sql = "insert into " 
					+ getTableName() 
					+ " (title, author, price, bdate) values (?, ?, ?, curdate())";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  book.getTitle());
			pstmt.setString(2,  book.getAuthor());
			pstmt.setInt(3,  book.getPrice());
			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public List<BookVo> findAll() {
		List<BookVo> library = new ArrayList<BookVo>();
		String sql = """
				select
					row_number() over() as rno
					, bid
					, title
					, author
					, price
					, isbn
					, left(bdate, 10) from  """;
		sql += " " + getTableName();
		
		// 디버깅 출력
//	    System.out.println("실행할 SQL: [" + sql + "]");
//	    System.out.println("테이블명: [" + getTableName() + "]");
				
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			//rs객체로 null 체크도 가능
			while(rs.next()) {
				BookVo bookVo = new BookVo();
				bookVo.setRno(rs.getInt(1));
				bookVo.setBid(rs.getString(2));
				bookVo.setTitle(rs.getString(3));
				bookVo.setAuthor(rs.getString(4));
				bookVo.setPrice(rs.getInt(5));
				bookVo.setIsbn(rs.getInt(6));
				bookVo.setBdate(rs.getString(7));
				
				library.add(bookVo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return library;
	}

	@Override
	public BookVo find(String bid) {
		bid = "B" + bid;
		BookVo book = new BookVo();

		String sql = """
				select
					row_number() over() as rno
					, bid
					, title
					, author
					, price
					, isbn
					, left(bdate, 10)
				from  """;
		sql += " " + getTableName();
		sql += " where bid = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  bid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book.setRno(rs.getInt(1));
				book.setBid(rs.getString(2));
				book.setTitle(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setIsbn(rs.getInt(6));
				book.setBdate(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public int update(BookVo book) {
		int rows = 0;
		String sql = "update ";
		sql += getTableName();
		sql += " set title = ?, author = ?, price = ? where bid = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  book.getTitle());
			pstmt.setString(2,  book.getAuthor());
			pstmt.setInt(3,  book.getPrice());
			pstmt.setString(4, book.getBid());
			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int remove(String bid) {
		int rows = 0;
		
		String sql = "delete from ";
		sql += getTableName();
		sql += " where bid = ?";
		
		// 디버깅 출력
//	    System.out.println("🔍 삭제 SQL: " + sql);
//	    System.out.println("🔍 삭제할 BID: " + bid);
//	    System.out.println("🔍 테이블명: " + getTableName());
	    
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  bid);
			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int getCount() {
		int rows = 0;
		String sql = """
				select
				(select count(*) from book_aladin) +
				(select count(*) from book_yes24) + 
				(select count(*) from book_tj) as total
			""";
		
		try {
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
}
