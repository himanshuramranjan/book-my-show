package service;

import enums.City;
import model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    private final Map<City, List<Movie>> moviesCityMap;
    private final List<Movie> allMovies;

    public MovieController() {
        this.allMovies = new ArrayList<>();
        this.moviesCityMap = new HashMap<>();
    }

    public void addMovieToCity(Movie movie, City city) {
        if(!moviesCityMap.containsKey(city)) {
            moviesCityMap.put(city, new ArrayList<>());
        }
        addMovie(movie);
        this.moviesCityMap.get(city).add(movie);
    }

    public void removeMovieFromCity(Movie movie, City city) {
        this.moviesCityMap.get(city).remove(movie);
    }

    public void addMovie(Movie movie) {
        this.allMovies.add(movie);
    }

    public void removeMovie(Movie movie) {
        this.allMovies.remove(movie);
    }

    public List<Movie> getMoviesByCity(City city) {
        return moviesCityMap.get(city);
    }

    public Movie getMovieByName(String movieName) {
        for(Movie movie : allMovies) {
            if(movie.getMovieName().equals(movieName))
                return movie;
        }
        return null;
    }
    // To implement other CRUD ops for movieMap
}
