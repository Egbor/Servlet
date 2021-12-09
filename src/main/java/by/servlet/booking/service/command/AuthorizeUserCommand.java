package by.servlet.booking.service.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.servlet.booking.dao.entity.User;
import by.servlet.booking.service.UserService;

public class AuthorizeUserCommand implements Command {
	private static UserService service = new UserService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String login = request.getParameter("userLogin");
		String password = request.getParameter("userPassword");
		
		if (login.isEmpty() || password.isEmpty()) {
			response.sendRedirect("index.jsp?message=EMPTY_FIELD");
			return;
		}
		
		try {
			User user = service.getUserByLogin(login);
			if ((user != null) && (user.getPassword().compareTo(password) == 0)) {
				request.getSession(true).setAttribute("currentUser", user);
				response.sendRedirect("FrontController?command=SHOW_ROOMS");
			} else {
				response.sendRedirect("index.jsp?message=AUTHORIZATION_FAILED");
			}
		} catch (SQLException e) {
			response.sendRedirect("index.jsp?message=DAO_ERROR");
		}
	}

}
