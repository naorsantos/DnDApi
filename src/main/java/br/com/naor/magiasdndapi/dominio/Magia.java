package br.com.naor.magiasdndapi.dominio;

import br.com.naor.magiasdndapi.enums.EscolasDeMagia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Magia {
	@EqualsAndHashCode.Include
	private Integer id;
	private Integer nivel;
	private String nome;
	private String tempoDeConjuracao;
	private String componentes;
	private boolean ritual = false;
	private String duracao;
	private String alcance;
	private String descricao;
	private String classes;
	private EscolasDeMagia escolasDeMagia;

}
