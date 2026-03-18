package br.com.naor.magiasdndapi.enums;

public enum EscolasDeMagia {

	ABJURCAO("Abjuração"), ADIVINHACAO("Adivinhação"), CONJURACAO("Conjuração"), ENCANTAMENTO("Encantamento"),
	EVOCACAO("Evocação"), ILUSAO("Ilusão"), NECROMANCIA("Necromancia"), TRANSMUTACAO("Transmutação");

	private String escolaDeMagia;

	private EscolasDeMagia() {
	}

	EscolasDeMagia(String escolaDeMagia) {
		this.setEscolaDeMagia(escolaDeMagia);
	}

	public String getEscolaDeMagia() {
		return escolaDeMagia;
	}

	public void setEscolaDeMagia(String escolaDeMagia) {
		this.escolaDeMagia = escolaDeMagia;
	}

}
