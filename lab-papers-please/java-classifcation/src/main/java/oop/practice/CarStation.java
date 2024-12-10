package oop.practice;


public class CarStation {
    private final Dineable peopleDiningService;
    private final Dineable robotDiningService;
    private final Refuelable electricRefuelingService;
    private final Refuelable gasRefuilingservice;
    private final SimpleQueue<Car> queue;
    private int gasCars = 0;
    private int electricCars = 0;
    private int people = 0;
    private int robots = 0;
    private int dining = 0;
    private int not_dining = 0;
    private int consumption_gas = 0;
    private int consumption_electric = 0;

    public CarStation(){
        this.peopleDiningService = new PeopleDinner();
        this.robotDiningService = new RobotDinner();
        this.electricRefuelingService = new ElectricStation();
        this.gasRefuilingservice = new GasStation();
        this.queue = new SimpleQueue<>();
    }

    public void addCar(Car car) {
        queue.enqueue(car);
        System.out.println("Car with the id " + car.getCarID() + " was added to the queue.");
    }

    public void serveElectricCars() {
        print_separator();
        while (!queue.isEmpty()) {
            Car car = queue.dequeue(); electricRefuelingService.refuel(car.getCarID());
            electricCars += 1;
            consumption_electric += car.getConsumption();

            dinningService(car);

        }
        print_separator();
        System.out.println("All cars have been served.\n" +
                "Electric cars totals: " + electricCars + "\n" +
                "People served: " + people + "\n"+"Robots served: " + robots + "\n" +
                "Dining cars totals: " + dining + "\n"+ "Totals of card that did not dine: " + not_dining + "\n" +
                "(Electric)Consumption total: " + consumption_electric);

        print_separator();
    }

    public void serveGasCars() {
        print_separator();
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();

            gasCars += 1;
            consumption_gas += car.getConsumption();
            gasRefuilingservice.refuel(car.getCarID());

            dinningService(car);
        }
        print_separator();
        System.out.println("All cars have been served.\n" +
                "Gas cars totals: "  + gasCars + "\n" +
                "People served: " + people + "\n"+"Robots served: " + robots + "\n" +
                "Dining cars total: " + dining +"\n"+ "Totals of card that did not dine: " + not_dining + "\n" +
                "(Gas)Consumption total: " + consumption_gas);  print_separator();
    }

    private void dinningService(Car car){
        if (car.needsDinner()) {
            dining += 1;
            if ("people".equalsIgnoreCase(car.getPassangerType())) {
                peopleDiningService.serveDinner(car.getCarID());
                people += 1;
            } else if ("robots".equalsIgnoreCase(car.getPassangerType())) {
                robotDiningService.serveDinner(car.getCarID());
                robots += 1;
            }
            dining += 1;
        } else {
            not_dining += 1;
            if ("people".equalsIgnoreCase(car.getPassangerType())) {
                people += 1;
            } else if ("robots".equalsIgnoreCase(car.getPassangerType())) {
                robots += 1;
            }
        }
    }

    public Queue<Car> getQueue() {
        return queue;
    }

    private void print_separator() {
        System.out.println("-----------------------------------------------------");
    }
}
