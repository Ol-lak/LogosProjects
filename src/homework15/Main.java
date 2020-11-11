package homework15;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ZooClub club = new ZooClub();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 'help' to get all abilities:");
        while (true) {
            System.out.println("Input instruction");
            String str = sc.next();
            switch (str) {
                case "help":
                    System.out.println("Type 'addMember' to add new Zoo club member;");
                    System.out.println("Type 'addPet' to add a new pet to club member ");
                    System.out.println("Type 'deletePet' to delete a pet from club member ");
                    System.out.println("Type 'deleteMember' to delete a member from club ");
                    System.out.println("Type 'deletePetFromAll' to delete a specific type of pet from all club members");
                    System.out.println("Type 'showMembers' to show all club members");
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
                    club.addMember(person, pets);
                    break;
                case "addPet": {
                    System.out.println("Input your name:");
                    String personName = sc.next();
                    Person temp = null;
                    for (Person p : club.club.keySet()) {
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
                        club.addPet(temp, pet);
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
                    for (Person p : club.club.keySet()) {
                        if (p.getName().equals(personName)) {
                            temp = p;
                        }
                    }
                    if (temp != null) {
                        List<Pet> pets1 = club.club.get(temp);
                        System.out.println("Input pet type:");
                        String petType = sc.next();
                        System.out.println("Input pet name:");
                        String petName = sc.next();
                        Pet newPet = new Pet(petType, petName);
                        for (Pet p : pets1) {
                            if (p.equals(newPet)) {
                                pets1.remove(p);
                            }
                        }
                    } else {
                        System.out.println("Dont find member with this name.");
                        break;
                    }
                    break;
                case "deletePetFromAll":
                    System.out.println("Input pet type which you want to delete in all zoo club members:");
                    String inPetType = sc.next();
                    club.deletePetFromAllMembers(inPetType);
                    break;
                case "showMembers":
                    club.printZooClubMember();
                    break;
                case "deleteMember":
                    System.out.println("Input your name:");
                    String personN = sc.next();
                    System.out.println("Input your age:");
                    int personA = sc.nextInt();
                    Person temp1 = null;
                    for (Person p : club.club.keySet()) {
                        if (p.getName().equals(personN) && p.getAge() == personA) {
                            temp1 = p;
                        }
                    }
                    if (temp1 != null) {
                        club.deleteMember(temp1);
                    }
                    else {
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
