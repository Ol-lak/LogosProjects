package homework24;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Cinema {

    private TreeMap<Days, Schedule> schedules;
    private List<Movie> moviesLibrary;
    private Time open;
    private Time close;

    @Override
    public String toString() {
        return "Schedule on " +
                schedules +
                "\nMovies \n" +
                moviesLibrary;
    }

    public void addMovie(Movie movie, Time startMovie, Days day) throws TimeException {
        Schedule schedule = schedules.get(day);
        Schedule oldSchedule = schedules.get(day);
        Seance seance = new Seance(movie, startMovie);
        schedule.addSeance(seance);
        moviesLibrary.add(movie);
        schedules.replace(day, oldSchedule, schedule);
    }

    public void addSeance(Seance seance, String day) {
        Schedule schedule = schedules.get(Days.valueOf(day));
        Schedule oldSchedule = schedules.get(Days.valueOf(day));
        schedule.addSeance(seance);
        schedules.replace(Days.valueOf(day), oldSchedule, schedule);
    }

    public void removeMovie(Movie movie) {
        moviesLibrary.remove(movie);
        Collection<Schedule> values = schedules.values();
        Iterator<Schedule> scheduleIterator = values.iterator();
        while (scheduleIterator.hasNext()) {
            Schedule next = scheduleIterator.next();
            next.getSeances().removeIf(seance -> seance.getMovie().equals(movie));
        }
    }

    public void removeSeance(Seance seance, String day) {
        Schedule schedule = schedules.get(Days.valueOf(day));
        TreeSet<Seance> seances = schedule.getSeances();
        seances.removeIf(seance1 -> seance1.equals(seance));
    }

    public void showSchedules() {
        Set<Days> days = schedules.keySet();
        for (Days day : days) {
            System.out.println("Schedule on " + day + "\n" + "Movies");
            Schedule schedule = schedules.get(day);
            TreeSet<Seance> seances = schedule.getSeances();
            Iterator<Seance> seanceIterator = seances.iterator();
            while (seanceIterator.hasNext()) {
                System.out.println(seanceIterator.next());
            }
        }
    }

    public void showSchedulesOnSuchDay(Days day) throws TimeException {
        System.out.println("Schedule on " + (day) + "\n" + "Movies");
        Schedule schedule = schedules.get(day);
        TreeSet<Seance> seances = schedule.getSeances();
        Iterator<Seance> seanceIterator = seances.iterator();
        while (seanceIterator.hasNext()) {
            Seance next = seanceIterator.next();
            Movie movie = next.getMovie();
            Time startMovie = next.getStartMovie();
            Time endMovie = next.getEndMovie();
            System.out.println(movie.getTitle() +
                    ". Start: " + startMovie +
                    ". End: " + endMovie);
        }
    }

    public void showMovieLibrary() {
        Iterator<Movie> iterator = moviesLibrary.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
