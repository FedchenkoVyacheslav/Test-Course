package io.piano.oop;
import java.util.Arrays;
import java.util.List;

public class Inheritance {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = Arrays.asList(
                new Car("BMW"),
                new Car("Volkswagen"),
                new Car("Audi"),
                new Car("Porsche"),
                new Truck("MAN"),
                new Truck("DAF"),
                new Truck("Scania"),
                new Truck("KAMAZ")
        );
        for (Vehicle vehicleItem: vehicleList) {
            System.out.println(vehicleItem.getInfo());
        }
    }
    static class Vehicle {
        String brand;
        String getInfo () {
            return brand;
        }
    }
    static class Car extends Vehicle {
        String type = "Car";
        String getInfo() {
            return type + " " + brand;
        }
        Car (String brand) {
            this.brand = brand;
        }
    }
    static class Truck extends Vehicle {
        String type = "Truck";
        String getInfo() {
            return type + " " + brand;
        }
        Truck (String brand) {
            this.brand = brand;
        }
    }
}
