package chapter20_JDBC;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class DepartmentDao extends DBConn{
	
		public DepartmentDao() {
			super();
		}
		
		public boolean insert(DepartmentVo insertVo) {
			boolean result = false;
			try {
				String sql = 
						"""
						insert into department(dept_id, dept_name, unit_id, start_date) 
										values(?, ?, ?, curdate())
						""";
				
				getPreparedStatement(sql);
				pstmt.setString(1, insertVo.getDeptId());
				pstmt.setString(2, insertVo.getDeptName());
				pstmt.setString(3, insertVo.getUnitId());
				
				int resultRow = pstmt.executeUpdate();
				if(resultRow == 1) {
					result = true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
	
		/**
		 * 전체 리스트
		 */
		public List<DepartmentVo> getList() {
			List<DepartmentVo> list = new ArrayList<DepartmentVo>();
			String sql = """
						select 
							dept_id
							, dept_name
							, unit_id
							, start_date
						from department
					""";
			try {
				
				getStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					//rs 객체의 1 row --> DepartmentVo에 담는다
					DepartmentVo department = new DepartmentVo();
					department.setDeptId(rs.getString(1));
					department.setDeptName(rs.getString(2));
					department.setUnitId(rs.getString(3));
					department.setStartDate(rs.getString(4));
					
					list.add(department);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
	
}
