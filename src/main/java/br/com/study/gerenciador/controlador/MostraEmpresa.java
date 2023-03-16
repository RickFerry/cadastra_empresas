package br.com.study.gerenciador.controlador;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Empresa;
import br.com.study.gerenciador.repositorio.EmpresaRepository;

public class MostraEmpresa implements Acao {

	private EmpresaRepository empresaRepository;

	public MostraEmpresa() {
		empresaRepository = new EmpresaRepository();
	}

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		try {
			Empresa empresa = empresaRepository.buscaPorId(id);
			request.setAttribute("empresa", empresa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "forward:formAlteraEmpresa.jsp";
	}
}
