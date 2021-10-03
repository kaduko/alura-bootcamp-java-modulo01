package br.com.alura.livrariaonline.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.livrariaonline.dao.AutorDao;
import br.com.alura.livrariaonline.modelo.Autor;

public class TesteSelectAutores {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
			String usuario = "livraria";
			String senha="livraria";
			
			Connection conexao;
			conexao = DriverManager.getConnection(url, usuario, senha);
			
			AutorDao dao = new AutorDao(conexao);
			
			List<Autor> autores = dao.listar();
			
			autores.forEach(System.out::println);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro!");
		}
	}
}
