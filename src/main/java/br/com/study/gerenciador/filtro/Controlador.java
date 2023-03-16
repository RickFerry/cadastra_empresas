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

import br.com.study.gerenciador.contrato.Acao;

public class Controlador extends HttpFilter implements Filter {
	private static final long serialVersionUID = -4012572914709744135L;

	@Override
	public void init() throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String destino = null;
		String acao = request.getParameter("acao");
		String nomeQualificado = "br.com.study.gerenciador.controlador." + acao;

		try {
			Class<?> classe = Class.forName(nomeQualificado);
			@SuppressWarnings("deprecation")
			Acao start = (Acao) classe.newInstance();
			destino = start.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipo = destino.split(":");
		if (tipo[0].equals("forward")) {
			request.getRequestDispatcher("WEB-INF/view/" + tipo[1]).forward(request, response);
		} else {
			response.sendRedirect(tipo[1]);
		}
	}
}
