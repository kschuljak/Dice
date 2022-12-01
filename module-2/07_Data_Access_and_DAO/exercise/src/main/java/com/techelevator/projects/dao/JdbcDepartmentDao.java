package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int departmentId) {

		Department department = null;

		String sql = "SELECT department_id " +
					"	, name " +
					"FROM department " +
					"WHERE department_id = ?;";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, departmentId);

		if (row.next()) {
			department = mapRowToDepartment(row);
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {

		List<Department> departments = new ArrayList<>();

		String sql = "SELECT department_id " +
					"	, name " +
					"FROM department;";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

		while (row.next()){

			Department department = mapRowToDepartment(row);
			departments.add(department);
		}
		return departments;
	}

	@Override
	public void updateDepartment(Department department) {

		String sql = "UPDATE department " +
					"SET name = ? " +
					"WHERE department_id = ? ";

		jdbcTemplate.update(sql,
					department.getName(),
					department.getId());

	}

	private Department mapRowToDepartment(SqlRowSet row){

		int departmentId = row.getInt("department_id");
		String departmentName = row.getString("name");

		Department department = new Department();

		department.setId(departmentId);
		department.setName(departmentName);

		return department;
	}

}
