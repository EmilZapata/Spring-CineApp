package net.itinajero.app.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pelicula {
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png";// imagen por default
	private Date fechaEstreno;
	private String estatus = "Activa";

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion=" + clasificacion
				+ ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno + ", estatus=" + estatus + "]";
	}
}
