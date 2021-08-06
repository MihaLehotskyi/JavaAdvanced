package ua.lviv.lgs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = UserService.getUserService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		userService.saveUser(new User(firstname,lastname,email,password));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("userEmail", email);
		session.setAttribute("userFirstName", firstname);
		request.getRequestDispatcher("Cabinet.jsp").forward(request, response);
	}

}
