package oop.practice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private final int carID;
    private final String fuelType;
    private final String passangerType;
    private final boolean needsDinner;
    private final int consumption;

    @JsonCreator
    public Car(@JsonProperty("id") String carID,
               @JsonProperty("type") String fuelType,
               @JsonProperty("passengers") String passangerType,
               @JsonProperty("isDining") boolean needsDinner,
               @JsonProperty("consumption") int consumption) {
        this.carID = Integer.parseInt(carID);
        this.fuelType = fuelType;
        this.passangerType = passangerType;
        this.needsDinner = needsDinner;
        this.consumption = consumption;
    }

    public int getCarID() {
        return carID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getPassangerType() {
        return passangerType;
    }

    public boolean needsDinner() {
        return needsDinner;
    }

    public int getConsumption() {
        return consumption;
    }
}
