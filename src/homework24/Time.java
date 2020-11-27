package homework24;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Time {

    private int hour;
    private int min;

    public Time(int hour, int min) throws TimeException {
        if (hour > 24 || hour <= -1) {
            throw new TimeException();
        }
        if (min > 60 || min <= -1) {
            throw new TimeException();
        }
        this.hour = hour;
        this.min = min;
    }

    public Time plus(Time b) throws TimeException {
        int hour = this.getHour() + b.hour;
        int min = this.getHour() + b.min;
        if (min >= 60) {
            hour++;
            min -= 60;
        }
        if (hour >= 24) {
            hour -= 24;
        }
        return new Time(hour, min);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, min);
    }
}
