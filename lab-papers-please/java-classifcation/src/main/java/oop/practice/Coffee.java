package oop.practice;

enum Intensity{
LIGHT, NORMAL, STRONG
}
enum SyrupType{
    MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
}

abstract class Coffee {
    private Intensity coffeeIntensity;
    private String name;

    public Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void PrintCoffeeDetails() {
        System.out.println("Coffee Intensity: " + coffeeIntensity);
    }

    public void PrintDetails(){
        PrintCoffeeDetails();
    }

    public abstract void printDetails();
}

class Americano extends Coffee {
    private int mlOfWater;
    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee,"Americano");
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printDetails() {
        super.PrintCoffeeDetails();
        System.out.println(getName() + " water: " + mlOfWater + " ml");}
}

class Cappuccino extends Coffee {
    private int mlOfMilk;
    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity,"Cappuccino");
        this.mlOfMilk = mlOfMilk;
    }
    @Override
    public void printDetails() {
        super.PrintCoffeeDetails();
        System.out.println(getName() + " milk: " + mlOfMilk + " ml");}
}

class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private int mltrOfMilk;
    public SyrupCappuccino(Intensity intensityCoffee,int mltrOfMilk, SyrupType syrup) {
        super(intensityCoffee,mltrOfMilk);
        this.syrup = syrup;
        this.mltrOfMilk = mltrOfMilk;
    }
    public SyrupType getSyrup() {
        return syrup;
    }
    public int getMltrOfMilk() {
        return mltrOfMilk;
    }

    @Override
    public void printDetails() {
        super.PrintDetails();
        System.out.println("Syrup Type: " + syrup );
        System.out.println(getName() + " milk: " + mltrOfMilk + " ml");
    }
    @Override
    public String getName() {

        return "SyrupCappuccino";
    }
}

class PumpkinSpiceLatte extends Coffee {
    private int mgOfPumpkinSpice;
    private int mlOfMilk;

    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee, "PumpkinSpiceLatte");
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public void printDetails() {
        super.PrintDetails();
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
        System.out.println(getName() + " milk: " + mlOfMilk + " ml");
    }

    @Override
    public String getName() {
        return "PumpkinSpiceLatte";
    }
}


