package com.techelevator.projects.dao;

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
		return new Project(0, "Not Implemented Yet", null, null);
	}

	@Override
	public List<Project> getAllProjects() {
		return new ArrayList<>();
	}

	@Override
	public Project createProject(Project newProject) {
		return null;
	}

	@Override
	public void deleteProject(int projectId) {

	}
	

}
