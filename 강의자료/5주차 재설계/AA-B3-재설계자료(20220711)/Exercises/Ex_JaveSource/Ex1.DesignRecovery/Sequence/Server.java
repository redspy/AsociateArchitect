package Sequence;

public class Server {
    public Device device;

    public void open() {
        // ...
    }

    public void print(String s) {
        device.write(s);
        // ...
    }

    public void close() {
        // ...
    }

    // ...
}
