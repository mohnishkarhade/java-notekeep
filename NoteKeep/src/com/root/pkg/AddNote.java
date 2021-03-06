package com.root.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNote
 */
@WebServlet("/AddNote")
public class AddNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoteDao noteDao = new NoteDaoImpl();
	Notes note = new Notes();
           

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("addnote.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		
		
		note.setTitle(title);
		note.setContent(content);
		note.setStatus(status);
		
		int st = noteDao.addNote(note);
		if(st>0){
			out.print("<p class=\"alert alert-success text-center\"> Note Added.</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		} else{
			out.print("<p class=\"alert alert-danger text-center\"> Sorry! Unable to save.</p>");
		}
		out.close();
	}

}
