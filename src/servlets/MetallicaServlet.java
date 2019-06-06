package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.UserUtils.Mail;
import Utils.UserUtils.WriteComand;
import Utils.UserUtils.WriteUser;
import Utils.UserUtils.readComand;

/**
 * Servlet implementation class MetallicaServlet
 */
@WebServlet("/MetallicaServlet")
public class MetallicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MetallicaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher reqDisp = request.getRequestDispatcher("/metallica.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String location = request.getParameter("location");
		String username = request.getParameter("username1");
		String cart = request.getParameter("Addcart");
		HttpSession sess = request.getSession();
		sess.setAttribute("username", username);
		String price = null;
		WriteUser userfunctions = new WriteUser();
		readComand readComand = new readComand();
		if (cart!=null) {
			WriteComand wr = new WriteComand();
			try {
				price = readComand.getPrice(location);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				wr.insertComand(username, location, price);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("metallica.jsp").forward(request, response);
		}
		if(request.getParameter("total") != null){
			//System.out.println("totalul dvs este de: " + userfunctions.total(username));
			Mail m = new Mail();
			m.sendMail(username);
			request.getRequestDispatcher("metallica.jsp").forward(request, response);
		}
	}

}
