package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.AddPirate;
import program.Pirate;
import dao.DaoPirate;

/**
 * Servlet implementation class pirateEdit
 */
@WebServlet("/edit")
public class pirateEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoPirate dp;
	private Pirate pirate;
	private RequestDispatcher dispatcher;
	private AddPirate addPirate;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pirateEdit() {
        super();
        setDp(new DaoPirate());
        setAddPirate(new AddPirate());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			pirate = getDp().getPirate(id);
			request.setAttribute("pirate", pirate);
		} else {
			String ship = getAddPirate().getShip(request.getParameter("ships"));
			request.setAttribute("disabled", "disabled");
			request.setAttribute("pirate", getDp().createPirate(ship));
		}
		setDispatcher(request.getRequestDispatcher("/WEB-INF/edit.jsp"));
		getDispatcher().forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		if(request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String shipName = request.getParameter("shipName");
		String pirateName = request.getParameter("pirateName");
		getDp().insertPirate(new Pirate(firstName,lastName,shipName,pirateName),id);
		response.sendRedirect("home");
	}

	public DaoPirate getDp() {
		return dp;
	}

	public void setDp(DaoPirate dp) {
		this.dp = dp;
	}

	public RequestDispatcher getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(RequestDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public AddPirate getAddPirate() {
		return addPirate;
	}

	public void setAddPirate(AddPirate addPirate) {
		this.addPirate = addPirate;
	}

}
