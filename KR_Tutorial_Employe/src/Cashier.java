import java.util.Objects;

public class Cashier extends Employe{
    private double cash;
    private static final double CONST_PERC = 0.9;
    public Cashier(String s,String c,double k,double ca)
    {
        super(s,c,k);
        this.cash = ca;
    }

    @Override
    public String toString() {
        String out = super.toString() + "Cash: " + getCash() + '\n';
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cashier cashier = (Cashier) o;
        return Double.compare(cashier.cash, cash) == 0;
    }

    public double calculateSalary() {
        return CONST_PERC * koef * cash;
    }
    public double getCash()
    {
        return cash;
    }

}
