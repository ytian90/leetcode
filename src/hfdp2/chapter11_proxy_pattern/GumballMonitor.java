package hfdp2.chapter11_proxy_pattern;

import hfdp2.chapter10_state_pattern.GumballMachine;

public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine gumballMachine) {
        this.machine = gumballMachine;
    }

    public void report() {
        System.out.println("Gumball Machine: " + machine.getLocation());
        System.out.println("Current inventory: " + machine.getCount() + " gumballs");
        System.out.println("Current state: " + machine.getState());
    }

}
