package by.servlet.booking.dao.entity;

public class User {
	private int id;
	private int role;
	private String login;
	private String password;
	
	public User(int id, String login, String password, int role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
		this.role = 0;
	}
	
	public boolean checkPermission() {
		return role > 0;
	}
	
	public int getId() {
		return id;
	}
	
	public int getRole() {
		return role;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
}
