package model;

import java.util.Stack;

//care taker
public class History {
	private Stack<TextMomento> history;
	private Stack<TextMomento> futureHistory;
	
	public History() {
		this.history = new Stack();
		this.futureHistory = new Stack();
	}
	
	
	public void push(TextMomento momento) {
		history.push(momento);
		futureHistory.clear();
	}
	
	public TextMomento back() {
		if(!history.isEmpty()) {
		TextMomento top = history.pop();
		futureHistory.push(top);
		return top;
		}else {
			return null;
		}
	}
	
	
	
	
	public TextMomento forward() {
		if(!futureHistory.isEmpty()) {
			TextMomento top = futureHistory.pop();
			history.push(top);
			return top;
			
		}else {
			return null;
		}
	}
	
	public boolean canUndo() {
	    return !history.isEmpty();
	}

	public boolean canRedo() {
	    return !futureHistory.isEmpty();
	}

	public int getUndoCount() {
	    return history.size();
	}

	public int getRedoCount() {
	    return futureHistory.size();
	}
	
	

}
