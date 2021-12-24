package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Movie;
import com.example.demo.services.Services;
@RestController

@RequestMapping("api")

@CrossOrigin(origins = "http://localhost:8080")
public class MovieController {
 private final Services service;

	
	@Autowired
	public MovieController(Services service) {
	this.service=service;
	}
	

	
	public Services getService() {
		return service;
	}
		
	// metodo de inicio
	@GetMapping("/inicio")
	public String Init() {
		return service.init();
	}
			
	//metodo para mostrar las  peliculas
	@GetMapping("/movie")
	public List<Movie> getMovies(){
		return service.getMovies();
	}
		
	//metodo para generar  peliculas
	@PostMapping("/addMovie")
	public Movie createMovie(@RequestBody Movie movie){
			return service.createMovie(movie);
	}
		
	//metodo para eliminar las peliculas
	@DeleteMapping("/deleteMovie/{id}")
	public void deleteMovie( @PathVariable Integer id) {
			service.deleteMovie(id);
	}
	
	//metodo para actualizar las peliculas
	
	@PutMapping("/updateMovie/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
		return service.updateMovie(movie, id);
	}
		
		
	//metodo para buscar por id
	@GetMapping("/searchId/{id}")
	public Optional < Movie> findId(@PathVariable Integer id) {
		return service.findId(id);
	}
		
	//metodo para buscar por titulo
	@GetMapping("/searchTitle/{title}")
	public List <Movie> findTitle(@PathVariable String title ) {
		return service.findTitle(title);
	}
			
	//metodo para buscar las mas populares
	@GetMapping("/searchPopular/{title}")
		public List <Movie> findPopular( ) {
			return service.findPopular();
	}
			
	//metodo para buscar las peliculas por clasificacion
	@GetMapping("/searchClassified/{classified}")
	public List <Movie> findClass( @PathVariable String classified) {
		return service.findClass(classified);
	}
					
}
