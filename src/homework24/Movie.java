package homework24;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Setter
public class Movie {
    private String title;
    private Time duration;

    @Override
    public String toString() {
        return String.format("Movie: %s. Time duration:%2d:%02d", title, duration.getHour(), duration.getMin());
    }
}
