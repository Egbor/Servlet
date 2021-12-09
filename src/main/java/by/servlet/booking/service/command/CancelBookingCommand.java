package by.servlet.booking.service.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.servlet.booking.dao.entity.User;
import by.servlet.booking.service.RoomService;
import by.servlet.booking.service.UserService;

public class CancelBookingCommand implements Command {
	private static RoomService roomService = new RoomService();
	private static UserService userService = new UserService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int roomId = Integer.valueOf(request.getParameter("roomId"));
		
		try {
			User admin = userService.getUserByStatus(1);
			if (roomService.changeRoomReservation(admin.getId(), roomId, false)) {
				response.sendRedirect("FrontController?command=SHOW_ROOMS");
			} else {
				response.sendRedirect("FrontController?command=SHOW_ROOMS&message=BOOKING_FAILED");
			}
		} catch (SQLException e) {
			response.sendRedirect("FrontController?command=SHOW_ROOMS&message=DAO_ERROR");
		}
	}

}
