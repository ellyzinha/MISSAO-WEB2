package br.ifpe.web2.missao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocalController {
	
	@Autowired
	private LocalDAO localRep;
	
	@GetMapping("/cadLocais")
	public ModelAndView exibirAddLocal() {
		ModelAndView mv = new ModelAndView("/cadastroLocal");
		mv.addObject("localEventos", new LocalEventos());
		return mv;
	}
	
	@PostMapping("/addLocal")
	public ModelAndView salvar(@Valid LocalEventos local, BindingResult br) {
		ModelAndView mv = new ModelAndView("/cadastroLocal");
		mv.addObject("listaLocal", localRep.findAll());
		if (br.hasErrors()) {
			return mv;
		}
		
		this.localRep.save(local);
		return listar();
		
	}
		
	@GetMapping("/listarLocal")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/LocalEventos");
		mv.addObject("lista", localRep.findAll());
		return mv;
	}
	
	

}
