package br.com.study.gerenciador.controlador;

import static br.com.study.gerenciador.repositorio.Banco.remove;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		remove(id);

		return "redirect:entrada?acao=ListaEmpresas";
	}
}
