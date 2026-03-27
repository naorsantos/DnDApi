package br.com.naor.magiasdndapi.controller;

public class RouteResult {
	private final String body;
	private final int statusCode;

	public RouteResult(String body, int statusCode) {
		this.body = body;
		this.statusCode = statusCode;
	}

	public String getBody() {
		return body;
	}

	public int getStatusCode() {
		return statusCode;
	}

}
