package com.bookmgm.repository;

public class Yes24BookRepositoryImpl extends AbstractBookRepository {
	@Override
    protected String getTableName() {
        return "book_yes24";
    }
    
    @Override
    protected String getRepositoryName() {
        return "예스24";
    }

}
