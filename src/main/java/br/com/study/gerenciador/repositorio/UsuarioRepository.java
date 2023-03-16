package br.com.study.gerenciador.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.study.gerenciador.modelo.Usuario;

public class UsuarioRepository {

	private ConnectionFactory conn = null;
	private Connection conexao = null;

	public UsuarioRepository() {
		this.conn = new ConnectionFactory();
		try {
			this.conexao = conn.getConnection();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario existeUsuario(String login, String senha) throws SQLException {
		Usuario usuario = new Usuario();
		try (PreparedStatement stm = conexao
				.prepareStatement("SELECT id, login, senha FROM usuario WHERE login = ? AND senha = ?")) {
			stm.setString(1, login);
			stm.setString(2, senha);
			stm.execute();
			ResultSet set = stm.getResultSet();
			if (set.next()) {
				usuario.setId(set.getLong("id"));
				usuario.setLogin(set.getString("login"));
				usuario.setSenha(set.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
		return usuario;
	}
}
