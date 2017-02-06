package com.root.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchNote
 */
@WebServlet("/SearchNote")
public class SearchNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    NoteDao noteDao = new NoteDaoImpl();
    Notes note = new Notes();
    Statement stmt;
    Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("index.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String searchstring = request.getParameter("searchstring");
		
		List<Notes> listnote = new ArrayList<Notes>();
		try{
			conn = noteDao.getConnection();
			String query = "select * from notedata where title like "+"'%"+searchstring+"%'";
			System.out.println(query);
			stmt = conn.createStatement();						
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){	
				while(rs.next()){
					Notes note = new Notes();
					note.setNoteId(rs.getInt("id"));
					note.setTitle(rs.getString("title"));
					listnote.add(note);
				}
				request.setAttribute("listnote", listnote);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			} else{
				out.println("<p class=\"alert alert-danger\">Result not found</p>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}			
			
		} catch(SQLException e){
			e.printStackTrace();
		}			
		
	}

}
