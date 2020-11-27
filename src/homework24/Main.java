package homework24;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws TimeException {

        TreeSet<Seance> seances = new TreeSet<>();
        List<Movie> movieLibrary = new ArrayList<>();
        Time duration = new Time(1, 35);
        Time duration1 = new Time(1, 50);
        Time duration2 = new Time(2, 15);
        Movie movie = new Movie("Hello World", duration);
        Movie movie1 = new Movie("Hong Kong", duration1);
        Movie movie2 = new Movie("The Hundred", duration2);
        movieLibrary.add(movie);
        movieLibrary.add(movie1);
        movieLibrary.add(movie2);
        Time startMovie = new Time(12, 30);
        Time startMovie1 = new Time(17, 20);
        Time startMovie2 = new Time(13, 40);
        Seance seance = new Seance(movie, startMovie);
        Seance seance1 = new Seance(movie, startMovie1);
        seances.add(seance);
        seances.add(seance1);
        Schedule schedule = new Schedule(seances);
        Time open = new Time(9, 0);
        Time close = new Time(23, 30);
        TreeMap<Days, Schedule> schedules = new TreeMap<>();
        schedules.put(Days.TUESDAY, schedule);
        Seance seance2 = new Seance(movie, startMovie2);
        Schedule schedule1 = new Schedule(seances);
        schedule1.addSeance(seance2);
        schedules.put(Days.SUNDAY, schedule1);
        Cinema cinema = new Cinema(schedules, movieLibrary, open, close);
        cinema.addMovie(new Movie("King Artur", new Time(1, 35)), new Time(17, 45), Days.SUNDAY);
        cinema.showSchedules();
    }
}
