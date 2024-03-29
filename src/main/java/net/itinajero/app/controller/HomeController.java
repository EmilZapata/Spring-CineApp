package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = getLista();
		List<String> listaFechas = Utileria.getNextDays(4);

		System.out.println(listaFechas);
//		peliculas.add("Rapido y furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);

		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		List<Pelicula> peliculas = getLista();
		List<String> listaFechas = Utileria.getNextDays(4);

		System.out.println(listaFechas);

		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);

		return "home";
	}

	// @RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	// public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula,
	// @PathVariable("fecha") String fecha) {
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula,
			@RequestParam("fecha") String fecha) {
		System.out.println("id => " + idPelicula);
		System.out.println("Fecha => " + fecha);

		// TODO: Buscar en la base de datos los horarios

		String titutoPelicula = "Rapidos y furiosos";
		int duracion = 136;
		double precioEntrada = 50;

		model.addAttribute("titulo", titutoPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);

		return "detalle";
	}

	private List<Pelicula> getLista() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;

		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("16-11-2019"));

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(120);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("15-11-2019"));
			pelicula2.setImagen("estreno2.png");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(120);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("17-11-2019"));
			pelicula3.setImagen("estreno3.png");

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Contratiempo");
			pelicula4.setDuracion(120);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Thriller");
			pelicula4.setFechaEstreno(formatter.parse("17-11-2019"));
			pelicula4.setImagen("estreno4.png");
			pelicula4.setEstatus("Inactiva");

			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);

			return lista;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}

}
