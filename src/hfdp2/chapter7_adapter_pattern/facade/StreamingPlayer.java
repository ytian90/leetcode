package hfdp2.chapter7_adapter_pattern.facade;

public class StreamingPlayer {
    public void on() {
        System.out.println("Streaming player is on");
    }

    public void play(String movie) {
        System.out.println("Movie " + movie + " is playing");
    }

    public void off() {
        System.out.println("Streaming player is off");
    }

    public void stop() {
        System.out.println("Steaming player stops");
    }
}
