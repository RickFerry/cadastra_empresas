package br.com.study.gerenciador;

import static br.com.study.gerenciador.Banco.bucaPorId;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 6088941803906214408L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Empresa empresa = bucaPorId(id);
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		dispatcher.forward(request, response);
	}
}
