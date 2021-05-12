package hfdp2.chapter11_proxy_pattern;

import hfdp2.chapter10_state_pattern.GumballMachine;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        int count = 112;

        GumballMachine gumballMachine = new GumballMachine("Austin", count);
        GumballMonitor monitor = new GumballMonitor(gumballMachine);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        monitor.report();
    }
}
