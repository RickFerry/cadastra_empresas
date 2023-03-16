package br.com.study.gerenciador.controlador;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Empresa;
import br.com.study.gerenciador.repositorio.EmpresaRepository;

public class ListaEmpresas implements Acao {

	private EmpresaRepository empresaRepository;

	public ListaEmpresas() {
		empresaRepository = new EmpresaRepository();
	}

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Empresa> empresas = empresaRepository.buscaEmpresas();
			request.setAttribute("empresas", empresas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "forward:listaEmpresas.jsp";
	}
}
