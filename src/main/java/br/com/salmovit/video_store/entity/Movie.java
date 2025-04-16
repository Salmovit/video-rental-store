package br.com.salmovit.video_store.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	@NotNull
	Genre genre;
	@Column(name = "release_year")
	int releaseYear;
	
	public Movie() {
		
	}
	
	public Movie(Long id, String title, String description, Genre genre, int releaseYear) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}
	
	public Movie(String title, String description, Genre genre, int releaseYear) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, genre, id, releaseYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(description, other.description) && genre == other.genre && Objects.equals(id, other.id)
				&& releaseYear == other.releaseYear && Objects.equals(title, other.title);
	}
	
	
		
}
