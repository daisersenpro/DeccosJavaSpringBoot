package cl.patrones.taller.u2.catalogo.service;

import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import java.util.List;

public interface AvisoService {
    List<Aviso> getAvisos();
    List<Aviso> getAvisosPorCategoria(Long categoriaId);
} 