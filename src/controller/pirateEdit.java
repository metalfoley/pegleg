package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.Pirate;
import dao.DaoPirate;

/**
 * Servlet implementation class pirateEdit
 */
@WebServlet("/edit")
public class pirateEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pirateEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {
			request.setAttribute("pirate", DaoPirate.getPirate(Integer.parseInt(request.getParameter("id"))));
		} else {
			request.setAttribute("pirate", DaoPirate.createPirate());
		}
		request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoPirate.insertPirate(request);
		response.sendRedirect("home");
	}

}
