package Sequence;

public class Client {
    private Server server;
    public void work() {
        server.open();
        server.print("Hello");
        server.close();
    }
   // ...
}
