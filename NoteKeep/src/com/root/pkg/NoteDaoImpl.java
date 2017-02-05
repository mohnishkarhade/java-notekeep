package com.root.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import oracle.jdbc.OracleDriver;

public class NoteDaoImpl implements NoteDao {
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	Connection conn=null;
	int st=0;
	
	@Override
	public Connection getConnection(){
		// TODO Auto-generated method stub
		
		try {
			OracleDriver driver = new OracleDriver();
			DriverManager.registerDriver(driver);		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			System.out.println("Connected: " + conn.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public int addNote(Notes n) {
		// TODO Auto-generated method stub
		try{
			getConnection();
			String id="1";
			String title=n.getTitle();
			String content=n.getContent();
			String status=n.isStatus();
			String query = "insert into notedata values(?,?,?,?)";					
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.setString(2,title);
			pstmt.setString(3,content);
			pstmt.setString(4,status);
			st = pstmt.executeUpdate();
			System.out.println(pstmt);
			conn.close();
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return st;
	}

	@Override
	public int updateNote(Notes n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNote(int id) {
		// TODO Auto-generated method stub
		int flag=0;
		try{			
			getConnection();
			String query = "delete from notedata where id="+id;
			stmt = conn.createStatement();
			flag = stmt.executeUpdate(query);			
			
		} catch(SQLException e){
			e.printStackTrace();
		}	
		return flag;
	}

	@Override
	public List<Notes> getNoteById(int id) {
		// TODO Auto-generated method stub
		List<Notes> noteList = new ArrayList<Notes>();
		try{
			
			getConnection();
			String query = "select * from notedata where id="+id;
			stmt=conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				Notes note = new Notes();
				note.setNoteId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setStatus(rs.getString("status"));
				
				noteList.add(note);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}		
		return noteList;
	}

	@Override
	public List<Notes> getAllNotes() {
		// TODO Auto-generated method stub
		List<Notes> noteList = new ArrayList<Notes>();
		try{
			conn = getConnection();
			String query = "select * from notedata";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				//noteList.add(new Notes(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("status")));
				Notes note= new Notes();
				note.setNoteId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setStatus(rs.getString("status"));
				noteList.add(note);
			}					
		} catch(SQLException e){
			e.printStackTrace();
		}
		return noteList;
	}	

}
