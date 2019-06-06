package br.ifpe.web2.missao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_local")
public class LocalEventos {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@NotBlank(message = "O nome deve ser preenchido")
	private String nome;
	@NotBlank(message = "Informe um endereço válido")
	private String endereco;
	@NotEmpty(message = "Insira um link válido")
	private String linkMapa;
	@NotNull(message = "Informe uma quantidade")
	private int capacidade;
	private String ambiente;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLinkMapa() {
		return linkMapa;
	}
	public void setLinkMapa(String linkMapa) {
		this.linkMapa = linkMapa;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	
	
}
