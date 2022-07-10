package Sequence;

import java.util.Vector;

public class StringContainer {

    private Vector v = null;

    public void add(String s) {
        init();
        v.add(s);
    }

    public boolean remove(String s) {
        init();
        return v.remove(s);
    }
    private void init() {
        if (v == null)
            v = new Vector();
    }
}
