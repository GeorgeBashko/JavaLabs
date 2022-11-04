import java.util.Objects;

import static java.lang.Double.*;

public abstract class Leaner implements Comparable<Leaner> {
    private String surname;
    private String nameOfSchool;
    private double averageMark;
    public Leaner(String s,String n,double a)
    {
        this.averageMark = a;
        this.nameOfSchool = n;
        this.surname = s;
    }
    public abstract void print();
    public String getSurname()
    {
        return this.surname;
    }
    public String getNameOfSchool()
    {
        return this.nameOfSchool;
    }
    public double getAverageMark()
    {
        return this.averageMark;
    }

    @Override
    public String toString() {
        return "Surname: " + getSurname() + '\n' + "School name: " + getNameOfSchool() + '\n' + "Average mark: " + getAverageMark() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaner leaner = (Leaner) o;
        return compare(leaner.averageMark, averageMark) == 0 && Objects.equals(surname, leaner.surname) && Objects.equals(nameOfSchool, leaner.nameOfSchool);
    }

    @Override
    public int compareTo(Leaner o) {
        if(getNameOfSchool().equals(o.nameOfSchool))
            return -getSurname().compareTo(o.getSurname());
        return getNameOfSchool().compareTo(o.getNameOfSchool());
    }
}
