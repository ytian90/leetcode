package hfdp2.chapter12_compund_pattern;

public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
