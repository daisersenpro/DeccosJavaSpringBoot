package cl.patrones.taller.u2.catalogo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String slug;

	@ManyToOne
	@JoinColumn(name = "categoria_padre_id")
	private Categoria categoriaPadre;
}