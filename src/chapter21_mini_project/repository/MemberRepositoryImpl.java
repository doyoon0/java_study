package chapter21_mini_project.repository;

import chapter21_mini_project.model.MemberVo;
import db.DBConn;

public class MemberRepositoryImpl extends DBConn implements MemberRepository{
	
	public MemberRepositoryImpl() { super(); }
	
	@Override
	public int memberCheck(MemberVo member) {
		int rows = 0;
		String sql = "select userid from book_market_member where username = ? and phone = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPhone());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString("userid");
				member.setUserid(userid);
				rows = 1;
			} else {
				rows = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}


}
