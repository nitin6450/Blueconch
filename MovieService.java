package com.six.jan;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieService {
	
static public 	HashMap
	<Movie, Integer > moviemap;
	public static void addKeyValuepairtomap(Movie movie ,int rating) {
		
		moviemap.put(movie, rating);
		
	}
	public static List<String> getHigherRatedMovieNames(int rating) {
		
		
		Map<Movie, Integer> result = moviemap.entrySet() 
		          .stream() 
		          .filter(map -> map.getValue() >=5)
		          .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));  
		  
		List<Movie> result3 = result.keySet().stream()
				.collect(Collectors.toList());
		
		List<String> Movienames = result3.stream()
			    .map( Movie::getMovieName)
			    .collect(Collectors.toList());
		Collections.sort(Movienames);
		
		return Movienames;
	}
	
	public static List<String> getMovieNamesOfSpecificGenre(String genre) {
		Map<Movie, Integer> result = moviemap.entrySet() 
		          .stream() 
		          .filter(map ->  genre.equals(map.getKey().getGenre()))
		          .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));  
		  
		List<Movie> generlist = result.keySet().stream()
				.collect(Collectors.toList());
		List<String> Movienames = generlist.stream()
			    .map( Movie::getMovieName)
			    .collect(Collectors.toList());
		return Movienames;
	}
	
	public static List<String> getSortedMovieListByReleaseDate() {
		
		  
		List<Movie> movielist = moviemap.keySet().stream()
				.collect(Collectors.toList());
		
		
		
		 Comparator<Movie> com= new Comparator<Movie>() {
			
			@Override
			public int compare(Movie o1, Movie o2) {
				// TODO Auto-generated method stub
				return o1.releaseDate.compareTo(o2.releaseDate);
			}
			
			
		};
		Collections.sort(movielist, com);
		List<String> Movienames = movielist.stream()
			    .map( Movie::getMovieName)
			    .collect(Collectors.toList());
		
		return Movienames;
		
	}
		
	
	public static void main(String args[]) {
		moviemap= new HashMap<>();
		addKeyValuepairtomap(new Movie(100,"Golmal","Comedy" ,"2016-11-11"),4);
		addKeyValuepairtomap(new Movie(100,"Article 15","Drama" ,"2018-11-11"),5);
		addKeyValuepairtomap(new Movie(100,"Baby","Action" ,"2019-11-11"),4);
		addKeyValuepairtomap(new Movie(100,"Friangi","Comedy" ,"2020-11-11"),5);
		
		addKeyValuepairtomap(new Movie(100,"Gabbar","Comedy" ,"2021-11-11"),6);
		
		System.out.println(getSortedMovieListByReleaseDate());
		System.out.println(getHigherRatedMovieNames(5));
System.out.println(getMovieNamesOfSpecificGenre("Comedy"));
		//System.out.println(moviemap);
	
	}
}
