package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import program.Pirate;
import base.Filo;
import dao.DaoCurrency;
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
		DaoPirate dp = new DaoPirate();
		if(request.getParameter("id") != null) {
			request.setAttribute("pirate", dp.getPirate(Integer.parseInt(request.getParameter("id"))));
		} else {
			JSONParser jsonParser = new JSONParser();
			String ship = null;
			int doubloons = 0;
			DaoCurrency dc = new DaoCurrency();
			try {
				JSONObject jsonObject = (JSONObject) jsonParser.parse(request.getParameter("ships"));
				ship = (String) jsonObject.get("ship");
				doubloons = Integer.parseInt((String) jsonObject.get("doubloons"));
				dc.updateDoubloons(doubloons);
			} catch (ParseException e) {
				Filo.log("pirateEdit doGet: " + e.getMessage());
			}
			request.setAttribute("pirate", dp.createPirate(ship));
		}
		request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoPirate dp = new DaoPirate();
		Integer id = null;
		if(request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String shipName = request.getParameter("shipName");
		String pirateName = request.getParameter("pirateName");
		dp.insertPirate(new Pirate(firstName,lastName,shipName,pirateName),id);
		response.sendRedirect("home");
	}

}
