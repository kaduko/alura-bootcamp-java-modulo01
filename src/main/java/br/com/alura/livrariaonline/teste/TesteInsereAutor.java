package br.com.alura.livrariaonline.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.livrariaonline.dao.AutorDao;
import br.com.alura.livrariaonline.modelo.Autor;

public class TesteInsereAutor {
	public static void main(String[] args) {
		
		try {
			String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
			String usuario = "livraria";
			String senha="livraria";
			
			Connection conexao;
			conexao = DriverManager.getConnection(url, usuario, senha);
			
			AutorDao dao = new AutorDao(conexao);
			
			Autor a = new Autor (
					"Teste da Silva",
					"teste@teste.com.br",
					LocalDate.now(),
					"Teste Autor da Silva");
			dao.cadastrar(a);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro!");
		}
	}
}
