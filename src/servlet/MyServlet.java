package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import repository.UserDao;

//Servlet implementation class LoginServlet for Registration Page

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String fullName = request.getParameter("fullName");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contactNo");

		User user = new User();
		user.setFullName(fullName);
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setContactNo(contactNo);
		try {
			userDao.registerUser(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		response.sendRedirect("index.jsp");
	}

}
