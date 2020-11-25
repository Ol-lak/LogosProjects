package homework22.pet;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Pet> optionalCat = Optional.of(new Cat());
        Optional<Pet> optionalDog = Optional.of(new Dog());
        Optional<Pet> optionalCow = Optional.of(new Cow());

        optionalCat.get().voice();
        optionalDog.get().voice();
        optionalCow.get().voice();
    }
}
