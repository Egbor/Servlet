package by.servlet.booking.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.sql.SQLException;

import by.servlet.booking.dao.entity.User;
import by.servlet.booking.dao.UserDAO;

public class UserService extends Service {
	private static UserDAO dao = new UserDAO();
	
	public boolean addUser(User user) throws SQLException {
		try {
			return executorService.submit(() -> dao.addUser(user)).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUserByStatus(int status) throws SQLException {
		try {
			return executorService.submit(() -> dao.getUserByStatus(status)).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserByLogin(String login) throws SQLException {
		try {
			return executorService.submit(() -> dao.getUserByLogin(login)).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getAllUsers() throws SQLException {
		try {
			return executorService.submit(() -> dao.getAllUsers()).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
