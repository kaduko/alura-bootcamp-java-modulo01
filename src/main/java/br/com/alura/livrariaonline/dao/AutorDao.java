package br.com.alura.livrariaonline.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.livrariaonline.modelo.Autor;

public class AutorDao {
	private Connection conexao;
	
	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar (Autor autor) {
		try {		
			String sql = "insert into autor (nome, email, datanascimento, minicurriculo) values (?,?,?,?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, autor.getNome());			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getDatanascimento()));
			ps.setString(4, autor.getMinicurriculo());
			
			ps.execute();
			
			System.out.println("Insert realizado com sucesso.");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List <Autor> listar (){
		try {
			
			String sql = "select * from autor";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql);
			
			List<Autor> autores = new ArrayList<Autor>();
			
			while (rs.next()) {
				Autor a = new Autor();
				
				System.out.println(rs.getLong("id"));
				a.setNome(rs.getString("nome"));
				a.setEmail(rs.getString("email"));
				a.setDatanascimento(rs.getDate("datanascimento").toLocalDate());
				a.setMinicurriculo(rs.getString("minicurriculo"));
				
				autores.add(a);
			}

			return autores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
