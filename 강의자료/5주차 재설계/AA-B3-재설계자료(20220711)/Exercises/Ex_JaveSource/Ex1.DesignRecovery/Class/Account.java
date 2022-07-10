package Class;

public abstract class Account {
    protected int number;
    protected double bal;
    protected Person owner;

    public int getNumber() {
        //...
    }

    public double getBal() {
        //...
    }

    public Person getOwner() {
        //...
    }

    public void deposit(double d) {
        //...
    }

    public abstract boolean withdraw(double d);
}
