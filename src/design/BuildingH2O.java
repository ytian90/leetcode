package design;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

/**
 * 1117. Building H2O
 */
public class BuildingH2O {
    private Semaphore semH = new Semaphore(2);
    private Semaphore semO = new Semaphore(1);
    private Phaser phaser = new Phaser(3);

    public BuildingH2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH.acquire();
        // releaseHydrogen.run() outputs "H". Do not dhcnage or remove this line.
        releaseHydrogen.run();
        phaser.arriveAndAwaitAdvance();
        semH.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        phaser.arriveAndAwaitAdvance();
        semO.release();
    }
}
