package com.root.pkg;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NoteDetail
 */
@WebServlet("/NoteDetail")
public class NoteDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Notes note = new Notes();
	NoteDao noteDao = new NoteDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String tempId=request.getParameter("id");
		int id = Integer.parseInt(tempId);
		List<Notes> noteList= noteDao.getNoteById(id);
		request.setAttribute("notedetail", noteList);
		RequestDispatcher rd = request.getRequestDispatcher("notedetail.jsp");
		rd.forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
