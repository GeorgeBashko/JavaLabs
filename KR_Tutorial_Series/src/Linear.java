import java.util.Objects;

public class Linear extends Series {
    private String name;
    public Linear(double el,double d,int num,String i)
    {
        super(el,d,num);
        this.name = i;
    }
    @Override
    public double GetElement(int i)
    {
        return (this.getFirstElement() + (i - 1)*this.getDe());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Linear linear = (Linear) o;
        return Objects.equals(name, linear.name);
    }

    @Override
    public String toString() {
        return "Linear, " +"Name " + getName() + super.toString();
    }

    public String getName()
    {
        return name;
    }
}