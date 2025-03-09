package modules;

import enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    private final Map<City, List<Theatre>> cityTheatreMap;
    private final List<Theatre> allTheatres;

    public TheatreController() {
        this.allTheatres = new ArrayList<>();
        this.cityTheatreMap = new HashMap<>();
    }

    public void addTheatreToCity(Theatre theatre, City city) {
        this.cityTheatreMap.getOrDefault(city, new ArrayList<>()).add(theatre);
    }

    public void removeTheatreToCity(Theatre theatre, City city) {
        this.cityTheatreMap.get(city).remove(theatre);
    }

    public Map<Theatre, List<Show>> getAllShows(String movieName, City city) {
        Map<Theatre, List<Show>> theatreShowMap = new HashMap<>();
        List<Theatre> theatres = cityTheatreMap.get(city);

        for(Theatre theatre : theatres) {
            List<Show> showList = new ArrayList<>();

            for(Show show : theatre.getShows()) {
                if(show.getMovie().getMovieName().equals(movieName)) {
                    showList.add(show);
                }
            }
            theatreShowMap.put(theatre, showList);
        }

        return theatreShowMap;
    }

    public List<Theatre> getAllTheatres() {
        return allTheatres;
    }

    public void addTheatre(Theatre theatre) {
        this.allTheatres.add(theatre);
    }

    public void removeTheatre(Theatre theatre) {
        this.allTheatres.remove(theatre);
    }
}
