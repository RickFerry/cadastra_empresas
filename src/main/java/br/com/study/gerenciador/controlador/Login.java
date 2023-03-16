package br.com.study.gerenciador.controlador;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Usuario;
import br.com.study.gerenciador.repositorio.UsuarioRepository;

public class Login implements Acao {

	private UsuarioRepository usuarioRepository;

	public Login() {
		usuarioRepository = new UsuarioRepository();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		try {
			Usuario usuario = usuarioRepository.existeUsuario(login, senha);
			if (usuario.getId() != null) {
				request.getSession().setAttribute("usuarioLogado", usuario);
				return "redirect:entrada?acao=ListaEmpresas";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:entrada?acao=LoginForm";
	}
}
