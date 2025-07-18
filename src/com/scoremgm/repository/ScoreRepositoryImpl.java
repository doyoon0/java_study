package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
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

	@Override
	public Member find(String no) {
		no = "2025-" + no;
		Member member = null;
		
		if(no != null) {
			for(Member m : storage) {
				if(m.getNo().equals(no)) {
					member = m;
				}
			}
			//forEach는 메소드 호출이므로 stack에 새로운 블록으로 생성되어 실행됨!!
			//그러므로 전에 실행중이던 find는 일시 중지가 되고 forEach로 주도권이 넘어오므로 find의 member는 사라진다
//			storage.forEach(m -> {  
//				if(m.getNo().equals(no)) member = m;
//			});
		}
		
		return member;
	}

	@Override
	public void update(Member member) {
		int idx = -1;
		for(int i=0; i<storage.size(); i++) {
			Member m = storage.get(i);
			if(m.getNo() == member.getNo()) {
				idx = i;
				break;
			}
		}
		storage.set(idx, member);
	}

	@Override
	public void remove(String no) {
		no = "2025-" + no;
		Iterator<Member> ie = storage.iterator();
		while(ie.hasNext()) {
			Member member = ie.next();
			if(member.getNo().equals(no)) {
				ie.remove();
				break;
			}
		}
	}
	
}//class
