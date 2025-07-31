package member;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class MemberDao extends DBConn implements GenericInterface<MemberVo> {
	
	public MemberDao() {
		super(); //부모인 DBConn이 가지고있는 생성자들 호출
	}
	
	//CRUD 기능 구현 - 애플리케이션 기반의 DB연동은 기본적으로 Autocommit = ture 임, 바로 적용됨!!
	/**
	 * 전체 리스트
	 */
	@Override
	public List<MemberVo> listAll() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select 
					row_number() over() as rno
					, member_id
					, name
					, email
					, left(created_at, 10)
				from member
			""";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setRno(rs.getInt(1));
				memberVo.setMemberId(rs.getInt(2));
				memberVo.setName(rs.getString(3));
				memberVo.setEmail(rs.getString(4));
				memberVo.setCreatedAt(rs.getString(5));
				
				list.add(memberVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 데이터 추가
	 * @param memberVo
	 */
	@Override
	public int insert(MemberVo memberVo) {
		int result = 0;
		String sql = """
				insert into member (member_id, name, email, created_at)
				values (?, ?, ?, curdate()) 
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1,  memberVo.getMemberId());
			pstmt.setString(2,  memberVo.getName());
			pstmt.setString(3,  memberVo.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 데이터 수정
	 */
	@Override
	public int update(MemberVo memberVo) {
		int result = 0;
		String sql = """
				update member set name = ?, email = ? where member_id = ?
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  memberVo.getName());
			pstmt.setString(2,  memberVo.getEmail());
			pstmt.setInt(3,  memberVo.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 데이터 삭제
	 */
	@Override
	public int delete(int memberId) {
		int result = 0;
		String sql = """
				delete from member where member_id = ?
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1,  memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 데이터 검색 (1)
	 */
	@Override
	public MemberVo search(int memberId) {
		MemberVo member = new MemberVo();
		
		String sql = """
				select 
					row_number() over() as rno
					, member_id
					, name
					, email
					, created_at
				from member
				where member_id = ?
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1,  memberId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.setRno(rs.getInt(1));
				member.setMemberId(rs.getInt(2));
				member.setName(rs.getString(3));
				member.setEmail(rs.getString(4));
				member.setCreatedAt(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	/**
	 * 데이터 검색 (2)
	 */
	@Override
	public List<MemberVo> search(String name) {
		List<MemberVo> list = new ArrayList<MemberVo>();

		String sql = """
				select 
					row_number() over() as rno
					, member_id
					, name
					, email
					, created_at
				from member
				where name = ?
			""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,  name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setRno(rs.getInt(1));
				memberVo.setMemberId(rs.getInt(2));
				memberVo.setName(rs.getString(3));
				memberVo.setEmail(rs.getString(4));
				memberVo.setCreatedAt(rs.getString(5));
				
				list.add(memberVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
