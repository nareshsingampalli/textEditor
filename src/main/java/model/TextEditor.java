package model;

import java.time.LocalDateTime;


// Originator
public class TextEditor {
	private StringBuilder content;
	
	public TextEditor() {
		content = new StringBuilder();
	}
	
	public void write(String text) {
		content.append(text);
	}
	
	public String getContent() {
		return content.toString();
	}
	
	
	 public TextMomento saveState() {
		 long now =System.currentTimeMillis();
		 System.out.println("saved state at  " + now);
		 return new TextMomento(content.toString(),now);
	 }
	 
	 
	 public void restore(TextMomento momento) {
		 this.content = new StringBuilder(momento.getContent());
		 System.out.println("Restored to state from: " + momento.getTimestamp());
	 }
}
