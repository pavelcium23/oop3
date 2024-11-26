package oop.practice;

public class Barista {

    public Americano makeAmericano(Intensity intensity, int mlOfWater) {
        Americano americano = new Americano(intensity, mlOfWater);
        americano.makeAmericano();
        return americano;
    }

    public Cappuccino makeCappuccino(Intensity intensity, int mlOfMilk) {
        Cappuccino cappuccino = new Cappuccino(intensity, mlOfMilk);
        cappuccino.makeCappuccino();
        return cappuccino;
    }

    public SyrupCappuccino makeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
        syrupCappuccino.makeSyrupCappuccino();
        return syrupCappuccino;
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte latte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        latte.makePumpkinSpiceLatte();
        return latte;
    }
}
