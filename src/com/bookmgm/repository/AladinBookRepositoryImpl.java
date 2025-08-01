package com.bookmgm.repository;

public class AladinBookRepositoryImpl extends AbstractBookRepository {
	
	@Override
    protected String getTableName() {
        return "book_aladin";
    }
    
    @Override
    protected String getRepositoryName() {
        return "알라딘";
    }

}
