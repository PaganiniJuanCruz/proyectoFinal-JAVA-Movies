package com.example.demo.services;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.models.Movie;
import com.example.demo.repo.MovieRepo;

@Service
public class Services {
	
	
	private final MovieRepo movieRepository;
	@Autowired
	public Services( MovieRepo movieRepository){
	this.movieRepo = movieRepo;
	}
	
	//TITULO
	public String init() {
		return "<h1>Bienvenido a mi API de Peliculas<h1>";
	};
	
	//para Leer el listado de peliculas

	public List<Movie> getMovies() {
		return movieRepo.findAll();
		}
	
	//agregar una pelicula
	public Movie createMovie(Movie movie) {
	return movieRepo.save(movie);	
	}
	
	//borrar peliculas
	public void deleteMovie(Integer id) {
		movieRepo.deleteById(id);
		}

		//actualizar la pelicula
	public Movie  updateMovie(Movie movie, Integer id){

			Optional<Movie> peliuptade = movieRepo.findById(id);

			if (!peliuptade.isEmpty()) {
				return movieRepo.save(movie);
			}else {
				throw new RuntimeException("Movie not found");
			}
			}
	
		//buscar por id
		public Optional <Movie> findId(Integer id) {
			return movieRepo.findById(id);
			}
		
		//buscar por titulo
		public List<Movie> findTitle(String title) {
			return movieRepo.findTitle(title);
		}
		
		//buscar por popular
		public List<Movie> findPopular() {
			return movieRepo.findPopular(PageRequest.of(0,3));
		}
		
		//buscar por clasificacion de pelicula

		public List<Movie> findClass(String classified) {
			return movieRepo.findClass(classified);
		}
		
}
