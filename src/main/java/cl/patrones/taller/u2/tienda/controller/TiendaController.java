package cl.patrones.taller.u2.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cl.patrones.taller.u2.catalogo.service.AvisoService;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class TiendaController {
	
	@Autowired
	private AvisoService avisoService;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("avisos", avisoService.getAvisos());
		return "inicio";
	}
		
	@GetMapping("/categoria/{categoriaId}/{slug}")
	public String categoria(
			@PathVariable(name = "categoriaId") Long categoriaId,
			@PathVariable(name = "slug") String slug,
			Model model
	) {
		model.addAttribute("avisos", avisoService.getAvisosPorCategoria(categoriaId));
		Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);
		model.addAttribute("categoria", categoria);
		return "categoria";
	}
	
	@GetMapping("/ingresar")
	public String login() {
		return "login";
	}
	
	@GetMapping("/ubicacion")
	public String ubicacion() {return "ubicacion";}
	
	@GetMapping("/contacto")
	public String contacto() {return "contacto";}
	
}
