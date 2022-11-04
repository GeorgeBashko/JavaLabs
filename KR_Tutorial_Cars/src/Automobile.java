import java.util.Objects;

public abstract class Automobile implements Comparable<Automobile> {
    private String name;
    private Fuel fuel;
    private String color;
    public Automobile()
    {
        name = "";
        color = "";
    }
    public Automobile(String s,String c,Fuel f)
    {
        this.fuel = f;
        this.name = s;
        this.color = c;
    }
    @Override
    public int compareTo(Automobile o) {
        if(this.getName().equals(o.getName()))
            return -1*(this.getFuel().compareTo(o.getFuel()));
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass())return false;
        Automobile a = (Automobile) obj;
        if(!Objects.equals(name, a.name))
            return false;
        if(!Objects.equals(color, a.color))
            return false;
        return fuel == a.fuel;
    }

    @Override
    public String toString() {
        String out = new String();
        out = this.getClass().getName() + ":" + this.getName() + ",fuel: " + this.getFuel() + ", color: " + this.getColor();
        return out;
    }
    public String getName()
    {
        return name;
    }
    public Fuel getFuel()
    {
        return fuel;
    }

    public String getColor(){return color;}
    public void setFuel(Fuel f)
    {
        this.fuel = f;
    }
    public void setName(String s)
    {
        this.name = s;
    }
    public void setColor(String s)
    {
        this.color = s;
    }
    public abstract void print();
}
