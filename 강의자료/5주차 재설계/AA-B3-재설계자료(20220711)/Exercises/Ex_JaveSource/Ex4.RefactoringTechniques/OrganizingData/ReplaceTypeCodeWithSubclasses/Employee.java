public class Employee {
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    public int type;

    public Employee(int arg) { type = arg; }

    public int monthlySalary;
    public int commission;
    public int bonus;
    public int payAmount() {
        switch (type) {
            case ENGINEER: return monthlySalary;
            case SALESMAN: return monthlySalary + commission;
            case MANAGER: return monthlySalary + bonus;
            default: throw new RuntimeException("Incorrect Code");
        }
    }

}
