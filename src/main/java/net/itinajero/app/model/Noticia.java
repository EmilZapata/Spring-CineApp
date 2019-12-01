package net.itinajero.app.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Noticia {
	private int id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;

	public Noticia() {
		this.fecha = new Date();
		this.estatus = "Activa";
	}

}
