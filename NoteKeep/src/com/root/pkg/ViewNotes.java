package com.root.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ViewNotes
 */
@WebServlet("/ViewNotes")
public class ViewNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoteDao noteDao = new NoteDaoImpl();
    Notes note = new Notes();
    Statement stmt;
    Connection conn;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		List<Notes> notelist = noteDao.getAllNotes();
		response.setContentType("application/json");
		String json = new Gson().toJson(notelist);
		response.getWriter().write(json);
		out.println(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
