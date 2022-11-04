import java.util.Objects;

public abstract class Employe implements Comparable <Employe> {
    private String surname;
    private String company;
    protected double koef;
    public abstract double calculateSalary();
    public Employe(String s,String c,double k)
    {
        this.surname = s;
        this.company = c;
        this.koef = k;
    }
    @Override
    public int compareTo(Employe e)
    {
        var diff = Double.compare(calculateSalary(),e.calculateSalary());
        return diff;
    }

    @Override
    public String toString() {
        String out = "";
        out = "Employee" + '\n' + "Surname: " + getSurname() + '\n' + "Company: " + getCompany() + '\n' + "Coefficient: " + getKoef() + '\n';
        return out;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(!(obj instanceof Employe))return false;
        Employe e = (Employe) obj;
        return Double.compare(koef,koef) == 0 && Objects.equals(surname,e.surname) && Objects.equals(company,e.company);
    }
    public String getSurname()
    {
        return surname;
    }
    public String getCompany()
    {
        return company;
    }
    public double getKoef()
    {
        return koef;
    }
}
