class Student implements Comparable<Student>{
    private int id;
    private String name;
    private String surname;

    public Student(String name,String surname,int id) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    public int compareTo(Student student) {
        return Integer.compare(id,student.id);
    }
    public void getInfo()
    {
        System.out.println(this.name + " " + this.surname + " " + this.id);
    }
    public String toString()
    {
        return name + " " + surname + " " + id + "\n" + "--------------------";
    }
}
