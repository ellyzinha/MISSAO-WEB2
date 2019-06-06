package br.ifpe.web2.missao;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Eventos {
	
	@Id @GeneratedValue
	private Integer codigo;
	@NotBlank(message = "O nome deve ser preenchido")
	private String nome;
	private String descricaoEvento;
	@FutureOrPresent(message ="Informe uma data válida" )
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date data;
	@Min(value = 10, message = "A quantidade deve ser maior que 10 convidados")
	@NotNull
	private int quantMaxConvidados;
	@NotBlank(message = "Informe o nome do responsável ")
	private String nomeResp;
	@NotBlank(message = "Informe um telefone")
	private String telResp;
	@Min(value = 1, message = "A hora deve ser informada")
	@NotNull
	private int duracaoHoras;
	@ManyToOne
	private LocalEventos localEventos;
	
	
	
	
	public LocalEventos getLocalEventos() {
		return localEventos;
	}
	public void setLocalEventos(LocalEventos localEventos) {
		this.localEventos = localEventos;
	}
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
	public String getDescricaoEvento() {
		return descricaoEvento;
	}
	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQuantMaxConvidados() {
		return quantMaxConvidados;
	}
	public void setQuantMaxConvidados(int quantMaxConvidados) {
		this.quantMaxConvidados = quantMaxConvidados;
	}
	public String getNomeResp() {
		return nomeResp;
	}
	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}
	public String getTelResp() {
		return telResp;
	}
	public void setTelResp(String telResp) {
		this.telResp = telResp;
	}
	public int getDuracaoHoras() {
		return duracaoHoras;
	}
	public void setDuracaoHoras(int duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}
	
	

}
