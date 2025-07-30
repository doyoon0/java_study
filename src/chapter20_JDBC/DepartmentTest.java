package chapter20_JDBC;

import java.util.List;

public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();
		DepartmentVo insertVo = new DepartmentVo();
		
		// 1. 데이터 먼저 설정하고 삽입
		insertVo.setDeptId("CAT");
		insertVo.setDeptName("테스트");
		insertVo.setUnitId("C");
		
		// 2. insert 결과 true 일 때만 List 출력
		if(dao.insert(insertVo)) {
			List<DepartmentVo> list = dao.getList();
			list.forEach((department) -> {
				System.out.print(department.getDeptId() + "\t");
				System.out.print(department.getDeptName() + "\t");
				System.out.print(department.getUnitId() + "\t");
				System.out.print(department.getStartDate() + "\n");
			});
		}
		
		dao.close();
	}

}
