package homework24;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@EqualsAndHashCode
public class Seance implements Comparable<Seance> {
    private Movie movie;
    private Time startMovie;
    private Time endMovie;

    public Seance(Movie movie, Time startMovie) throws TimeException {
        this.movie = movie;
        this.startMovie = startMovie;
        this.endMovie = startMovie.plus(movie.getDuration());
    }

    @SneakyThrows
    @Override
    public String toString() {
        return "Movie: " + movie +
                ". Start: " + startMovie +
                ", end: " + endMovie;
    }

    @Override
    public int compareTo(Seance o) {
        int hourComp = this.startMovie.getHour() - o.startMovie.getHour();
        if (hourComp == 0) {
            int minComp = startMovie.getMin() - o.startMovie.getMin();
            if (minComp == 0) {
                return movie.getTitle().compareTo(o.getMovie().getTitle());
            } else {
                return minComp;
            }
        }
        return hourComp;
    }
}
