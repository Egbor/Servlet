package by.servlet.booking.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.sql.SQLException;

import by.servlet.booking.dao.entity.Room;
import by.servlet.booking.dao.RoomDAO;

public class RoomService extends Service {
	private static RoomDAO dao = new RoomDAO();
	
	public List<Room> getAllRooms() throws SQLException {
		try {
			return executorService.submit(() -> dao.getAllRooms()).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Room> getRoomsByUserId(int userId) throws SQLException {
		try {
			return executorService.submit(() -> dao.getRoomsByUserId(userId)).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Room> getRoomByReservation(boolean reservation) throws SQLException {
		try {
			return executorService.submit(() -> dao.getRoomsByReservation(reservation)).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean changeRoomReservation(int userId, int roomId, boolean reservation) throws SQLException {
		try {
			return executorService.submit(() -> dao.changeRoomReservation(userId, roomId, reservation)).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return false;
	}
}
