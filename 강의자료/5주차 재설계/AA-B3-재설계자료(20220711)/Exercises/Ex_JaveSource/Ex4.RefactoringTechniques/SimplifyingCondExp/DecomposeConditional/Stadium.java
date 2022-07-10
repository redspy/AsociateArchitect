import java.util.Date;

public class Stadium {
    // ...
    public double summerRate;
    public double winterRate;
    public double winterServiceCharge;

    public double getTicketPrice(Date date, int quantity) {
        double charge;
        if (date.before(SUMMER_START) || date.after(SUMMER_END)) {
            charge = quantity * winterRate + winterServiceCharge;
        } else {
            charge = quantity * summerRate;
        }
        return charge;
    }
}
