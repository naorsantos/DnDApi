package br.com.naor.magiasdndapi;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import br.com.naor.magiasdndapi.controller.MagiaController;
import br.com.naor.magiasdndapi.dao.MagiasDaoImpl;
import br.com.naor.magiasdndapi.httphandlers.MagiaHttpHandler;
import br.com.naor.magiasdndapi.service.MagiaService;

/**
 * Magias D&D API
 */
public class App {
	public static void main(String[] args) throws IOException {

		MagiasDaoImpl magiasDaoImpl = new MagiasDaoImpl();
		
		MagiaService magiaService = new MagiaService(magiasDaoImpl);
		
		MagiaController controller = new MagiaController(magiaService);
		
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
		httpServer.createContext("/", new MagiaHttpHandler(controller));
		httpServer.setExecutor(null);
		httpServer.start();

		System.out.println("Servidor iniciado em http://localhost:8080/");
	}
}
