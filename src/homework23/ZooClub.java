package homework23;

import java.util.*;

public class ZooClub {
    Map<Person, List<Pet>> club;

    public ZooClub() {
        club = new HashMap<>();
    }

    public void addMember(Person person, List<Pet> pets) {
        club.put(person, pets);
    }

    public void addPet(Person person, Pet pet) {
        List<Pet> pets = club.get(person);
        pets.add(pet);
    }

    public void deletePet(Person person, Pet pet) {
        List<Pet> pets = club.get(person);
        pets.remove(pet);
    }

    public void deleteMember(Person person) {
        club.remove(person);
    }

}
