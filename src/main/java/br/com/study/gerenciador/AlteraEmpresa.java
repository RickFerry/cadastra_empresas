package br.com.study.gerenciador;

import static br.com.study.gerenciador.Banco.bucaPorId;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1429793546018009797L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("data");

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatador.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = bucaPorId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(date);
		
		response.sendRedirect("listaEmpresas");
	}
}
