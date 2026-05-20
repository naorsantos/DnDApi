package br.com.naor.magiasdndapi.httphandlers;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import br.com.naor.magiasdndapi.controller.MagiaController;
import br.com.naor.magiasdndapi.controller.RouteResult;

public class MagiaHttpHandler implements HttpHandler {
	private static final Logger LOGGER  = LoggerFactory.getLogger(MagiaHttpHandler.class);
	private final MagiaController magiaController;

	public MagiaHttpHandler(MagiaController magiaController) {
		super();
		this.magiaController = magiaController;
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		RouteResult result = magiaController.route(exchange);
		LOGGER.info("BUSCA REALIZADA COM SUCESSO STATUS:{}", result.getStatusCode());
		byte[] bytes = result.getBody().getBytes(StandardCharsets.UTF_8);
		exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
		exchange.sendResponseHeaders(result.getStatusCode(), bytes.length);
		try (OutputStream os = exchange.getResponseBody()) {
			os.write(bytes);
		}
	}

}
