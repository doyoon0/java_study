package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository{
	List<Member> storage = new ArrayList<Member>();
	
	@Override
	public boolean insert(Member member) {
		if(member == null) return false;
		return storage.add(member);
		
	}

	@Override
	public int getCount() {
		return storage.size();
	}

	@Override
	public List<Member> findAll() {
		return storage;
	}

}
