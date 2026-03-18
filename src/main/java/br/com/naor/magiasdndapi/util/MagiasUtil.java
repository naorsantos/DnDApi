package br.com.naor.magiasdndapi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import br.com.naor.magiasdndapi.dominio.Classe;

public class MagiasUtil {

	public static List<String> montaListStringsPorToken(String listDeString, String token) {
		StringTokenizer stringTokenizer = new StringTokenizer(listDeString, token);
		List<String> lista = new ArrayList<>();
		while (stringTokenizer.hasMoreElements()) {
			lista.add(stringTokenizer.nextToken());
		}
		return lista;
	}

	public static List<Classe> montaListaDeclasses(List<String> classes) {
		return classes.stream().map(Classe::new).toList();
	}
}
