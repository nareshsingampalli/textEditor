package service;

import org.springframework.stereotype.Service;

import model.History;
import model.TextEditor;
import model.TextMomento;

@Service
public class TextEditorService {
	private TextEditor textEditor;
	private  History history;
	
	
	public TextEditorService() {
		this.textEditor = new TextEditor();
		this.history = new History();
	}
	
	
	public String getContent() {
		return textEditor.getContent();
	}
	
//	public void write(String text) {
//		textEditor.write(text);
//	}
	public void write(String text) {
	    // Instead of appending, replace the content
	    this.textEditor = new TextEditor(); // Create new editor
	    this.textEditor.write(text); // Write the new content
	}
	
	   // NEW: Method to handle complete content replacement
    public void setContent(String content) {
        // Clear current content and set new content
        this.textEditor = new TextEditor();
        this.textEditor.write(content);
    }
    
    // NEW: Method to append text (for incremental additions)
    public void appendText(String text) {
        textEditor.write(text);
    }
	
	public void saveState() {
		 TextMomento momento =  textEditor.saveState();
		 history.push(momento);
	}
	
	public String undo() {
		TextMomento  momento  = history.back();
		
		if(momento != null) {
			textEditor.restore(momento);
			return textEditor.getContent();
		}
		return textEditor.getContent();
	}
	
	public String redo() {
		TextMomento momento = history.forward();
		
		if(momento != null) {
			textEditor.restore(momento);
			return textEditor.getContent();
		}
		return textEditor.getContent();
	}
	
	public void clear() {
		this.history = new History();
		this.textEditor = new TextEditor();
	}
	
	public boolean canUndo() {
		return history.canUndo();
	}
	
	public boolean canRedo() {
		return history.canRedo();
	}
}
