package br.com.study.gerenciador.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.gerenciador.contrato.Acao;

public class NovaEmpresaForm implements Acao {

	private static final String FORM_NOVA_EMPRESA = "forward:formNovaEmpresa.jsp";

	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_NOVA_EMPRESA;
	}
}
