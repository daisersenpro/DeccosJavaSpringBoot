package cl.patrones.taller.u2.catalogo.service;

import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;
import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.service.BodegajeService;
import cl.patrones.taller.u2.catalogo.repository.ClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvisoServiceImpl implements AvisoService {
    @Autowired
    private BodegajeService bodegajeService;
    @Autowired
    private ClasificacionRepository clasificacionRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Aviso> getAvisos() {
        return bodegajeService.getProductos().stream()
                .map(this::toAviso)
                .collect(Collectors.toList());
    }

    @Override
    public List<Aviso> getAvisosPorCategoria(Long categoriaId) {
        return bodegajeService.getProductos().stream()
                .filter(p -> clasificacionRepository.findFirstBySku(p.getSku())
                        .map(cl -> cl.getCategoria().getId().equals(categoriaId)).orElse(false))
                .map(this::toAviso)
                .collect(Collectors.toList());
    }

    private Aviso toAviso(Producto producto) {
        // Buscar la categoría asociada
        var clasificacion = clasificacionRepository.findFirstBySku(producto.getSku());
        Categoria categoria = clasificacion.map(cl -> cl.getCategoria()).orElse(null);
        // Calcular stock total
        int stock = producto.getStocks().stream().mapToInt(s -> s.getCantidad()).sum();
        // Calcular precio con 30% utilidad
        Long precio = Math.round(producto.getCosto() * 1.3);
        return new Aviso(
                producto.getId(),
                producto.getSku(),
                producto.getNombre(),
                precio,
                producto.getImagen(),
                stock,
                categoria
        );
    }
} 