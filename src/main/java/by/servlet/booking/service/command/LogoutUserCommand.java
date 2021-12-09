package by.servlet.booking.service.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutUserCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.getSession().invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			response.sendRedirect("index.jsp?message=SERVLET_ERROR");
		}
	}

}
