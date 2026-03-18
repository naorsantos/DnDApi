package br.com.naor.magiasdndapi.dao;

import java.util.List;

import br.com.naor.magiasdndapi.dominio.Magia;

public interface MagiasDao {
	
	public List<Magia> buscaTodasMagias();
	public Magia buscaMagiaPorNome(String nome);
	public Magia buscaMagiaPorId(Integer id);
	public List<Magia> buscaMagiasPorNivel(Integer nivel);
	

}
