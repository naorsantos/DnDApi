package br.com.naor.magiasdndapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import br.com.naor.magiasdndapi.dominio.Magia;
import br.com.naor.magiasdndapi.enums.EscolasDeMagia;

public class MagiasDaoImpl implements MagiasDao {

	private static final String COLUM_ESCOLA_DE_MAGIA = "escola_de_magia";
	private static final String COLUM_MAGIA_CLASSE = "magia_classe";
	private static final String COLUM_TEMPO_CONJURACAO = "tempo_conjuracao";
	private static final String COLUM_RITUAL = "ritual";
	private static final String COLUM_NIVEL = "nivel";
	private static final String COLUM_ALCANCE = "alcance";
	private static final String COLUM_COMPONENTE_MAGIA = "componente_magia";
	private static final String COLUM_DURACAO = "duracao";
	private static final String COLUM_NOME = "nome";
	private static final String COLUM_DESCRICAO = "descricao";
	private final DataSource dataSource;

	public MagiasDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Magia> buscaTodasMagias() {
		String sql = "SELECT * FROM magia";
		List<Magia> magias = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Magia magia = new Magia();
					magia.setNome(resultSet.getString(COLUM_NOME));
					magia.setDescricao(resultSet.getString(COLUM_DESCRICAO));
					magia.setDuracao(resultSet.getString(COLUM_DURACAO));
					magia.setComponentes(resultSet.getString(COLUM_COMPONENTE_MAGIA));
					magia.setAlcance(resultSet.getString(COLUM_ALCANCE));
					magia.setNivel(resultSet.getInt(COLUM_NIVEL));
					magia.setRitual(resultSet.getBoolean(COLUM_RITUAL));
					magia.setTempoDeConjuracao(resultSet.getString(COLUM_TEMPO_CONJURACAO));
					magia.setClasses(resultSet.getString(COLUM_MAGIA_CLASSE));
					magia.setEscolasDeMagia(EscolasDeMagia.valueOf(resultSet.getString(COLUM_ESCOLA_DE_MAGIA)));

					magias.add(magia);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magias;
	}

	@Override
	public Magia buscaMagiaPorNome(String nome) {
		String sql = "SELECT magia.nome, magia.nivel, magia.ritual, magia.alcance, magia.componente_magia, magia.descricao, magia.duracao, magia.tempo_conjuracao, magia.escola_de_magia FROM magia WHERE magia.nome = ?";
		Magia magia = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, nome);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					magia = new Magia(null, resultSet.getInt(COLUM_NIVEL), resultSet.getString(COLUM_NOME),
							resultSet.getString(COLUM_TEMPO_CONJURACAO), resultSet.getString(COLUM_COMPONENTE_MAGIA),
							resultSet.getBoolean(COLUM_RITUAL), resultSet.getString(COLUM_DURACAO),
							resultSet.getString(COLUM_ALCANCE), resultSet.getString(COLUM_DESCRICAO),
							resultSet.getString(COLUM_MAGIA_CLASSE),
							EscolasDeMagia.valueOf(resultSet.getString(COLUM_ESCOLA_DE_MAGIA)));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return magia;
	}

	@Override
	public Magia buscaMagiaPorId(Integer id) {
		String sql = "SELECT magia.nome, magia.nivel, magia.ritual, magia.alcance, magia.componente_magia, magia.descricao, magia.duracao, magia.tempo_conjuracao, magia.escola_de_magia FROM magia WHERE magia.id = ?";
		Magia magia = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					magia = new Magia(null, resultSet.getInt(COLUM_NIVEL), resultSet.getString(COLUM_NOME),
							resultSet.getString(COLUM_TEMPO_CONJURACAO), resultSet.getString(COLUM_COMPONENTE_MAGIA),
							resultSet.getBoolean(COLUM_RITUAL), resultSet.getString(COLUM_DURACAO),
							resultSet.getString(COLUM_ALCANCE), resultSet.getString(COLUM_DESCRICAO),
							resultSet.getString(COLUM_MAGIA_CLASSE),
							EscolasDeMagia.valueOf(resultSet.getString(COLUM_ESCOLA_DE_MAGIA)));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magia;
	}

	@Override
	public List<Magia> buscaMagiasPorNivel(Integer nivel) {
		String sql = "SELECT * FROM magia WHERE magia.nivel = ?";
		List<Magia> magias = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, nivel);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Magia magia = new Magia();
					magia.setNome(resultSet.getString(COLUM_NOME));
					magia.setDescricao(resultSet.getString(COLUM_DESCRICAO));
					magia.setDuracao(resultSet.getString(COLUM_DURACAO));
					magia.setComponentes(resultSet.getString(COLUM_COMPONENTE_MAGIA));
					magia.setAlcance(resultSet.getString(COLUM_ALCANCE));
					magia.setNivel(resultSet.getInt(COLUM_NIVEL));
					magia.setRitual(resultSet.getBoolean(COLUM_RITUAL));
					magia.setTempoDeConjuracao(resultSet.getString(COLUM_TEMPO_CONJURACAO));
					magia.setClasses(resultSet.getString(COLUM_MAGIA_CLASSE));
					magia.setEscolasDeMagia(EscolasDeMagia.valueOf(resultSet.getString(COLUM_ESCOLA_DE_MAGIA)));

					magias.add(magia);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magias;
	}

}
