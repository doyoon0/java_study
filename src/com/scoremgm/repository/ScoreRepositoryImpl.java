package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scoremgm.model.MemberVo;

import db.DBConn;
import db.GenericRepositoryInterface;

public class ScoreRepositoryImpl extends DBConn implements GenericRepositoryInterface<MemberVo>{
	
	public ScoreRepositoryImpl() { super(); }
	
	@Override
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = """
				insert into score_member (name, department, kor, eng, math, mdate)
				values (?, ?, ?, ?, ?, curdate()) 
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  member.getName());
			pstmt.setString(2,  member.getDepartment());
			pstmt.setInt(3,  member.getKor());
			pstmt.setInt(4,  member.getEng());
			pstmt.setInt(5,  member.getMath());
			
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
				select count(*) from score_member 
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

	@Override
	public List<MemberVo> findAll() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select 
					row_number() over() as rno
					, mid
					, name
					, department
					, kor
					, eng
					, math
					, mdate
				from score_member
			""";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setRno(rs.getInt(1));
				memberVo.setMid(rs.getString(2));
				memberVo.setName(rs.getString(3));
				memberVo.setDepartment(rs.getString(4));
				memberVo.setKor(rs.getInt(5));
				memberVo.setEng(rs.getInt(6));
				memberVo.setMath(rs.getInt(7));
				memberVo.setMdate(rs.getString(8));
				
				list.add(memberVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MemberVo find(String mid) {
		mid = "M" + mid;
		MemberVo member = new MemberVo();

		String sql = """
				select 
					mid
					, name
					, department
					, kor
					, eng
					, math
					, mdate
				from score_member
				where mid = ?
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  mid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.setMid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setDepartment(rs.getString(3));
				member.setKor(rs.getInt(4));
				member.setEng(rs.getInt(5));
				member.setMath(rs.getInt(6));
				member.setMdate(rs.getString(7));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public int update(MemberVo member) {
		int rows = 0;
		String sql = """
				update score_member set kor = ?, eng = ?, math = ? where mid = ?
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1,  member.getKor());
			pstmt.setInt(2,  member.getEng());
			pstmt.setInt(3,  member.getMath());
			pstmt.setString(4,  member.getMid());
			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int remove(String mid) {
		mid = "M" + mid;
		int rows = 0;
		
		String sql = """
				delete from score_member where mid = ?
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  mid);
			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
}//class
