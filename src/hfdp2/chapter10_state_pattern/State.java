package hfdp2.chapter10_state_pattern;

public interface State {
    public void insertQuarter();
    public void enjectQuarter();
    public void turnCrank();
    public void dispense();
    public void refill();
}
