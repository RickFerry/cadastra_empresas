package br.com.study.gerenciador.controlador;

import static br.com.study.gerenciador.repositorio.Banco.getEmpresas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		List<Empresa> empresas = getEmpresas();
		request.setAttribute("empresas", empresas);

		return "forward:listaEmpresas.jsp";
	}
}
