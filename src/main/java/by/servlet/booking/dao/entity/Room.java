package by.servlet.booking.dao.entity;

public class Room {
	private int id;
	private int userId;
	private boolean isReserved;
	private String number;
	
	public Room(int id, int userId, String number, boolean isReserved) {
		this.id = id;
		this.userId = userId;
		this.number = number;
		this.isReserved = isReserved;
	}
	
	public Room(int userId, String number, boolean isReserved) {
		this.userId = userId;
		this.number = number;
		this.isReserved = isReserved;
	}
	
	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getNumber() {
		return number;
	}
	
	public boolean checkReservation() {
		return isReserved;
	}
}
