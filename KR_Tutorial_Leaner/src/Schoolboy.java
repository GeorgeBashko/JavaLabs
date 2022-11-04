import java.util.Objects;

public class Schoolboy extends Leaner {
    private Behaviour behaviour;
    private int classNumber;
    public Schoolboy(String s,String n,double a,Behaviour b,int c)
    {
        super(s,n,a);
        this.behaviour = b;
        this.classNumber = c;
    }
    public void print()
    {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Student: " + super.toString() + '\n' + "Behavior: " + getBehaviour() + '\n' + "Class: " + getClassNumber() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Schoolboy schoolboy = (Schoolboy) o;
        return classNumber == schoolboy.classNumber && behaviour == schoolboy.behaviour;
    }
    public Behaviour getBehaviour()
    {
        return behaviour;
    }
    public int getClassNumber()
    {
        return classNumber;
    }
}
