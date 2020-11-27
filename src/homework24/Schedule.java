package homework24;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.TreeSet;
@Getter
@EqualsAndHashCode
public class Schedule {
    private TreeSet<Seance> seances;

    public Schedule(TreeSet<Seance> seances) {
        this.seances = seances;
    }

    public void addSeance(Seance seance) {
        seances.add(seance);
    }

    public void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "seances=" + seances +
                '}' + "\n";
    }
}
