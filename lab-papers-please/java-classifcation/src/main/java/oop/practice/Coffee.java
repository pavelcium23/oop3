package oop.practice;

enum Intensity{
LIGHT, NORMAL, STRONG
}
enum SyrupType{
    MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
}

class Coffee {
    private Intensity coffeeIntensity;
    private String name;

    public Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }
}

class Americano extends Coffee {
    private int mlOfWater;
    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee,"Americano");
        this.mlOfWater = mlOfWater;
    }
    public int getMlOfWater() {
        return mlOfWater;
    }
}

class Cappuccino extends Coffee {
    private int mlOfMilk;
    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity,"Cappuccino");
        this.mlOfMilk = mlOfMilk;
    }
    public int getMlOfMilk() {
        return mlOfMilk;
    }
}

class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    public SyrupCappuccino(Intensity intensityCoffee,int mltrOfMilk, SyrupType syrup) {
        super(intensityCoffee,mltrOfMilk);
        this.syrup = syrup;
    }
    public SyrupType getSyrup() {
        return syrup;
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
    }
    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }
    public int getMlOfMilk() {
        return mlOfMilk;
    }
}


