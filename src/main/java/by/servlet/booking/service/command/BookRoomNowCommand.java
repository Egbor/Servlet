package by.servlet.booking.service.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.servlet.booking.dao.entity.User;
import by.servlet.booking.service.RoomService;

public class BookRoomNowCommand implements Command {
	private static RoomService service = new RoomService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = (User)request.getSession().getAttribute("currentUser");
		
		int userId = user.getId();
		int roomId = Integer.valueOf(request.getParameter("roomId"));
		
		try {
			if (service.changeRoomReservation(userId, roomId, true)) {
				response.sendRedirect("FrontController?command=SHOW_NOT_RESERVED_ROOMS");
			} else {
				response.sendRedirect("booknow.jsp?message=BOOKING_FAILED");
			}
		} catch (SQLException e) {
			response.sendRedirect("booknow.jsp?message=DAO_ERROR");
		}
	}

}
