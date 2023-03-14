package br.com.study.gerenciador.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autorizacao extends HttpFilter implements Filter {
	private static final long serialVersionUID = -5824814583043110607L;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String acao = request.getParameter("acao");
		boolean usuarioNaoLogado = (request.getSession().getAttribute("usuarioLogado") == null);
		boolean acoesProtegidas = !(acao.equals("Login") || acao.equals("LoginForm"));

		if (Boolean.TRUE.equals(usuarioNaoLogado) && Boolean.TRUE.equals(acoesProtegidas)) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		chain.doFilter(request, response);
	}
}
