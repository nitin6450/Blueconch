package com.six.jan;

import java.time.LocalDate;

public class Movie implements Comparable<Movie>{


public Movie(int movieId,  String movieName, String genre, String releaseDate) {
		super();
		this.movieId = movieId;
		//this.rating = rating;
		this.movieName = movieName;
		this.genre = genre;
		
		 LocalDate dt = LocalDate.parse(releaseDate);
	       
	       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	        //System.out.println(formatter.format(dt));
		this.releaseDate = dt;
	}

	

@Override
public String toString() {
	return "Movie [movieId=" + movieId  + ", movieName=" + movieName + ", genre=" + genre
			+ ", releaseDate=" + releaseDate + "]";
}
public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
int	movieId;
String  movieName;
String genre;
LocalDate releaseDate;
@Override
public int compareTo(Movie o) {
	// TODO Auto-generated method stub
	
	return 0;
	
	
} 
}
