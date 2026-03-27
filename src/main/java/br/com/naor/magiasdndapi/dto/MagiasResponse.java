package br.com.naor.magiasdndapi.dto;

import java.util.List;

import br.com.naor.magiasdndapi.dominio.Classe;
import br.com.naor.magiasdndapi.dominio.Magia;
import br.com.naor.magiasdndapi.enums.EscolasDeMagia;
import br.com.naor.magiasdndapi.util.MagiasUtil;
import lombok.Data;

/**
 * 
 */
@Data
public class MagiasResponse {

	private Integer nivel;

	private String nome;

	private String tempoDeConjuracao;

	private String componentes;

	private String ritual;

	private String duracao;

	private String alcance;

	private String descricao;

	private List<Classe> classes;

	private EscolasDeMagia escolasDeMagia;

	private String erro;

	private Integer codigoErro;

	/**
	 * @param magia
	 */
	public MagiasResponse(Magia magia) {
		this.nivel = magia.getNivel();
		this.nome = magia.getNome();
		this.tempoDeConjuracao = magia.getTempoDeConjuracao();
		this.componentes = magia.getComponentes();
		this.ritual = magia.getRitual();
		this.duracao = magia.getDuracao();
		this.alcance = magia.getAlcance();
		this.descricao = magia.getDescricao();
		this.classes = MagiasUtil.montaListaDeclasses(MagiasUtil.montaListStringsPorToken(magia.getClasses(), ","));
		this.escolasDeMagia = magia.getEscolasDeMagia();
	}

	
	/**
	 * Construtor usado em casos de erro.
	 * @param erro
	 * @param codigoErro
	 */
	public MagiasResponse(String erro, Integer codigoErro) {
		super();
		this.erro = erro;
		this.codigoErro = codigoErro;
	}
	
	

}
