package model;

import java.time.LocalDateTime;

// Momento
public class TextMomento {
	private  final String content;
	private final long timestamp;
	
	public TextMomento(String content, long timestamp) {
		this.content = content;
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}

	public long getTimestamp() {
		return timestamp;
	}
	
	
	
}
