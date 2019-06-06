package servlets;

import java.io.IOException;
import java.io.WriteAbortedException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.UserUtils.WriteUser;
import dto.User;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName  = request.getParameter("first");
		String lastName =  request.getParameter("last");
		String email = request.getParameter("username");
		String parola = request.getParameter("password");
		String parola1 = request.getParameter("password1");
		String role  = "user";
		
		WriteUser writeUser = new WriteUser();
		if(!firstName.equals(null))
			if(parola1.equals(parola))
				try {
					writeUser.insertUser(email, firstName, lastName, parola, role);
					  RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
					  view.forward(request, response);
					
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println("passwords doesn't match");
					e.printStackTrace();
				}
			
	}

}
