package br.com.study.gerenciador.controlador;

import static br.com.study.gerenciador.repositorio.Banco.existeUsuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = existeUsuario(login, senha);
		if (usuario != null) {
			request.getSession().setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
		return "redirect:entrada?acao=LoginForm";
	}

}
