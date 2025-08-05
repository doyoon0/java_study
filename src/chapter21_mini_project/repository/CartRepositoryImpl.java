package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import db.DBConn;

public class CartRepositoryImpl extends DBConn implements CartRepository{
	
	public CartRepositoryImpl() { super(); }
	
	@Override
	public List<CartVo> menuCartItemList(String userid) {
		List<CartVo> list = new ArrayList<CartVo>();
		String sql = """
				select
					c.isbn
					, c.userid
					, c.quantity
					, (c.quantity * b.price) as total
				from book_market_cart c
				inner join book_market_books b 
				on c.isbn = b.isbn
				where userid = ?
				""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartVo cartVo = new CartVo();
				cartVo.setIsbn(rs.getString(1));
				cartVo.setUserid(rs.getString(2));
				cartVo.setQuantity(rs.getInt(3));				cartVo.setTotal(rs.getInt(4));				
				list.add(cartVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int menuCartClear(String userid) {
		int rows = 0;
		
		String sql = """
				delete from book_market_cart where userid = ?
				""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, userid);
			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int menuCartAddItem(CartVo cartvo) {
		int rows = 0;
		
		// 1. 먼저 기존 데이터 확인 
		String selectSql = """
				select quantity from book_market_cart where userid = ? and isbn = ?
				""";
		
		// 2. 기존 데이터가 있으면 quantity + 1 로 업데이트
		String updateSql = """
				update book_market_cart set quantity = quantity + 1 where userid = ? and isbn = ?
				""";
		
		// 3. 기존 데이터 없으면 새로 insert
		String insertSql = """
				insert into book_market_cart (isbn, userid, quantity) values ( ?, ?, 1 )
				""";
		try {
			// 기존 데이터 확인
			getPreparedStatement(selectSql);
			pstmt.setString(1, cartvo.getUserid());
			pstmt.setString(2, cartvo.getIsbn());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 기존 데이터 존재
				getPreparedStatement(updateSql);
				pstmt.setString(1, cartvo.getUserid());
				pstmt.setString(2, cartvo.getIsbn());
	            rows = pstmt.executeUpdate();
			} else {
				// 없으면 새로 추가
				getPreparedStatement(insertSql);
				pstmt.setString(1, cartvo.getIsbn());
	            pstmt.setString(2, cartvo.getUserid());
	            rows = pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	

	@Override
	public List<BookVo> bookListAll() {
		List<BookVo> list = new ArrayList<BookVo>();
		
		String sql = """
				select isbn, title, price, author, detail, publisher, bdate from book_market_books
				""";
		
		try {
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVo bookVo = new BookVo();
				bookVo.setIsbn(rs.getString(1));
				bookVo.setTitle(rs.getString(2));
				bookVo.setPrice(rs.getInt(3));
				bookVo.setAuthor(rs.getString(4));
				bookVo.setDetail(rs.getString(5));
				bookVo.setPublisher(rs.getString(6));
				bookVo.setBdate(rs.getString(7));
				
				list.add(bookVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int menuCartRemoveItemCount(CartVo cartvo) {
		int rows = 0;
		
		// 1. 먼저 기존 데이터 확인 
		String selectSql = """
				select quantity from book_market_cart where userid = ? and isbn = ?
				""";
		
		// 2. 기존 데이터가 있으면 quantity - 1 로 업데이트
		String updateSql = """
				update book_market_cart set quantity = quantity - 1 where userid = ? and isbn = ? and quantity > 1
				""";
				
		try {
			// 기존 데이터 확인
			getPreparedStatement(selectSql);
			pstmt.setString(1, cartvo.getUserid());
			pstmt.setString(2, cartvo.getIsbn());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 기존 데이터 존재
				getPreparedStatement(updateSql);
				pstmt.setString(1, cartvo.getUserid());
				pstmt.setString(2, cartvo.getIsbn());
	            rows = pstmt.executeUpdate();
	            
	            if(rows == 0) {
	            	System.out.println("수량이 1이하로 감소 할 수 없습니다.");
	            }
			} else {
				System.out.println("장바구니에 해당 도서가 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int menuCartRemoveItem(CartVo cartvo) {
		int rows = 0;
		String sql = """
				delete from book_market_cart where userid = ? and isbn = ?
				""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, cartvo.getUserid());
			pstmt.setString(2, cartvo.getIsbn());
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	
}
