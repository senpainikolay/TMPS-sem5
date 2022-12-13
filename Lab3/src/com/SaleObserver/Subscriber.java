package  com.SaleObserver;

public class Subscriber extends Observer {
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void getNotified() {
        System.out.println(name + " has been notified about a sale of 10% on Furnuture Factory ");
    }
}