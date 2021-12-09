package by.servlet.booking.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.servlet.booking.dao.entity.User;
import by.servlet.booking.dao.database.DatabaseConnection;

public class UserDAO {
	private static final String ADD_USER_QUERY = "INSERT INTO users (login, password) VALUES (?, ?)";
	private static final String SELECT_USER_BY_LOGIN_QUERY = "SELECT * FROM users WHERE login=?";
	private static final String SELECT_USER_BY_STATUS_QUERY = "SELECT * FROM users WHERE role=?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM users";
	
	public boolean addUser(User user) throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ADD_USER_QUERY);
		
		preparedStatement.setString(1, user.getLogin());
		preparedStatement.setString(2, user.getPassword());
		
		return preparedStatement.executeUpdate() != 0;
	}
	
	public User getUserByStatus(int status) throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(SELECT_USER_BY_STATUS_QUERY);
		
		preparedStatement.setInt(1, status);
		
		ResultSet result = preparedStatement.executeQuery();
		if (!result.next()) {
			return null;
		}
		return new User(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
	}
	
	public User getUserByLogin(String login) throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(SELECT_USER_BY_LOGIN_QUERY);
		
		preparedStatement.setString(1, login);
		
		ResultSet result = preparedStatement.executeQuery();
		if (!result.next()) {
			return null;
		}
		return new User(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
	}
	
	public List<User> getAllUsers() throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(SELECT_ALL_QUERY);
		ResultSet result = preparedStatement.executeQuery();
		
		List<User> users = new ArrayList<User>();
		while(result.next()) {
			users.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4)));
		}
		
		return users;
	}
}
