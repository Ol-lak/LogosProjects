package homework14;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<Commodity> comm = new Vector<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 'help' to get all abilities:");
        while (true) {
            System.out.println("Input instruction");
            String str = sc.next();
            switch (str) {
                case "help":
                    System.out.println("Type 'addProduct' to add new product");
                    System.out.println("Type 'deleteProduct' to delete product ");
                    System.out.println("Type 'changeProduct' to delete change product by ID");
                    System.out.println("Type 'printId' to show collection element by ID");
                    System.out.println("Type 'exit' to exit from program");
                    break;
                case "addProduct":
                    System.out.println("Input name:");
                    String name = sc.next();
                    System.out.println("Input length:");
                    int length = sc.nextInt();
                    System.out.println("Input height:");
                    int height = sc.nextInt();
                    System.out.println("Input weight:");
                    int weight = sc.nextInt();
                    Commodity c = new Commodity(name, length, height, weight);
                    comm.add(c);
                    break;
                case "deleteProduct":
                    System.out.println("Input product name:");
                    String prodName = sc.next();
                    comm.removeIf(cd -> cd.getName().equals(prodName));
                    break;
                case "changeProduct":
                    System.out.println("Input product name which you want to change:");
                    String prodNameToChange = sc.next();
                    System.out.println("Input new name:");
                    String newName = sc.next();
                    System.out.println("Input new length:");
                    int newLength = sc.nextInt();
                    System.out.println("Input new height:");
                    int newHeight = sc.nextInt();
                    System.out.println("Input new weight:");
                    int newWeight = sc.nextInt();
                    for (Commodity cd : comm) {
                        if (cd.getName().equals(prodNameToChange)) {
                            cd.setHeight(newHeight);
                            cd.setLength(newLength);
                            cd.setName(newName);
                            cd.setWeight(newWeight);
                        }
                    }
                    break;
                case "printId":
                    System.out.println("Input id of element:");
                    int id = sc.nextInt();
                    Commodity saveCom = comm.get(id);
                    System.out.println(saveCom);
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
