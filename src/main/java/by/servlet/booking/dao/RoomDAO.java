package by.servlet.booking.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.servlet.booking.dao.entity.Room;
import by.servlet.booking.dao.database.DatabaseConnection;

public class RoomDAO {
	private static final String SELECT_ALL_QUERY = "SELECT * FROM rooms";
	private static final String SELECT_BY_USER_ID_QUERY = "SELECT * FROM rooms WHERE user_id=?";
	private static final String SELECT_BY_RESERVATION_QUERY = "SELECT * FROM rooms WHERE is_reserved=?";
	private static final String UPDATE_ROOM_RESERVATION = "UPDATE rooms SET is_reserved=?, user_id=? WHERE id=?";
	
	public List<Room> getAllRooms() throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(SELECT_ALL_QUERY);
		ResultSet result = preparedStatement.executeQuery();
		
		List<Room> rooms = new ArrayList<Room>();
		while(result.next()) {
			rooms.add(new Room(result.getInt(1), result.getInt(2), result.getString(3), result.getBoolean(4)));
		}
		
		return rooms;
	}
	
	public List<Room> getRoomsByUserId(int userId) throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(SELECT_BY_USER_ID_QUERY);
		
		preparedStatement.setInt(1, userId);
		
		ResultSet result = preparedStatement.executeQuery();
		
		List<Room> rooms = new ArrayList<Room>();
		while(result.next()) {
			rooms.add(new Room(result.getInt(1), result.getInt(2), result.getString(3), result.getBoolean(4)));
		}
		
		return rooms;
	}
	
	public List<Room> getRoomsByReservation(boolean reservation) throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(SELECT_BY_RESERVATION_QUERY);
		
		preparedStatement.setBoolean(1, reservation);
		
		ResultSet result = preparedStatement.executeQuery();
		List<Room> rooms = new ArrayList<Room>();
		while(result.next()) {
			rooms.add(new Room(result.getInt(1), result.getInt(2), result.getString(3), result.getBoolean(4)));
		}
		
		return rooms;
	}
	
	public boolean changeRoomReservation(int userId, int roomId, boolean reservation) throws SQLException {
		Connection dbConnection =  DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_ROOM_RESERVATION);
		
		preparedStatement.setBoolean(1, reservation);
		preparedStatement.setInt(2, userId);
		preparedStatement.setInt(3, roomId);
		
		return preparedStatement.executeUpdate() != 0;
	}
}
