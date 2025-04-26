package cl.patrones.taller.u2.tienda.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.patrones.taller.u2.tienda.menu.ItemMenu;
import cl.patrones.taller.u2.catalogo.service.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import cl.patrones.taller.u2.tienda.menu.SimpleItemMenu;

@ControllerAdvice
public class MenuControllerAdvice {

	@Autowired
	private CategoriaServiceImpl categoriaService;

	@ModelAttribute("menu")
	public List<ItemMenu> menu() {
		List<ItemMenu> menu = new ArrayList<>();
		// Inicio
		menu.add(new SimpleItemMenu("Inicio", "/", "inicio"));
		// Categorías con submenú dinámico
		SimpleItemMenu categorias = new SimpleItemMenu("Categorías", "#", "categorias");
		categorias.getHijos().addAll(categoriaService.obtenerMenuCategorias());
		menu.add(categorias);
		// Ubicación
		menu.add(new SimpleItemMenu("Ubicación", "/ubicacion", "ubicacion"));
		// Contacto
		menu.add(new SimpleItemMenu("Contacto", "/contacto", "contacto"));
		return menu;
	}
	
}
