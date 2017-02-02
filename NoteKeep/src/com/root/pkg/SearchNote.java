package com.root.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String searchstring = request.getParameter("searchstring");
		Notes note = new Notes();
		try{
			conn = noteDao.getConnection();
			String query = "select * from notedata where title="+"'"+searchstring+"'";
			stmt = conn.createStatement();						
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){	
				out.println("<table class=\"table\">");
				out.println(
						"<tr><td>"+rs.getString("title")+"</td><td>"
						+rs.getString("content")+"</td><td>"
						+rs.getString("status")+"</tr>"
						);	
				out.println("</table>");
				
			} else{
				out.println("<p class=\"alert alert-danger\">Result not found</p>");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}			
		
	}

}
