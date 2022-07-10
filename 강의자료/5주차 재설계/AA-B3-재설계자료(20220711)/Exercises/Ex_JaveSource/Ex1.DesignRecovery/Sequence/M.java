package Sequence;

public class M {
    public static void main(String[] args) {
        M m = new M();
        m.f();
    }

    public void f() {
        Subject s = new Subject();
        Observer o1 = new Observer();
        Observer o2 = new Observer();
        s.addObserver(o1);
        s.addObserver(o1);
        s.changeState();
    }

}
