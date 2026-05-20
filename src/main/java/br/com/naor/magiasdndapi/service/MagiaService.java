package br.com.naor.magiasdndapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.naor.magiasdndapi.dao.MagiasDao;
import br.com.naor.magiasdndapi.dto.MagiasResponse;
import br.com.naor.magiasdndapi.exceptions.DbException;
import br.com.naor.magiasdndapi.exceptions.MagiaNotFoundException;

public class MagiaService {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(MagiaService.class);

	private final MagiasDao magiasDao;

	public MagiaService(MagiasDao magiasDao) {
		super();
		this.magiasDao = magiasDao;
	}

	public List<MagiasResponse> buscarTodasMagias() {

		return magiasDao.buscaTodasMagias().stream().map(MagiasResponse::new).toList();

	}

	public MagiasResponse buscaMagiaPorNome(String nome) {
		MagiasResponse magiasResponse = null;
		LOGGER.info("BUSCANDO MAGIA POR NOME: {}", nome);
		try {
			magiasResponse = new MagiasResponse(magiasDao.buscaMagiaPorNome(nome));
		} catch (Exception e) {
			LOGGER.error("ERRO NA BUSCA DE MAGIA POR NOME {}", e.getMessage(), e);
			switch (e) {
			case MagiaNotFoundException magiaNotFoudExcption -> {
				magiasResponse = new MagiasResponse(magiaNotFoudExcption.getMessage(), 404);
			}

			case DbException dbException -> {
				magiasResponse = new MagiasResponse(dbException.getSqlState(), 500);
			}

			default -> magiasResponse = new MagiasResponse("Erro interno do servidor", 500);
			}
		}
		return magiasResponse;

	}

	public List<MagiasResponse> buscaMagiaPorNivel(String nivel) {
		List<MagiasResponse> magiasResponse = null;
		LOGGER.info("BUSCANDO MAGIA POR NIVEL {}", nivel);
		try {
			magiasResponse = magiasDao.buscaMagiasPorNivel(Integer.valueOf(nivel)).stream().map(MagiasResponse::new).toList();
		} catch (Exception e) {
			LOGGER.error("ERRO NA BUSCA DE MAGIAS POR NIVEL {}", e.getMessage(), e);
			switch (e) {
			case MagiaNotFoundException magiaNotFoudExcption -> {
				magiasResponse = List.of(new MagiasResponse(magiaNotFoudExcption.getMessage(), 404));
			}

			case DbException dbException -> {
				magiasResponse = List.of(new MagiasResponse(dbException.getSqlState(), 500));
			}

			default -> magiasResponse = List.of(new MagiasResponse("Erro interno do servidor", 500));
			}
		}
		return magiasResponse;

	}
}
