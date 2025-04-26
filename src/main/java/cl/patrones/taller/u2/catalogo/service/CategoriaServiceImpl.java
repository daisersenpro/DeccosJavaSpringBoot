package cl.patrones.taller.u2.catalogo.service;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;
import cl.patrones.taller.u2.tienda.menu.SimpleItemMenu;
import cl.patrones.taller.u2.tienda.menu.util.Slugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> getCategorias() {
		return (List<Categoria>) categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> getCategoriaPorId(Long id) {
		return categoriaRepository.findById(id);
	}

	// Método para el menú dinámico
	public List<SimpleItemMenu> obtenerMenuCategorias() {
		List<Categoria> categoriasPrincipales = categoriaRepository.findByCategoriaPadreIsNull();
		return categoriasPrincipales.stream()
				.map(this::convertirAItemMenu)
				.collect(Collectors.toList());
	}

	private SimpleItemMenu convertirAItemMenu(Categoria categoria) {
		String slug = Slugger.toSlug(categoria.getNombre());
		SimpleItemMenu item = new SimpleItemMenu(categoria.getNombre(), "/categoria/" + categoria.getId() + "/" + slug, slug);
		List<Categoria> subcategorias = categoriaRepository.findByCategoriaPadreId(categoria.getId());
		subcategorias.forEach(sub -> {
			String subSlug = Slugger.toSlug(sub.getNombre());
			item.agregarHijo(new SimpleItemMenu(sub.getNombre(), "/categoria/" + sub.getId() + "/" + subSlug, subSlug));
		});
		return item;
	}
}