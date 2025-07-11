import enums.City;
import enums.SeatCategory;
import model.*;
import service.BookingService;
import service.MovieController;
import service.PaymentService;
import service.TheatreController;

import java.awt.print.Book;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShowApplication {

    public volatile static BookMyShowApplication bookMyShowApplication;
    MovieController movieController;
    TheatreController theatreController;
    BookingService bookingService;
    private BookMyShowApplication() {
        movieController = new MovieController();
        theatreController = new TheatreController();
        bookingService = new BookingService(new PaymentService());
    }

    public static BookMyShowApplication getInstance() {
        if(bookMyShowApplication == null) {
            synchronized (BookMyShowApplication.class) {
                if(bookMyShowApplication == null) {
                    bookMyShowApplication = new BookMyShowApplication();
                }
            }
        }
        return bookMyShowApplication;
    }


    public static void main(String args[]) {

        BookMyShowApplication bookMyShow = BookMyShowApplication.getInstance();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
        //user2
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");

    }

    private void createBooking(City userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(City.BANGALORE);

        //2. select the movie which you want to see.
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShows(interestedMovie.getMovieName(), userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        String seatNumber = "3A";
        List<Seat> listOfSeats = new ArrayList<>();

        for(Seat seat : interestedShow.getScreen().getSeats()) {
            if (seat.getSeatLoc().equals(seatNumber)) {
                listOfSeats.add(seat);
            }
        }
        Booking booking = bookingService.bookSeats(interestedShow, listOfSeats);

        if(booking != null) {
            System.out.println("Booking is done");
            System.out.println(booking.getBookingInformation());
        }

    }

    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    //creating 2 theatre
    private void createTheatre() {

        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre("1", City.BANGALORE, "MG Road");
        List<Screen> inoxScreens = createScreen();
        inoxTheatre.addScreen(inoxScreens.get(0));

        Show inoxMorningShow = createShows(inoxTheatre.getScreens().get(0), avengerMovie, LocalDateTime.now());
        Show inoxEveningShow = createShows(inoxTheatre.getScreens().get(0), baahubali, LocalDateTime.now());
        inoxTheatre.addShow(inoxMorningShow);
        inoxTheatre.addShow(inoxEveningShow);


        Theatre pvrTheatre = new Theatre("2", City.DELHI, "Cannaut Palace");
        List<Screen> pvrScreens = createScreen();
        pvrTheatre.addScreen(pvrScreens.get(0));
        Show pvrMorningShow = createShows(pvrTheatre.getScreens().get(0), avengerMovie, LocalDateTime.now());
        Show pvrEveningShow = createShows(pvrTheatre.getScreens().get(0), baahubali, LocalDateTime.of(2025, 7, 10, 21, 0));
        pvrTheatre.addShow(pvrMorningShow);
        pvrTheatre.addShow(pvrEveningShow);

        theatreController.addTheatre(inoxTheatre, City.BANGALORE);
        theatreController.addTheatre(pvrTheatre, City.DELHI);

    }

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen(1, createSeats());
        screens.add(screen1);

        return screens;
    }

    private Show createShows(Screen screen, Movie movie, LocalDateTime showStartTime) {
        return new Show(movie, screen, showStartTime);
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        List<Seat> seats = new ArrayList<>();

        //SILVER SEATS
        for (int i = 1; i <= 30; i++) {
            Seat seat = new Seat(i+"", i + "A", SeatCategory.SILVER);
            seats.add(seat);
        }

        //SILVER SEATS
        for (int i = 1; i <= 30; i++) {
            Seat seat = new Seat(i+"", i + "B", SeatCategory.GOLD);
            seats.add(seat);
        }

        //PLATINUM SEATS
        for (int i = 1; i <= 30; i++) {
            Seat seat = new Seat(i+"", i + "C", SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie avengers = new Movie("AVENGERS", 128, 500);

        //create Movies2
        Movie baahubali = new Movie("BAAHUBALI", 180, 300);

        //add movies against the cities
        movieController.addMovieToCity(avengers, City.BANGALORE);
        movieController.addMovieToCity(avengers, City.DELHI);
        movieController.addMovieToCity(baahubali, City.BANGALORE);
        movieController.addMovieToCity(baahubali, City.DELHI);
    }

}