package br.com.study.gerenciador.controlador;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.repositorio.EmpresaRepository;

public class RemoveEmpresa implements Acao {

	private EmpresaRepository empresaRepository;

	public RemoveEmpresa() {
		empresaRepository = new EmpresaRepository();
	}

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		try {
			empresaRepository.removeEmpresa(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
