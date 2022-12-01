package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT employee_id " +
					"	, department_id " +
					" 	, first_name " +
					" 	, last_name " +
					" 	, birth_date " +
					"	, hire_date " +
					"FROM employee;";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

		while(row.next()){

			Employee employee = mapRowToEmployee(row);
			employees.add(employee);
		}

		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {

		List<Employee> employees = new ArrayList<>();
		
		SqlRowSet row = null;

		if (firstNameSearch == null && lastNameSearch == null) getAllEmployees();

		String sql = "SELECT employee_id " +
				"	, department_id " +
				" 	, first_name " +
				" 	, last_name " +
				" 	, birth_date " +
				"	, hire_date " +
				"FROM employee ";
		if (firstNameSearch == null) {
			sql += " WHERE last_name ILIKE '%?%';";
			row = jdbcTemplate.queryForRowSet(sql, lastNameSearch);
		}
		else if (lastNameSearch == null) {
			sql += " WHERE first_name ILIKE '%?%';";
			row = jdbcTemplate.queryForRowSet(sql, firstNameSearch);
		}
		else {
			sql += " WHERE first_name ILIKE '%?%' HAVING last_name ILIKE '%?%';";
			row = jdbcTemplate.queryForRowSet(sql, firstNameSearch, lastNameSearch);
		}

		while(row.next()){

			Employee employee = mapRowToEmployee(row);
			employees.add(employee);
		}

		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {

		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT employee_id " +
				"	, department_id " +
				"	, first_name " +
				"	, last_name " +
				"	, birth_date " +
				"	, hire_date " +
				"FROM employee AS e " +
				"RIGHT JOIN project_employee AS pe" +
				"	ON e.employee_id = pe.employee_id " +
				"WHERE pe.project_id = ?;"
				;

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, projectId);

		while(row.next()){

			Employee employee = mapRowToEmployee(row);
			employees.add(employee);
		}

		return employees;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {

		String sql = "INSERT INTO project_employee (project_id, employee_id) " +
				"VALUES (?,?);";

		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {

		String sql = "DELETE FROM project_employee WHERE project_id = ? HAVING employee_id = ?;";

		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {

		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT employee_id " +
				"	, department_id " +
				" 	, first_name " +
				" 	, last_name " +
				" 	, birth_date " +
				"	, hire_date " +
				"FROM employee AS e " +
				"LEFT JOIN project_employee AS pe" +
				"	ON e.employee_id = pe.employee_id " +
				"WHERE pe.project_id = null;";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

		while (row.next()){

			Employee employee = mapRowToEmployee(row);
			employees.add(employee);
		}
		return employees;
	}


	private Employee mapRowToEmployee(SqlRowSet row){

		int employeeId = row.getInt("employee_id");
		int departmentId = row.getInt("department_id");
		String firstName = row.getString("first_name");
		String lastName = row.getString("last_name");
		Date birthDate = row.getDate("birth_date");
		Date hireDate = row.getDate("hire_date");

		Employee employee = new Employee();
		employee.setId(employeeId);
		employee.setDepartmentId(departmentId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		if (birthDate != null) employee.setBirthDate(birthDate.toLocalDate());
		if (hireDate != null) employee.setHireDate(hireDate.toLocalDate());

		return employee;
	}

}
