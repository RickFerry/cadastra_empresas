package br.com.study.gerenciador.controller;

import static br.com.study.gerenciador.repository.Banco.bucaPorId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.model.Empresa;

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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

		return "redirect:entrada?acao=ListaEmpresas";
	}
}
