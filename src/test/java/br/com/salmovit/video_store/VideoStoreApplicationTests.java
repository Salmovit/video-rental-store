package br.com.salmovit.video_store;

import static br.com.salmovit.video_store.TestConstants.MOVIE;
import static br.com.salmovit.video_store.TestConstants.MOVIES;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.salmovit.video_store.entity.Genre;
import br.com.salmovit.video_store.entity.Movie;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("/remove.sql")
class VideoStoreApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void testCreateMovieSuccess() {
		var movie = new Movie("Movie test", "Desc movie 1", Genre.DRAMA, 2025);
		
		webTestClient
			.post()
			.uri("/movies")
			.bodyValue(movie)
			.exchange()
			.expectStatus().isCreated()
			.expectBody()
			//.jsonPath("$").isArray()
			//.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$.title").isEqualTo(movie.getTitle())
			.jsonPath("$.description").isEqualTo(movie.getDescription())
			.jsonPath("$.genre").isEqualTo(movie.getGenre())
			.jsonPath("$.releaseYear").isEqualTo(movie.getReleaseYear());
	}
	
	@Test
	void testCreateMovieFailure() {
		
		webTestClient
			.post()
			.uri("/movies")
			.bodyValue(
					new Movie ("", "", Genre.ACTION, 2025))
			.exchange()
			.expectStatus().isBadRequest();
	}
	
	@Sql("/import.sql")
	@Test
	void testUpdateMovieSuccess() {
		var movie = new Movie(MOVIE.getId(), MOVIE.getTitle() + " update", MOVIE.getDescription() + " update", MOVIE.getGenre(), 
				MOVIE.getReleaseYear());
		
		webTestClient
			.put()
			.uri("/movies/" + MOVIE.getId())
			.bodyValue(movie)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$.title").isEqualTo(movie.getTitle())
			.jsonPath("$.description").isEqualTo(movie.getDescription())
			.jsonPath("$.genre").isEqualTo(movie.getGenre())
			.jsonPath("$.releaseYear").isEqualTo(movie.getReleaseYear());
	}
	
	@Test
	void testUpdateMovieFailure() {
		var badId = 1L;
		
		webTestClient
			.put()
			.uri("/movies/" + badId)
			.bodyValue(
					new Movie(badId, "", "", Genre.ROMANCE, 2000))
			.exchange()
			.expectStatus().isBadRequest();
			
	}
	
	@Sql("/import.sql")
	@Test
	void testDeleteMovieSuccess() {
		
		webTestClient
			.delete()
			.uri("/movies/" + MOVIES.get(0).getId())
			.exchange()
			.expectStatus().isOk();
			
	}
	
	@Test
	void testDeleteMovieFailure() {
		var badId = 1L;
		
		webTestClient
			.delete()
			.uri("/movies/" + badId)
			.exchange()
			.expectStatus().isBadRequest();
			
	}
	
	@Sql("/import.sql")
	@Test
	void testListMovies() throws Exception {
		
		webTestClient
			.get()
			.uri("/movies")
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(5)
			.jsonPath("$[0]").isEqualTo(MOVIES.get(0))
			.jsonPath("$[1]").isEqualTo(MOVIES.get(1))
			.jsonPath("$[2]").isEqualTo(MOVIES.get(2))
			.jsonPath("$[3]").isEqualTo(MOVIES.get(3))
			.jsonPath("$[4]").isEqualTo(MOVIES.get(4));
					
	}

}
