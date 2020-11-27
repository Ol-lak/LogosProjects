package homework22.money_random;

import java.util.Scanner;
import java.util.function.Consumer;

public class Money {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select eagle(Input '1') or tail(Input '2')");
        int yourChoice = scanner.nextInt();
        Consumer<Integer> consumer = (x) -> {
            int randomMoney = (int) (Math.random() * (2) + 1);
            if (randomMoney == x) {
                System.out.println("Congratulation, you win!");
            } else {
                System.out.println("You lost!");
            }
        };
        consumer.accept(yourChoice);
    }
}