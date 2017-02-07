package com.root.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateNote
 */
@WebServlet("/UpdateNote")
public class UpdateNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoteDao noteDao = new NoteDaoImpl();
	Notes note = new Notes();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tempId = request.getParameter("id");
		int id=Integer.parseInt(tempId);
		List<Notes> notedata = noteDao.getNoteById(id);
		request.setAttribute("notedata", notedata);
		RequestDispatcher rd = request.getRequestDispatcher("updatenote.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String tempid=request.getParameter("id");
		int id = Integer.parseInt(tempid);
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String status=request.getParameter("status");
		note.setNoteId(id);
		note.setTitle(title);
		note.setContent(content);
		note.setStatus(status);
		
		int st = noteDao.updateNote(note);
		if(st>0){
			out.print("<p class=\"alert alert-success text-center\"> Note Updated.</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		} else{
			out.print("<p class=\"alert alert-danger text-center\"> Sorry! Unable to update.</p>");
		}
		out.close();
		
	}

}
