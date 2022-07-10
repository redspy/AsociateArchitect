package Sequence;

import java.util.Collection;
import java.util.Iterator;

public class Subject {
    private Collection c;

    public void addObserver(Observer o) {
        c.add(o);
    }

    public void changeState() {
        // change state of subject
        notifyObservers();
    }

    public void notifyObservers() {
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Observer o = (Observer)i.next();
            o.update();
        }
    }
}
