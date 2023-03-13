package br.com.study.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;

@WebServlet("/entrada")
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = -4012572914709744135L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destino = null;
		String acao = request.getParameter("acao");
		String nomeQualificado = "br.com.study.gerenciador.controller." + acao;

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
