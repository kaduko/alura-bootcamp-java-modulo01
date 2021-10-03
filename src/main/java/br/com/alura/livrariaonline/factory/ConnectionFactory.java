package br.com.alura.livrariaonline.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection(){
		try {
			String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
			String usuario = "livraria";
			String senha="livraria";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexao;
			conexao = DriverManager.getConnection(url, usuario, senha);
			
			return conexao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
