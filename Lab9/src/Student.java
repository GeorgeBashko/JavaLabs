import java.util.Objects;

public class Student {
    private String surname;
    private int cardNumber;
    private String subjectName;
    private int subjectMark;
    Student(String s,int c,String sn,int sm)
    {
        this.surname = s;
        this.cardNumber = c;
        this.subjectName = sn;
        this.subjectMark = sm;
    }
    Student()
    {
        this.surname = "";
        this.cardNumber = 0;
        this.subjectName = "";
        this.subjectMark = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return cardNumber == student.cardNumber && subjectMark == student.subjectMark && Objects.equals(surname, student.surname) && Objects.equals(subjectName, student.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, cardNumber, subjectName, subjectMark);
    }

    public String getSurname()
    {
        return this.surname;
    }
    public int getCardNumber()
    {
        return this.cardNumber;
}
    public String getSubjectName()
    {
        return this.subjectName;
    }
    public int getSubjectMark()
    {
        return this.subjectMark;
    }
    public void setSurname(String s)
    {
        this.surname = s;
    }
    public void setCardNumber(int n)
    {
        this.cardNumber = n;
    }
    public void setSubjectName(String s)
    {
        this.subjectName = s;
    }
    public void setSubjectMark(int s)
    {
        this.subjectMark = s;
    }

    @Override
    public String toString() {
        return "Surname: " + this.getSurname() + ", Card number: " + this.getCardNumber() + ", Subject: " + this.getSubjectName() + ", Mark: " + this.getSubjectMark();
    }
}
