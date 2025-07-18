package com.scoremgm.repository;

import java.util.List;

import com.scoremgm.model.Member;

public interface ScoreRepository {
	boolean insert(Member member);
	int getCount();
	List<Member> findAll();
	Member find(String no);
	void update(Member member);
	void remove(String no);
}
