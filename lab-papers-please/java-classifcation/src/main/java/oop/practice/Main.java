package oop.practice;

public class Main {
    public static void main(String[] args) {
        Coffee americano = new Americano(Intensity.STRONG, 150);
        Coffee cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        Coffee syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.VANILLA);
        Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 70, 25);
        System.out.println("\nAmericano Details:");
        americano.printDetails();
        System.out.println("\nCappuccino Details:");
        cappuccino.printDetails();
        System.out.println("\nSyrup Cappuccino Details:");
        syrupCappuccino.printDetails();

        System.out.println("\nPumpkin Spice Latte Details:");
        pumpkinSpiceLatte.printDetails();

    }
}



