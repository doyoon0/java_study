package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.Member;
import com.scoremgm.repository.ScoreRepository;
import com.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService{
	Scanner scan;
	ScoreRepository repository = new ScoreRepositoryImpl();
	ScoreMgmSystem sms;
	
	public ScoreServiceImpl() {}
	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.scan = sms.scan;
		this.sms = sms;
	}
	/**
	 * 학생정보 저장소(storage)의 갯수 가져오기
	 */
	public int getCount() {
		return repository.getCount();
	}

	/**
	 * 학생 정보 임시 저장 객체 생성(1)
	 * @return List
	 */
	 public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"}; 
		List memberInfo = new ArrayList();
		 
		//학번 생성 : 2025-랜덤4자리
		Random rd = new Random();
	 	String no ="2025-" + rd.nextInt(1000, 9999);
	 	memberInfo.add(no);
	 	
	 	for(int i=0; i<labels.length; i++) {
	 		if(i>=2) {
	 			System.out.print(labels[i] + "> ");
	 			memberInfo.add(scan.nextInt());
	 		} else {
	 			//i=0, 1
	 			System.out.print(labels[i] + "> ");
	 			memberInfo.add(scan.next());
	 		}
	 	}
	 	
	    return memberInfo; 
	 }
	 
		/**
		 * 학생 정보 임시 저장 객체 생성(2) overloading
		 * @param no 학번
		 * @return List
		 */
		 public List createMemberInfo(Member member) {
			String[] labels = {"국어", "영어", "수학"}; 
			List memberInfo = new ArrayList();
			
			System.out.println("학번 : " + member.getNo() + "," + "학생명 : " + member.getName());
		 	
		 	for(int i=0; i<labels.length; i++) {
	 			System.out.print(labels[i] + "> ");
	 			memberInfo.add(scan.nextInt());
		 	}
		 	
		    return memberInfo; 
		 }
	
	//학생등록
	@Override
	public void register() {
		List memberInfo = createMemberInfo();
		//Member 생성
		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		//저장소 등록을 위한 Repository 호출
		if(repository.insert(member)) {
			//성공
			System.out.println("=> 등록 완료!! 전체학생 : " + getCount());
		} else {
			//실패
			System.out.println("=> 등록 실패!!");
			
		}
		
		//메뉴호출!!
		sms.showMenu();
		sms.selectMenu();
	}

	@Override
	public void list() {
		if(getCount() != 0) {
			List<Member> list = repository.findAll();
			System.out.println("------------------------------------------------------");
			System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
			System.out.println("------------------------------------------------------");
			list.forEach(member -> {
				System.out.print(member.getNo() + "  \t");
				System.out.print(member.getName() + "  \t");
				System.out.print(member.getDepartment() + "  \t");
				System.out.print(member.getKor() + "  \t");
				System.out.print(member.getEng() + "  \t");
				System.out.print(member.getMath() + " \n");
			});
			System.out.println("------------------------------------------------------");
		} else {
			System.out.println("=> 등록된 학생이 없습니다. ");
		}
		sms.showMenu();
		sms.selectMenu();
	}

	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.print("학번(뒤4자리) > ");
			String no = scan.next();
			Member member = repository.find(no);
			if(member != null) {
				System.out.println("------------------------------------------------------");
				System.out.println("\t학생정보 검색 결과");
				System.out.println("------------------------------------------------------");
				System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
				System.out.println("------------------------------------------------------");
				System.out.print(member.getNo() + "  \t");
				System.out.print(member.getName() + "  \t");
				System.out.print(member.getDepartment() + "  \t");
				System.out.print(member.getKor() + "  \t");
				System.out.print(member.getEng() + "  \t");
				System.out.print(member.getMath() + " \n");
				System.out.println("------------------------------------------------------");
			} else {
				System.out.println("=> 학생 정보 없음!");
			}
			
		} else {
			System.out.println("=> 등록된 학생이 없습니다. ");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.print("학번(뒤4자리) > ");
			String no = scan.next();
			Member member = repository.find(no);  //학생 정보 - old
			if(member != null) {
				//수정할 학생 정보 입력!! 학번 제외!!
				List memberInfo = createMemberInfo(member);
				member.setKor((int)memberInfo.get(0));
				member.setEng((int)memberInfo.get(1));
				member.setMath((int)memberInfo.get(2));
				
				//storage에 member 업데이트
				repository.update(member);
				
				List<Member> list = repository.findAll();
				System.out.println("------------------------------------------------------");
				System.out.println("\t학생정보 수정 결과");
				System.out.println("------------------------------------------------------");
				System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
				System.out.println("------------------------------------------------------");
				System.out.print(member.getNo() + "  \t");
				System.out.print(member.getName() + "  \t");
				System.out.print(member.getDepartment() + "  \t");
				System.out.print(member.getKor() + "  \t");
				System.out.print(member.getEng() + "  \t");
				System.out.print(member.getMath() + " \n");
				System.out.println("------------------------------------------------------");
				
			} else {
				System.out.println("=> 학생 정보 없음!");
			}
			
		} else {
			System.out.println("=> 등록된 학생이 없습니다. ");
		}
		sms.showMenu();
		sms.selectMenu();
	}

	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.print("학번(뒤4자리) > ");
			String no = scan.next();
			Member member = repository.find(no);  //학생 정보 - old
			
			if(member != null) {
				System.out.print("정말로 삭제하시겠습니까?(y/n) > ");
				if(scan.next().equals("y")) {
					repository.remove(no);
					List<Member> list = repository.findAll();
					System.out.println("------------------------------------------------------");
					System.out.println("\t학생정보 삭제 결과");
					System.out.println("------------------------------------------------------");
					System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
					System.out.println("------------------------------------------------------");
					System.out.print(member.getNo() + "  \t");
					System.out.print(member.getName() + "  \t");
					System.out.print(member.getDepartment() + "  \t");
					System.out.print(member.getKor() + "  \t");
					System.out.print(member.getEng() + "  \t");
					System.out.print(member.getMath() + " \n");
					System.out.println("------------------------------------------------------");
				} else if (scan.next().equals("n")) {
					sms.showMenu();
					sms.selectMenu();
				} else {
					System.out.println("잘못된 입력입니다. y 혹은 n을 입력해주세요.");
					delete();
				}
			}
			
		} else {
			System.out.println("=> 등록된 학생이 없습니다. ");
		}
		sms.showMenu();
		sms.selectMenu();
	}

	@Override
	public void exit() {
		System.out.println("=> 프로그램 종료!!");
		System.exit(0);
	}

}
