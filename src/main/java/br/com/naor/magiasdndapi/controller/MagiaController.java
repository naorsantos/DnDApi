package br.com.naor.magiasdndapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;

import br.com.naor.magiasdndapi.dto.MagiasResponse;
import br.com.naor.magiasdndapi.service.MagiaService;

public class MagiaController {

	private static final Logger LOGGER  = LoggerFactory.getLogger(MagiaController.class);
	private final Map<String, BiFunction<HttpExchange, String, RouteResult>> routes = new HashMap<>();
	private final MagiaService magiaService;
	private final Gson gson = new Gson();

	public MagiaController(MagiaService magiaService) {
		this.magiaService = magiaService;
		registerRoutes();
	}

	private void registerRoutes() {
		routes.put("GET:/magias", (exchange, path) -> {
			List<MagiasResponse> magias = magiaService.buscarTodasMagias();
			return new RouteResult(gson.toJson(magias), 200);
		});

		routes.put("GET:/magias/nome", (exchange, path) -> {
			Map<String,String> params = queryToMap(exchange.getRequestURI().getQuery());
			String nome = params.get("nome");
			Integer status = 200;
			MagiasResponse magia = magiaService.buscaMagiaPorNome(nome);
			if (magia.getCodigoErro() != null) {
				return new RouteResult(gson.toJson(magia), magia.getCodigoErro());
			}
			return new RouteResult(gson.toJson(magia), status);
		});

		routes.put("GET:/magias/nivel", (exchange, path) -> {
			Map<String,String> params = queryToMap(exchange.getRequestURI().getQuery());
			String nivel = params.get("nivel");
			List<MagiasResponse> magias = magiaService.buscaMagiaPorNivel(nivel);

			if (magias.getFirst().getCodigoErro() != null) {
				return new RouteResult(gson.toJson(magias), magias.getFirst().getCodigoErro());
			}
			return new RouteResult(gson.toJson(magias), 200);
		});
	}

	public RouteResult route(HttpExchange exchange) {
		String method = exchange.getRequestMethod();
		String path = exchange.getRequestURI().getPath();

		
		LOGGER.info("REQUEST RECEBIDA METHOD: {} PATH: {}", method, path);
		String key;
		if (path.startsWith("/magias/nome/")) {
			key = method + ":/magias/nome";
		} else if (path.startsWith("/magias/nivel/")) {
			key = method + ":/magias/nivel";
		} else {
			key = method + ":" + path;
		}

		BiFunction<HttpExchange, String, RouteResult> action = routes.get(key);

		if (action != null) {
			try {
				return action.apply(exchange, path);
			} catch (Exception e) {
				LOGGER.error("ERRO INTERNO DA APLICACAO {}", e.getMessage(), e);
				return new RouteResult(gson.toJson(new MagiasResponse("Erro interno: " + e.getMessage(), 500)), 500);
			}
		} else {
			LOGGER.info("NAO FOI ENCONTRADO ROTA PARA O SEGUINTE PATH {}", path);
			return new RouteResult(gson.toJson(new MagiasResponse("Rota não encontrada", 404)), 404);
		}
	}
	
	
	public Map<String, String> queryToMap(String query){
		Map<String, String> params = new HashMap<>();
		for (String param : query.split("&")) {
			String[] split = param.split("=");
			
			if (split.length > 1) {
				params.put(split[0], split[1]);
			}else {
				params.put(split[0], "");
			}
		}
		return params;
	}

}
