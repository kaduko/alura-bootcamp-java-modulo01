package br.com.alura.livrariaonline.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.livrariaonline.dao.AutorDao;
import br.com.alura.livrariaonline.factory.ConnectionFactory;
import br.com.alura.livrariaonline.modelo.Autor;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet{
	
	private AutorDao dao;
	
	public AutoresServlet () {
		this.dao = new AutorDao(new ConnectionFactory().getConnection());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		LocalDate datanascimento = LocalDate.parse(
				req.getParameter("datanascimento"),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String email = req.getParameter("email");
		String minicurriculo = req.getParameter("minicurriculo");
		Autor autor = new Autor (
				nome, 
				email, 
				datanascimento, 
				minicurriculo);
		
		dao.cadastrar(autor);
		
		resp.sendRedirect("autores");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("autores", dao.listar());
		
		req
		.getRequestDispatcher("WEB-INF/jsp/autores.jsp")
		.forward(req, resp);
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Transacao t1 = new Transacao (
//				"COCA34", 
//				new BigDecimal("10.12"), 
//				100, 
//				LocalDate.now(), 
//				TipoTransacao.COMPRA);
//		
//		Transacao t2 = new Transacao (
//				"GOGL32", 
//				new BigDecimal("25.25"), 
//				90, 
//				LocalDate.now(), 
//				TipoTransacao.COMPRA);
//		
//		transacoes.add(t1);
//		transacoes.add(t2);
//		
//		req.setAttribute("transacoes", transacoes);
//		
//		req
//		.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp")
//		.forward(req, resp);
//		;
//	}

}
