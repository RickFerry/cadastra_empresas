package br.com.study.gerenciador.servico;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.study.gerenciador.modelo.Empresa;
import br.com.study.gerenciador.repositorio.EmpresaRepository;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = -8222350379531556366L;

	private EmpresaRepository empresaRepository;

	public EmpresaService() {
		empresaRepository = new EmpresaRepository();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String header = request.getHeader("Accept");
		if (header.contains("xml")) {
			XStream stream = new XStream();
			stream.alias("empresa", Empresa.class);
			response.setContentType("application/xml");
			try {
				response.getWriter().print(stream.toXML(empresaRepository.buscaEmpresas()));
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		} else if (header.contains("json")) {
			response.setContentType("application/json");
			try {
				response.getWriter().print(new Gson().toJson(empresaRepository.buscaEmpresas()));
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'No content!'}");
		}
	}
}
