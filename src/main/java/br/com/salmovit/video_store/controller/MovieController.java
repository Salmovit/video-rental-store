package br.com.salmovit.video_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salmovit.video_store.entity.Movie;
import br.com.salmovit.video_store.service.MovieService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@GetMapping
	public List<Movie> list() {
		return service.list();
		
	}
	
	@PostMapping
	public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.create(movie));
		
	}
	
	@PutMapping("/{id}")
	public Movie update(@PathVariable Long id, @RequestBody Movie movie){
		return service.update(id, movie);
		
	}
		
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

}
