package com.bookmgm.repository;

public class InMemoryBookRepositoryImpl extends AbstractBookRepository {
	@Override
    protected String getTableName() {
        return "book_tj";
    }
    
    @Override
    protected String getRepositoryName() {
        return "교육센터";
    }

}
