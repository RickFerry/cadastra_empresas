package br.com.study.gerenciador.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

import lombok.extern.java.Log;

@Log
public class Monitoramento extends HttpFilter implements Filter {
	private static final long serialVersionUID = 2408642405840319291L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long antes = System.currentTimeMillis();

		String acao = request.getParameter("acao");
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();
		log.info("Tempo de execução de: " + acao + " -> " + (depois - antes) + " milessegundos.");
	}
}
