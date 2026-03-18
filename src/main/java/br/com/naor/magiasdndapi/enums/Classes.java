package br.com.naor.magiasdndapi.enums;

public enum Classes {
	BARDO("Bardo"), BRUXO("Bruxo"), CLERIGO("CLÉRIGO"), DRUIDA("Druida"), FEITICEIRO("Feiticeiro"), MAGO("Mago"),
	PALADINO("Paladino"), PATRULHEIRO("Patrulheiro"), ARTIFICE("Artífice");

	private String classe;

	Classes() {
	}

	Classes(String classe) {
		this.classe = classe;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String descricao) {
		this.classe = descricao;
	}
}
