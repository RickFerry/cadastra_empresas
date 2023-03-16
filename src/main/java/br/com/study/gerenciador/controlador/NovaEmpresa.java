package br.com.study.gerenciador.controlador;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Empresa;
import br.com.study.gerenciador.repositorio.EmpresaRepository;

public class NovaEmpresa implements Acao {

	private EmpresaRepository empresaRepository;

	public NovaEmpresa() {
		empresaRepository = new EmpresaRepository();
	}

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String nomeEmpresa = req.getParameter("nome");
		String data = req.getParameter("data");

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		try {
			empresa.setDataAbertura(formatador.parse(data));
			empresaRepository.adicionaEmpresa(empresa);
		} catch (ParseException | SQLException e) {
			throw new ServletException(e);
		}

		req.setAttribute("nomeEmpresa", empresa.getNome());
		return "forward:novaEmpresaCriada.jsp";
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/listaEmpresas");
//		dispatcher.forward(req, resp);
	}
}
