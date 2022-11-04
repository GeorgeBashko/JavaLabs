import java.util.Objects;

public class Exponential extends Series{
    private String name1;
    public Exponential(double f,double d,int n,String nm)
    {
        super(f, d, n);
        this.name1 = nm;
    }

    @Override
    public double GetElement(int i) {
        return (this.getFirstElement() * Math.pow(this.getDe(),(i - 1)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Exponential that = (Exponential) o;
        return Objects.equals(name1, that.name1);
    }

    @Override
    public String toString() {
        return "Exponential, " + "Infinity: " + getName1() + super.toString();
    }

    public String getName1()
    {
        return name1;
    }
}