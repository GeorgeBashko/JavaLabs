import java.util.Objects;

public class Guard extends Employe{
    private double square;
    private static final double CONST_BASE = 1000;
    public Guard(String s,String c,double k,double sq)
    {
        super(s,c,k);
        this.square = sq;
    }

    @Override
    public String toString() {
        String out = super.toString() + "Square: " + getSquare();
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guard guard = (Guard) o;
        return Double.compare(guard.square, square) == 0;
    }

    public double calculateSalary()
    {
        return CONST_BASE * koef * square;
    }
    public double getSquare()
    {
        return square;
    }
}
