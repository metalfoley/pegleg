package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.DBConn;
import base.Filo;

/**
 * Servlet implementation class UpdateCurrency
 */
@WebServlet("/updatecurrency")
public class UpdateCurrency extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCurrency() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float totalCurrency = new Float(request.getParameter("dtod"));
		int totalDoubloons = new Integer(request.getParameter("totalDoubloons"));
		Filo.log(request.getParameter("dtod"));
		Filo.log(request.getParameter("totalDoubloons"));
		String query = String.format("UPDATE Currency SET Currency=%f,Doubloons=%d WHERE ID=1", totalCurrency, totalDoubloons);
		Filo.log(query);
		DBConn.openConn();
		try {
			DBConn.update(query);
		} catch (SQLException e) {
			Filo.log("updateCurrency: " + e.getMessage());
		} finally {
			DBConn.closeConn();
		}
		response.sendRedirect("home");
	}

}
