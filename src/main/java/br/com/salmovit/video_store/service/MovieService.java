package br.com.salmovit.video_store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.salmovit.video_store.entity.Movie;
import br.com.salmovit.video_store.exception.BadRequestException;
import br.com.salmovit.video_store.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository repository;
	
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	public List<Movie> list(){
		return repository.findAll();
	}
	
	public Movie create(Movie movie) {
		return repository.save(movie);
	}
	
	public Movie update(Long id, Movie movie) {
		repository.findById(id).ifPresentOrElse((existingMovie) -> {
			movie.setId(id);
			repository.save(movie);
		}, () -> {
			throw new BadRequestException("Movie %d does not exist." .formatted(id));
		});
		
		return movie;
	}
	
	public void delete(Long id) {
		repository.findById(id).ifPresentOrElse((existingMovie) -> {
			repository.delete(existingMovie);
		}, () -> {
			throw new BadRequestException("Movie %d does not exist." .formatted(id));
		});
		
	}
	
}
