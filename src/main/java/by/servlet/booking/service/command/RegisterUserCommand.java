package by.servlet.booking.service.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.servlet.booking.dao.entity.User;
import by.servlet.booking.service.UserService;

public class RegisterUserCommand implements Command {
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
			if (service.getUserByLogin(login) == null) {
				if (service.addUser(new User(login, password))) {
					response.sendRedirect("FrontController?command=SIGN_IN_USER&userLogin=" + login + "&userPassword=" + password);
				} else {
					response.sendRedirect("index.jsp?message=DAO_FAILED");
				}
			} else {
				response.sendRedirect("index.jsp?message=DAO_USER_EXIST");
			}
		} catch (SQLException e) {
			response.sendRedirect("index.jsp?message=DAO_ERROR");
		}
	}
}
