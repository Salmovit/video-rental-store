package br.com.salmovit.video_store;

import java.util.ArrayList;
import java.util.List;

import br.com.salmovit.video_store.entity.Genre;
import br.com.salmovit.video_store.entity.Movie;

public class TestConstants {
	public static final List<Movie> MOVIES = new ArrayList<>() {
		{
			add(new Movie(1001L, "Movie 1", "Desc movie 1", Genre.DRAMA, 2001));
			add(new Movie(1002L, "Movie 2", "Desc movie 2", Genre.HISTORICAL, 2005));
			add(new Movie(1003L, "Movie 3", "Desc movie 3", Genre.FANTASY, 2006));
			add(new Movie(1004L, "Movie 4", "Desc movie 4", Genre.ROMANCE, 2008));
			add(new Movie(1005L, "Movie 5", "Desc movie 5", Genre.SCIENCE_FICTION, 2010));
		}
	};
	
	public static final Movie MOVIE = MOVIES.get(0);

}
