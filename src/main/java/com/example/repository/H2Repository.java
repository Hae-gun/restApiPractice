package com.example.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class H2Repository implements TestRepository {

	private Connection connection;
	private Statement statement;
	
	@Autowired
	DataSource dataSource;
	
	public H2Repository() throws SQLException {
		 connection = dataSource.getConnection();
		 statement = connection.createStatement();
	}
	@Override
	public void makeTable() throws SQLException {
		String sql1 = "CREATE TABLE TESTTABLE(ID INTEGER NOT NULL, VALUE VARCHAR(255), PRIMARY KEY (ID) )";
		statement.executeUpdate(sql1);
		String sql2 = "INSERT INTO TESTTABLE VALUES(1, 'value')";
		statement.execute(sql2);
	}
	@Override
	public String getUser(String name) throws SQLException {
		 
		return null;
	}
}
