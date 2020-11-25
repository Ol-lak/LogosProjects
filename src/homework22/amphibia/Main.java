package homework22.amphibia;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Amphibian> optionalFrog = Optional.of(new Frog());

        optionalFrog.get().walk();
        optionalFrog.get().swim();
        optionalFrog.get().sleep();
        optionalFrog.get().eat();
    }
}
