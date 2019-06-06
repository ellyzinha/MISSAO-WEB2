package br.ifpe.web2.missao;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class IndexController {
	
	
	//Página Inicial
	@GetMapping("/ind")
	public String index() {
		return "index";
	}
	
	//Cadastrar Senha
	
	@GetMapping("/cad")
	public String cadastro() {
		return "cadastro";
	}
	
	// Alterar Senha
	@GetMapping("/alt")
	public String alterar() {
		return "alterar";
	}
	
	//Exibir Página de Convidados
	
	@GetMapping("/conv")
	public String convidados() {
		return "ListaConvidados";
	}
	

}
