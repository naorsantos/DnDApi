package br.com.naor.magiasdndapi.dto;

import java.util.List;

import br.com.naor.magiasdndapi.dominio.Classe;
import br.com.naor.magiasdndapi.dominio.Magia;
import br.com.naor.magiasdndapi.enums.EscolasDeMagia;
import br.com.naor.magiasdndapi.util.MagiasUtil;
import lombok.Data;

@Data
public class MagiasResponse {

	private Integer nivel;

	private String nome;

	private String tempoDeConjuracao;

	private String componentes;

	private boolean ritual = false;

	private String duracao;

	private String alcance;

	private String descricao;

	private List<Classe> classes;

	private EscolasDeMagia escolasDeMagia;

	public MagiasResponse(Magia magia) {
		this.nivel = magia.getNivel();
		this.nome = magia.getNome();
		this.tempoDeConjuracao = magia.getTempoDeConjuracao();
		this.componentes = magia.getComponentes();
		this.ritual = magia.isRitual();
		this.duracao = magia.getDuracao();
		this.alcance = magia.getAlcance();
		this.descricao = magia.getDescricao();
		this.classes = MagiasUtil.montaListaDeclasses(MagiasUtil.montaListStringsPorToken(magia.getClasses(), ","));
		this.escolasDeMagia = magia.getEscolasDeMagia();
	}

}
