import java.util.Objects;

public class Student extends Leaner {
    private int course;
    public Student(String s,String n,double a,int c)
    {
        super(s,n,a);
        this.course = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public String toString() {
        String out = "Student" + super.toString();
        return out;
    }

    public void print()
    {
        System.out.println(this);
    }
    public int getCourse()
    {
        return this.course;
    }

}
