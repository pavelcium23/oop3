package oop.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Barista barista = new Barista();
        List<Coffee> coffeeOrders = new ArrayList<>();

        System.out.println("Welcome to SuleimanPasa CoffeeShop!");

        while (true) {
            System.out.println("\nHello there! What would you like to drink?");
            System.out.println("1. Americano");
            System.out.println("2. Cappuccino");
            System.out.println("3. Syrup Cappuccino");
            System.out.println("4. Pumpkin Spice Latte");
            System.out.print("Enter number of coffee you would like to order: ");
            int choice = scanner.nextInt();

            Coffee coffeee = null;

            switch (choice) {
                case 1:
                    System.out.println("Perfect choice! A smooth Americano on the way...");
                    System.out.println("Set your Intensity (0: LIGHT, 1: NORMAL, 2: STRONG): ");
                    Intensity intensityAmericano = Intensity.values()[scanner.nextInt()];
                    System.out.println("Enter ml of water(230: Small, 350: Tall, 470: Grande, 590: Venti): ");
                    int water = scanner.nextInt();
                    coffeee = barista.makeAmericano(intensityAmericano, water);
                    break;
                case 2:
                    System.out.println("Absolutely! A classic Cappuccino coming right up...");
                    System.out.println("Set your Intensity (0: LIGHT, 1: NORMAL, 2: STRONG): ");
                    Intensity intensityCappuccino = Intensity.values()[scanner.nextInt()];
                    System.out.println("Enter ml of milk(I Recommend either 15ml or 30ml depends on your preference darling): ");
                    int milk = scanner.nextInt();
                    coffeee = barista.makeCappuccino(intensityCappuccino, milk);
                    break;
                case 3:
                    System.out.println("Got it! A cappuccino with syrup coming right up babes...");
                    System.out.println("Set your Intensity (0: LIGHT, 1: NORMAL, 2: STRONG): ");
                    Intensity intensitySyrupCappuccino = Intensity.values()[scanner.nextInt()];
                    System.out.println("Enter ml of milk(I Recommend either 15ml or 30ml depends on your preference darling): ");
                    int milkSyrup = scanner.nextInt();
                    System.out.println("Syrup (0: MACADAMIA, 1: VANILLA, 2: COCONUT, 3: CARAMEL, 4: CHOCOLATE, 5: POPCORN): ");
                    SyrupType syrup = SyrupType.values()[scanner.nextInt()];
                    coffeee = barista.makeSyrupCappuccino(intensitySyrupCappuccino, milkSyrup, syrup);
                    break;
                case 4:
                    System.out.println("Oh, you’ve got great taste—pumpkin spice latte is a seasonal favorite!");
                    System.out.println("Set your Intensity (0: LIGHT, 1: NORMAL, 2: STRONG): ");
                    Intensity intensityLatte = Intensity.values()[scanner.nextInt()];
                    System.out.println("Enter ml of milk(I Recommend either 15ml or 30ml depends on your preference darling): ");
                    int milkLatte = scanner.nextInt();
                    System.out.println("Enter mg of pumpkin spice: ");
                    int pumpkinSpice = scanner.nextInt();
                    coffeee = barista.makePumpkinSpiceLatte(intensityLatte, milkLatte, pumpkinSpice);
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }

            if (coffeee != null) {
                coffeeOrders.add(coffeee);
            }

            System.out.print("Would you like to add another coffee to your order? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();

        System.out.println("\n--- Your Order Summary ---");
        for (Coffee coffeee : coffeeOrders) {
            coffeee.makeReceipt();
        }

        System.out.println("\nThanks for visiting SuleimanPasa CoffeeShop, if you liked everything don't forget to leave a tip!");
    }
}
