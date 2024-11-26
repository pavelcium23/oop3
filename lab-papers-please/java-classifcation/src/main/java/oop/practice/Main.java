package oop.practice;

public class Main {
    public static void main(String[] args) {
        Coffee americano = new Americano(Intensity.STRONG, 150);
        Coffee cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        Coffee syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.VANILLA);
        Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 70, 25);

        ((Cappuccino) cappuccino).makeCappuccino();
        ((Americano) americano).makeAmericano();
        ((SyrupCappuccino) syrupCappuccino).makeSyrupCappuccino();
        ((PumpkinSpiceLatte) pumpkinSpiceLatte).makePumpkinSpiceLatte();


    }
}



