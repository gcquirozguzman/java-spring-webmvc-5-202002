package com.demo.utilitario;

import java.io.Serializable;

public class Response implements Serializable{

	private static final long serialVersionUID = 1L;

	private Error error;
	
	private Object body;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
}
