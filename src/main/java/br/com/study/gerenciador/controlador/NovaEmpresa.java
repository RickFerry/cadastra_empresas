package br.com.study.gerenciador.controlador;

import static br.com.study.gerenciador.repositorio.Banco.adiciona;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
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
		return "redirect:entrada?acao=ListaEmpresas";
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/listaEmpresas");
//		dispatcher.forward(req, resp);
	}
}
