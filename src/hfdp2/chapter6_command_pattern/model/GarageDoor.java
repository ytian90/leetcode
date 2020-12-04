package hfdp2.chapter6_command_pattern.model;

public class GarageDoor {
    public void up() {
        System.out.println("Garage Door is open.");
    }

    public void down() {
        System.out.println("Garage Door is closed.");
    }

    public void stop() {
        System.out.println("Garage Door stops.");
    }

    public void lightOn() {
        System.out.println("Garage Door light is on.");
    }

    public void lightOff() {
        System.out.println("Garage Door light is off.");
    }
}
