package br.com.study.gerenciador.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.study.gerenciador.modelo.Empresa;

public class EmpresaRepository {

	private ConnectionFactory conn = null;
	private Connection conexao = null;

	public EmpresaRepository() {
		this.conn = new ConnectionFactory();
		try {
			this.conexao = conn.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionaEmpresa(Empresa empresa) throws SQLException {

		try (PreparedStatement stm = conexao
				.prepareStatement("INSERT INTO empresa (nome, data_abertura) VALUES (?, ?)")) {
			stm.setString(1, empresa.getNome());
			stm.setDate(2, new Date(empresa.getDataAbertura().getTime()));
			stm.execute();
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public List<Empresa> buscaEmpresas() throws SQLException {
		try (PreparedStatement stm = conexao.prepareStatement("SELECT id, nome, data_abertura FROM empresa")) {
			stm.execute();
			ResultSet set = stm.getResultSet();
			Empresa empresa = null;
			List<Empresa> empresas = new ArrayList<>();
			while (set.next()) {
				empresa = new Empresa();
				empresa.setId(set.getLong("id"));
				empresa.setNome(set.getString("nome"));
				empresa.setDataAbertura(set.getDate("data_abertura"));
				empresas.add(empresa);
			}
			return empresas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public Empresa buscaPorId(Long id) throws SQLException {
		Empresa empresa = new Empresa();
		try (PreparedStatement stm = conexao
				.prepareStatement("SELECT id, nome, data_abertura FROM empresa WHERE id = ?")) {
			stm.setLong(1, id);
			stm.execute();
			ResultSet set = stm.getResultSet();
			if (set.next()) {
				empresa.setId(set.getLong("id"));
				empresa.setNome(set.getString("nome"));
				empresa.setDataAbertura(set.getDate("data_abertura"));
			}
			return empresa;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void atualizaEmpresa(Empresa empresa) throws SQLException {
		try (PreparedStatement stm = conexao
				.prepareStatement("UPDATE empresa SET nome = ?, data_abertura = ? WHERE id = ?")) {
			stm.setString(1, empresa.getNome());
			stm.setDate(2, new Date(empresa.getDataAbertura().getTime()));
			stm.setLong(3, empresa.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeEmpresa(Long id) throws SQLException {
		try (PreparedStatement stm = conexao.prepareStatement("DELETE FROM empresa WHERE id = ?")) {
			stm.setLong(1, id);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
