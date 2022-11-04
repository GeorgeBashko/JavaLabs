public class Car extends Automobile{
    private Material material;

    public void print()
    {
        System.out.println(this);
    }
    public Car(String s,String c,Fuel f,Material m)
    {
        super(s,c,f);
        this.material = m;
    }
    public Car()
    {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass())return false;
        if(!super.equals(obj)) return false;
        Car c = (Car) obj;
        return material == c.material;
    }

    public String toString()
    {
        String out;
        out = super.toString();
        out += ", material: " + this.getMaterial();
        return out;
    }
    public Material getMaterial()
    {
        return material;
    }
    public void setMaterial(Material m)
    {
        this.material = m;
    }
}
