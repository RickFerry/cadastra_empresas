package br.com.study.gerenciador.servico;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.study.gerenciador.modelo.Empresa;
import br.com.study.gerenciador.repositorio.Banco;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = -8222350379531556366L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String header = request.getHeader("Accept");
		if (header.contains("xml")) {
			XStream stream = new XStream();
			stream.alias("empresa", Empresa.class);
			response.setContentType("application/xml");
			response.getWriter().print(stream.toXML(Banco.getEmpresas()));
		} else if (header.contains("json")) {
			response.setContentType("application/json");
			response.getWriter().print(new Gson().toJson(Banco.getEmpresas()));
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'No content!'}");
		}
	}
}
