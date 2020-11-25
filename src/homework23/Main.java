package homework23;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ZooClub zooClub = new ZooClub();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 'help' to get all abilities:");
        while (true) {
            System.out.println("Input instruction");
            String str = sc.next();
            switch (str) {
                case "help":
                    System.out.println("Type 'addMember' to add new Zoo zooClub member;");
                    System.out.println("Type 'addPet' to add a new pet to zooClub member ");
                    System.out.println("Type 'deletePet' to delete a pet from zooClub member ");
                    System.out.println("Type 'deleteMember' to delete a member from zooClub ");
                    System.out.println("Type 'deletePetFromAll' to delete a specific type of pet from all zooClub members");
                    System.out.println("Type 'showMembers' to show all zooClub members");
                    System.out.println("Type 'exit' to exit from program");
                    break;
                case "addMember":
                    System.out.println("Input your name:");
                    String name = sc.next();
                    System.out.println("Input your age:");
                    int age = sc.nextInt();
                    Person person = new Person(name, age);
                    System.out.println("How many pets do you have?");
                    int count = sc.nextInt();
                    List<Pet> pets = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Input pet type:");
                        String type = sc.next();
                        System.out.println("Input pet name:");
                        String petName = sc.next();
                        Pet p = new Pet(type, petName);
                        pets.add(p);
                    }
                    zooClub.addMember(person, pets);
                    break;
                case "addPet": {
                    System.out.println("Input your name:");
                    String personName = sc.next();
                    Person temp = null;
                    for (Person p : zooClub.club.keySet()) {
                        if (p.getName().equals(personName)) {
                            temp = p;
                        }
                    }
                    if (temp != null) {
                        System.out.println("Input pet type:");
                        String petType = sc.next();
                        System.out.println("Input pet name:");
                        String petName = sc.next();
                        Pet pet = new Pet(petType, petName);
                        zooClub.addPet(temp, pet);
                    } else {
                        System.out.println("Dont find member with this name.");
                        break;
                    }
                    break;
                }
                case "deletePet":
                    System.out.println("Input your name:");
                    String personName = sc.next();
                    Person temp = null;
                    for (Person p : zooClub.club.keySet()) {
                        if (p.getName().equals(personName)) {
                            temp = p;
                        }
                    }
                    if (temp != null) {
                        List<Pet> pets1 = zooClub.club.get(temp);
                        System.out.println("Input pet type:");
                        String petType = sc.next();
                        System.out.println("Input pet name:");
                        String petName = sc.next();
                        Pet newPet = new Pet(petType, petName);
                        pets1.removeIf(p -> p.equals(newPet));
                    } else {
                        System.out.println("Dont find member with this name.");
                        break;
                    }
                    break;
                case "deletePetFromAll":
                    System.out.println("Input pet type which you want to delete in all zoo zooClub members:");
                    String inPetType = sc.next();
                    Set<Person> people = zooClub.club.keySet();
                    Collection<List<Pet>> pets2 = new ArrayList<>();
                    for (Person person2 : people) {
                        pets2.add(zooClub.club.get(person2));
                    }
                    for (List<Pet> next : pets2) {
                        next.removeIf(p -> p.getType().equals(inPetType));
                    }
                    break;
                case "showMembers":
                    Set<Map.Entry<Person, List<Pet>>> entries = zooClub.club.entrySet();
                    Iterator<Map.Entry<Person, List<Pet>>> iterator = entries.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Person, List<Pet>> member = iterator.next();
                        System.out.println("Person: " + member.getKey() + "\nPets:" + member.getValue());
                    }
                    break;
                case "deleteMember":
                    System.out.println("Input your name:");
                    String personN = sc.next();
                    System.out.println("Input your age:");
                    int personA = sc.nextInt();
                    Person temp1 = null;
                    for (Person p : zooClub.club.keySet()) {
                        if (p.getName().equals(personN) && p.getAge() == personA) {
                            temp1 = p;
                        }
                    }
                    if (temp1 != null) {
                        zooClub.deleteMember(temp1);
                    } else {
                        System.out.println("Dont find member with name " + personN + " and age " + personA);
                        break;
                    }
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Incorrect instruction.Type 'help' to view abilities");
                    break;
            }
        }
    }
}
