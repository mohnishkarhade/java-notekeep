package com.root.pkg;

public class Notes {
	
	private int noteId;
	private String title;
	private String content;
	private String status;
	
	public Notes(){}
	public Notes(int noteId, String title, String content, String status) {
		this.noteId = noteId;
		this.title = title;
		this.content = content;
		this.status = status;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	

}
