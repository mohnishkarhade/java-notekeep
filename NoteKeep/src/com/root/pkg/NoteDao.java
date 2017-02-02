package com.root.pkg;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface NoteDao {
	
	public Connection getConnection();
	public int addNote(Notes n);
	public int updateNote(Notes n);
	public int deleteNote(int id);
	public Notes getNoteById(int id);
	public List<Notes> getAllNotes();

}
