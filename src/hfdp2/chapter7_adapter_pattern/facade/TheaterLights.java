package hfdp2.chapter7_adapter_pattern.facade;

public class TheaterLights {
    public void dim(int i) {
        System.out.println("Theater lights set to " + i);
    }

    public void on() {
        System.out.println("Theater lights is on");
    }
}
