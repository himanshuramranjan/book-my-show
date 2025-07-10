package model;

import enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String theatreId;
    private String address;
    private final City city;
    private final List<Screen> screens;
    private final List<Show> shows;

    public Theatre(String theatreId, City city, String address) {
        this.theatreId = theatreId;
        this.city = city;
        this.address = address;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }

    public void removeShow(Show show) {
        this.shows.remove(show);
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public void removeScreen(Screen screen) {
        this.screens.remove(screen);
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getAddress() {
        return address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public String getCity() {
        return city.getValue();
    }
}
