package servlets;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.logging.Logger;

import Utils.UserUtils.LoginCheck;
import dto.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// LoginCheck user = new LoginCheck(); // functia cu operatia pt login(din read
	// model)
	LoginCheck user = new LoginCheck();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher reqDisp = request.getRequestDispatcher("/login.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String result = "";

		try {
			result = user.searchUser(request.getParameter("username"), request.getParameter("password"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("utilizatorul e :" + result);
		if (result.equals("user")) {
			forward = "/welcome.jsp";
		} else if (result.equals("admin")) {
			forward = "/staff.jsp";
		} else {
			forward = "/about.jsp";
		}
		request.setAttribute("name", request.getParameter("username"));
		request.setAttribute("name1", request.getParameter("username"));
		request.getRequestDispatcher(forward).forward(request, response);
	    // HttpSession session = (request.getSession());
	    // System.out.println("Session ID in servlet: "+request.getParameter("username"));
		//RequestDispatcher reqDisp = request.getRequestDispatcher(forward);
	//	reqDisp.forward(request, response);

	}
}
