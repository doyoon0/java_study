package com.bookmgm.repository;

import java.util.List;

import com.bookmgm.model.BookVo;

public interface BookRepository {
	boolean insert(BookVo book);
	List<BookVo> selectAll();
	BookVo select(String id);
	void update(BookVo book);
	void remove(String id);
	void remove(BookVo book);
	int getCount();
}
