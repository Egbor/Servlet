package by.servlet.booking.service.command;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.servlet.booking.dao.entity.User;
import by.servlet.booking.service.UserService;

public class GetAllUsersCommand implements Command {
	private static UserService dao = new UserService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			List<User> users = dao.getAllUsers();
			if (users.size() != 0) {
				request.setAttribute("users", users);
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
