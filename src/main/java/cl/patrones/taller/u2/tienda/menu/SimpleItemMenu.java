package cl.patrones.taller.u2.tienda.menu;

import java.util.ArrayList;
import java.util.List;

public class SimpleItemMenu implements ItemMenu {
    private String texto;
    private String slug;
    private String enlace;
    private List<SimpleItemMenu> hijos = new ArrayList<>();

    public SimpleItemMenu(String texto, String enlace, String slug) {
        this.texto = texto;
        this.enlace = enlace;
        this.slug = slug;
    }

    public void agregarHijo(SimpleItemMenu hijo) {
        hijos.add(hijo);
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    @Override
    public String getEnlace() {
        return enlace;
    }

    @Override
    public boolean tieneHijos() {
        return !hijos.isEmpty();
    }

    @Override
    public List<SimpleItemMenu> getHijos() {
        return hijos;
    }
} 