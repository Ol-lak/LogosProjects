package homework15;

import java.util.*;

public class ZooClub {
    Map<Person, List<Pet>> club;

    public ZooClub() {
        club = new HashMap<>();
    }

    public void addMember(Person person, List<Pet> pets) {
        club.put(person, pets);
    }

    public void addPet(Person person,Pet pet) {
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

    public void deletePetFromAllMembers(String type) {
        Set<Person> people = club.keySet();
        Collection<List<Pet>> pets = new ArrayList<>();
        for (Person person : people) {
            pets.add(club.get(person));
        }
        Iterator<List<Pet>> iterator = pets.iterator();
        while (iterator.hasNext()) {
            List<Pet> next = iterator.next();
            next.removeIf(p -> p.getType().equals(type));
        }
    }

    public void printZooClubMember() {
        Set<Map.Entry<Person, List<Pet>>> entries = club.entrySet();
        Iterator<Map.Entry<Person, List<Pet>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, List<Pet>> member = iterator.next();
            System.out.println("Person: " + member.getKey() + "\nPets:" + member.getValue());
        }
    }
}
