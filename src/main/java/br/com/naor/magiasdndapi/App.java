package br.com.naor.magiasdndapi;

import java.util.List;

import br.com.naor.magiasdndapi.dao.MagiasDaoImpl;
import br.com.naor.magiasdndapi.dominio.Magia;

/**
 * Magias D&D API
 */
public class App {
	public static void main(String[] args) {

		MagiasDaoImpl magiasDaoImpl = new MagiasDaoImpl();

		List<Magia> buscaTodasMagias = magiasDaoImpl.buscaTodasMagias();

		buscaTodasMagias.stream().forEach(System.out::println);
	}
}
