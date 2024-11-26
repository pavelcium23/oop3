package oop.practice;

enum Intensity {
    LIGHT, NORMAL, STRONG
}

enum SyrupType {
    MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
}

abstract class Coffee {
    private Intensity coffeeIntensity;
    private String name;

    protected Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    protected Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    protected void makeReceipt() {
        System.out.println("\nNow Making " + getName());
        System.out.println("Intensity is set to " + coffeeIntensity);
    }
}

class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee, "Americano");
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void makeReceipt() {
        super.makeReceipt();
        System.out.println("Pouring in " + mlOfWater + " ml of water");
    }

    public final Americano makeAmericano() {
        makeReceipt();
        return this;
    }
}

class Cappuccino extends Coffee {
    private int mlOfMilk;

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity, "Cappuccino");
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public void makeReceipt() {
        super.makeReceipt();
        System.out.println("Adding " + mlOfMilk + " ml of milk");
    }

    public final Cappuccino makeCappuccino() {
        makeReceipt();
        return this;
    }
}

class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity intensityCoffee, int mlOfMilk, SyrupType syrup) {
        super(intensityCoffee, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public String getName() {
        return "Syrup Cappuccino";
    }

    @Override
    public void makeReceipt() {
        super.makeReceipt();
        System.out.println("Adding " + syrup + " syrup");
    }

    public final SyrupCappuccino makeSyrupCappuccino() {
        makeReceipt();
        return this;
    }
}

class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public String getName() {
        return "Pumpkin Spice Latte";
    }

    @Override
    public void makeReceipt() {
        super.makeReceipt();
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice");
    }

    public final PumpkinSpiceLatte makePumpkinSpiceLatte() {
        makeReceipt();
        return this;
    }
}
