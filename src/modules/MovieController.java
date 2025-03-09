package modules;

import enums.City;

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
        this.moviesCityMap.getOrDefault(city, new ArrayList<>()).add(movie);
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

    // To implement other CRUD ops for movieMap
}
