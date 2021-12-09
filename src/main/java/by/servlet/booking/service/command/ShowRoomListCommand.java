package by.servlet.booking.service.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.servlet.booking.dao.entity.Room;
import by.servlet.booking.dao.entity.User;
import by.servlet.booking.service.RoomService;

public class ShowRoomListCommand implements Command {
	private static RoomService service = new RoomService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = (User)request.getSession().getAttribute("currentUser");
		if (user.checkPermission()) {
			executeForAdmin(request, response);
		} else {
			executeForUser(user, request, response);
		}
	}
	
	private void executeForUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			List<Room> rooms = service.getRoomsByUserId(user.getId());
			request.setAttribute("rooms", rooms);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("user.jsp?message=DAO_ERROR");
		} catch (ServletException e) {
			response.sendRedirect("user.jsp?message=SERVLET_ERROR");
		}
	}
	
	private void executeForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			List<Room> rooms = service.getAllRooms();
			if (rooms.size() != 0) {
				request.setAttribute("rooms", rooms);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			} else {
				response.sendRedirect("admin.jsp?message=DAO_FAILED");
			}
		} catch (SQLException e) {
			response.sendRedirect("admin.jsp?message=DAO_ERROR");
		} catch (ServletException e) {
			response.sendRedirect("admin.jsp?message=SERVLET_ERROR");
		}
	}
}
