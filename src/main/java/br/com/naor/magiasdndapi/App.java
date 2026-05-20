package br.com.naor.magiasdndapi;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.HttpServer;

import br.com.naor.magiasdndapi.controller.MagiaController;
import br.com.naor.magiasdndapi.dao.MagiasDaoImpl;
import br.com.naor.magiasdndapi.httphandlers.MagiaHttpHandler;
import br.com.naor.magiasdndapi.service.MagiaService;

/**
 * Magias D&D API
 */
public class App {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) throws IOException {
		
		LOGGER.info("inicializando aplicacao");
		
		MagiasDaoImpl magiasDaoImpl = new MagiasDaoImpl();
		
		MagiaService magiaService = new MagiaService(magiasDaoImpl);
		
		MagiaController controller = new MagiaController(magiaService);
		
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
		httpServer.createContext("/", new MagiaHttpHandler(controller));
		httpServer.setExecutor(null);
		httpServer.start();

		LOGGER.info("Servidor iniciado em http://localhost:8080/");
	}
}
