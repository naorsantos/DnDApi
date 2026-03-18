package br.com.naor.magiasdndapi;

import java.util.List;

import javax.sql.DataSource;

import br.com.naor.magiasdndapi.dao.DbConnection;
import br.com.naor.magiasdndapi.dao.MagiasDaoImpl;
import br.com.naor.magiasdndapi.dominio.Magia;

/**
 * Magias D&D API
 */
public class App {
    public static void main(String[] args) {
    	
    	DataSource dataSource = DbConnection.getDataSource();
    	
    	MagiasDaoImpl magiasDaoImpl = new MagiasDaoImpl(dataSource);
    	
    	List<Magia> buscaTodasMagias = magiasDaoImpl.buscaTodasMagias();
    	
    	buscaTodasMagias.stream().forEach(System.out::println);
    }
}
