package br.com.naor.magiasdndapi.service;

import java.util.List;

import br.com.naor.magiasdndapi.dao.MagiasDao;
import br.com.naor.magiasdndapi.dto.MagiasResponse;
import br.com.naor.magiasdndapi.exceptions.DbException;
import br.com.naor.magiasdndapi.exceptions.MagiaNotFoundException;

public class MagiaService {

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
		try {
			magiasResponse = new MagiasResponse(magiasDao.buscaMagiaPorNome(nome));
		} catch (Exception e) {
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
		try {
			magiasResponse = magiasDao.buscaMagiasPorNivel(Integer.valueOf(nivel)).stream().map(MagiasResponse::new).toList();
		} catch (Exception e) {
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
