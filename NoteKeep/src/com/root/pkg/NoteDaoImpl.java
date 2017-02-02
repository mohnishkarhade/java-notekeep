package com.root.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import oracle.jdbc.OracleDriver;

public class NoteDaoImpl implements NoteDao {
	PreparedStatement pstmt;
	Statement stmt;
	Connection conn=null;
	int st=0;
	@Override
	public Connection getConnection(){
		// TODO Auto-generated method stub
		
		try {
			OracleDriver driver = new OracleDriver();
			DriverManager.registerDriver(driver);		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			System.out.println("Connected" + conn);
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
			Connection conn = getConnection();
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
		return 0;
	}

	@Override
	public Notes getNoteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notes> getAllNotes() {
		// TODO Auto-generated method stub
		return null;
	}	

}
