package hfdp2.chapter7_adapter_pattern.facade;

public class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void wideScreenMode() {
        System.out.println("Projector is wide screen mode");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}
