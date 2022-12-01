package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {

		Project project = null;

		String sql = "SELECT project_id " +
				"	, name " +
				"	, from_date " +
				"	, to_date " +
				"FROM project " +
				"WHERE project_id = ?;";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, projectId);

		if (row.next()){
			project = mapRowToProject(row);
		}
		return project;
	}


	@Override
	public List<Project> getAllProjects() {

		List<Project> projects = new ArrayList<>();

		String sql = "SELECT project_id " +
					" 	, name " +
					" 	, from_date " +
					" 	, to_date " +
					"FROM project";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

		while (row.next()){

			Project project = mapRowToProject(row);
			projects.add(project);
		}

		return projects;

	}

	@Override
	public Project createProject(Project project) {

		String sql = "INSERT INTO project (name, from_date, to_date) " +
				"VALUES (?,?,?) RETURNING project_id;";

		Integer id = jdbcTemplate.queryForObject(sql,
				Integer.class,
				project.getName(),
				project.getFromDate(),
				project.getToDate());

		project.setId(id);
		return project;
	}

	@Override
	public void deleteProject(int projectId) {

		String sql = "DELETE FROM project_employee WHERE project_id = ?; " +
				"DELETE FROM project WHERE project_id = ?;";

		jdbcTemplate.update(sql, projectId, projectId);
	}

	private Project mapRowToProject(SqlRowSet row){

		int projectId = row.getInt("project_id");
		String projectName = row.getString("name");
		Date fromDate = row.getDate("from_date");
		Date toDate = row.getDate("to_date");

		Project project = new Project();
		project.setId(projectId);
		project.setName(projectName);
		if (fromDate != null) project.setFromDate(fromDate.toLocalDate());
		if (toDate != null) project.setToDate(toDate.toLocalDate());

		return project;

	}
	

}
