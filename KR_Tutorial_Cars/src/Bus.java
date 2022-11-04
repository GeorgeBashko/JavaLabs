public class Bus extends Automobile{
    private int doors;
    private int places;
    public void print()
    {
        System.out.println(this);
    }
    public Bus()
    {
        super();
    }
    public Bus(String s,Fuel f,String c,int d,int p)
    {
        super(s,c,f);
        this.doors = d;
        this.places = p;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass())return false;
        if(!super.equals(obj)) return false;
        Bus b = (Bus) obj;
        if(doors != b.doors)
            return false;
        return places == b.places;
    }

    @Override
    public String toString() {
        String out;
        out = super.toString() + ", doors: " + this.getDoors() + ", palaces: " + this.getPlaces();
        return out;
    }
    public int getDoors()
    {
        return doors;
    }
    public int getPlaces()
    {
        return places;
    }
    public void setDoors(int n)
    {
        this.doors = n;
    }
    public void setPlaces(int n)
    {
        this.places = n;
    }
}
