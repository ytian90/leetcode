package mj.houzz;

/**
 * Represents a coin with two sides that can be flipped
 */
public class UnfairCoin {

    public final int HEADS = 0;
    public final int TAILS = 1;

    private int face;
    private double bias;

    public UnfairCoin() {
        this.bias = 0.5;
        flip();
    }

    public UnfairCoin(double d) {
        if (d >= 0 && d <= 1) {
            this.bias = d;
        } else {
            this.bias = 0.5;
        }
        flip();
    }

    public void flip() {
        if (Math.random() < bias) {
            face = HEADS;
        } else {
            face = TAILS;
        }
    }

    public int getFace() {
        return face;
    }

}
