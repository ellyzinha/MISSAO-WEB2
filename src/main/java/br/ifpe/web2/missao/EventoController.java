package br.ifpe.web2.missao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EventoController {
	
	@Autowired
	private EventoDAO eventosRep;
	@Autowired
	private LocalDAO localRep;
	

	//Exibir a Página de Formulário de cadastro dos eventos
			@GetMapping("/cadastrarEventos")
			public ModelAndView exibirAddEvento() {
				ModelAndView mv = new ModelAndView("cadastroEventos");
				mv.addObject("eventos", new Eventos());
				mv.addObject("listaLocal",localRep.findAll());
				return mv;
			}
			
			// Cadastro das informações do Formulário no banco
			@PostMapping("/addEventos")
			public ModelAndView addEventos (@Valid Eventos eventos, BindingResult br) {
				ModelAndView mv = new ModelAndView("/cadastroEventos");
				mv.addObject("listaEventos", eventosRep.findAll());
				if (br.hasErrors()) {
					return mv;
				}
				this.eventosRep.save(eventos);
				return listar();
			}
			
			//Listar os eventos cadastrados
			@GetMapping("/listarEventos")
			public ModelAndView listar() {
				ModelAndView mv = new ModelAndView("/ListaEventos");
				mv.addObject("lista",eventosRep.findAll());
				mv.addObject("listaLocal",localRep.findAll());
				return mv;
			}
			
			//Editar os eventos já cadastrados
			@GetMapping("/editarEvento")
			public ModelAndView editar(@RequestParam Integer codigo) {
				ModelAndView mv = new ModelAndView("/cadastroEventos");
				mv.addObject("eventos",eventosRep.getOne(codigo));
				mv.addObject("listaLocal",localRep.findAll());
				return mv;
			}
			
			//Remover eventos cadastrados
			@GetMapping("/removerEvento")
			public ModelAndView remover(@RequestParam Integer codigo) {
				eventosRep.deleteById(codigo);
				return listar();
			}
			
			//Pesquisar Eventos
			@PostMapping("/eventos")
			public ModelAndView pesquisarEventos(@RequestParam(required = false) String nomePesquisa) {
				ModelAndView mv = new ModelAndView("/ListaEventos");
				
				List<Eventos> listaEventos;
				if (nomePesquisa == null || nomePesquisa.trim().isEmpty()) {
					listaEventos = this.eventosRep.findAll(Sort.by("nome"));
				}else {
					listaEventos = this.eventosRep.findByNomeContainingIgnoreCase(nomePesquisa);
				}
				
				mv.addObject("lista" , listaEventos);
				return mv;
			}
			
			

}
