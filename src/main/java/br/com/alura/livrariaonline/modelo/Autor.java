package br.com.alura.livrariaonline.modelo;

import java.time.LocalDate;

public class Autor {

	private int id;
	private String nome;
	private String email;
	private LocalDate datanascimento;
	private String minicurriculo;
	
	public Autor() {
		
	}
	
	public Autor(String nome, String email, LocalDate datanascimento, String minicurriculo) {
		this.nome = nome;
		this.email = email;
		this.datanascimento = datanascimento;
		this.minicurriculo = minicurriculo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getMinicurriculo() {
		return minicurriculo;
	}
	public void setMinicurriculo(String minicurriculo) {
		this.minicurriculo = minicurriculo;
	}

	@Override
	public String toString() {
		return "autor [id=" + id + ", nome=" + nome + ", email=" + email + ", datanascimento=" + datanascimento
				+ ", minicurriculo=" + minicurriculo + "]";
	}
		

}
