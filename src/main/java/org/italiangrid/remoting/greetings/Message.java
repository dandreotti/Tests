package org.italiangrid.remoting.greetings;

public enum Message {

	MSG("Hello!");

	final private String msg;

	private Message(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
