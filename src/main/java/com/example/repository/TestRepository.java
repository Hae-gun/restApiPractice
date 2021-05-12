package com.example.repository;

import java.sql.SQLException;

public interface TestRepository {
	public String getUser(String name) throws SQLException;
	public void makeTable() throws SQLException;
}
