package oop.practice;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int PROCESSING_INTERVAL_SEC = 2; // 3 seconds interval
    private static final String QUEUE_DIR = "/Users/suleimanpasa/oop-course-repo/lab-papers-please/java-classifcation/src/main/java/queue";
    private static Semaphore semaphore;
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ScheduledExecutorService executorService;

    public static void main(String[] args) {
        CarStation gasStation = new CarStation();
        CarStation electricStation = new CarStation();

        semaphore = new Semaphore(gasStation, electricStation);
        executorService = Executors.newSingleThreadScheduledExecutor();

        // Start processing cars at a fixed interval
        executorService.scheduleAtFixedRate(() -> {
            if (!proccessSingleCarFromFile()) {
                System.out.println("All cars have been processed. Stopping file processing.");
                executorService.shutdown(); // Stop processing cars
                serveCarsFromStation();     // Begin serving cars
            }
        }, 0, PROCESSING_INTERVAL_SEC, TimeUnit.SECONDS);
    }

    private static boolean proccessSingleCarFromFile() {
        File queueDir = new File(QUEUE_DIR);
        File[] files = queueDir.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null && files.length > 0) {
            File file = files[0]; // Process the first file in the directory
            try {
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                Car car = objectMapper.readValue(content, Car.class);
                addCarsToStation(car);
                Files.delete(file.toPath()); // Delete file after processing
                System.out.println("Processed car: " + car);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false; // No files to process
    }

    private static void addCarsToStation(Car car) {
        if ("GAS".equalsIgnoreCase(car.getFuelType())) {
            semaphore.gasStation().addCar(car);
        } else if ("ELECTRIC".equalsIgnoreCase(car.getFuelType())) {
            semaphore.electricStation().addCar(car);
        }
    }

    private static void serveCarsFromStation() {
        System.out.println("Serving all cars...");
        semaphore.gasStation().serveGasCars();
        semaphore.electricStation().serveElectricCars();
        System.out.println("All cars have been served.");
    }
}