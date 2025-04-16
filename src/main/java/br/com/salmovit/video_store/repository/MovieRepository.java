package br.com.salmovit.video_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.salmovit.video_store.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
