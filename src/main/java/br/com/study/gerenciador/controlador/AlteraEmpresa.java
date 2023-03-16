package br.com.study.gerenciador.controlador;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Empresa;
import br.com.study.gerenciador.repositorio.EmpresaRepository;

public class AlteraEmpresa implements Acao {

	private EmpresaRepository empresaRepository;

	public AlteraEmpresa() {
		empresaRepository = new EmpresaRepository();
	}

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("data");

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatador.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(date);

		try {
			empresaRepository.atualizaEmpresa(empresa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
