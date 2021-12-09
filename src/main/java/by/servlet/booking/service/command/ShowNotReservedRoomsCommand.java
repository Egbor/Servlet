package by.servlet.booking.service.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.servlet.booking.dao.entity.Room;
import by.servlet.booking.service.RoomService;

public class ShowNotReservedRoomsCommand implements Command {
	private static RoomService service = new RoomService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			List<Room> rooms = service.getRoomByReservation(false);
			request.setAttribute("rooms", rooms);
			request.getRequestDispatcher("booknow.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("booknow.jsp?message=DAO_ERROR");
		} catch (ServletException e) {
			response.sendRedirect("booknow.jsp?message=SERVLET_ERROR");
		}
	}

}
