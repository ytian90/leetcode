package hfdp2.chapter7_adapter_pattern.facade;

public class Amplifier {
    StreamingPlayer player;
    int volumn;

    public void on() {
        System.out.println("Amplifier is on");
    }

    public void setStreamingPlayer(StreamingPlayer player) {
        this.player = player;
        System.out.println("Amplifier player is set");
    }

    public void setSurroundSound() {
        System.out.println("Amplifier surround sound is set");
    }

    public void setVolumn(int i) {
        this.volumn = i;
        System.out.println("Amplifier volumn set to " + i);
    }

    public void off() {
        System.out.println("Amplifier is off");
    }
}
