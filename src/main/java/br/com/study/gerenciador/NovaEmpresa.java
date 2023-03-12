package br.com.study.gerenciador;

import static br.com.study.gerenciador.Banco.adiciona;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 6926941156207765709L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeEmpresa = req.getParameter("nome");
		String data = req.getParameter("data");

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		try {
			empresa.setDataAbertura(formatador.parse(data));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		adiciona(empresa);

		req.setAttribute("nomeEmpresa", empresa.getNome());
		resp.sendRedirect("listaEmpresas");
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/listaEmpresas");
//		dispatcher.forward(req, resp);
	}
}
