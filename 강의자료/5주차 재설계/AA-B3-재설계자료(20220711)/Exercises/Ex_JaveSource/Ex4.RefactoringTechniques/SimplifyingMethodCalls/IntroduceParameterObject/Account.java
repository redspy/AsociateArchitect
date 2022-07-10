import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class Account {
    private Vector _entries = new Vector();

    double getFlowBetween (Date start, Date end) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (each.getDate().equals(start) || each.getDate().equals(end) ||
                    (each.getDate().after(start) && each.getDate().before(end))) {
                result += each.getValue();
            }
        }
        return result;
    }
}
