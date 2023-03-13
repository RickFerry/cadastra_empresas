package br.com.study.gerenciador.controller;

import static br.com.study.gerenciador.repository.Banco.bucaPorId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;
import br.com.study.gerenciador.model.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Empresa empresa = bucaPorId(id);

		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
	}
}
