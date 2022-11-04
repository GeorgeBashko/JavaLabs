public class Main {
    public static void main(String[] args) {
        MyContainer<Guard> c = new MyContainer<>();
        c.add(new Guard("aad","asd",1,1));
        c.add(new Guard("azd","asd",1,2));
        c.add(new Guard("asr","as3",1,1));
        c.add(new Guard("asdty","as4",1,1));
        //c.sortBySalary().forEach(System.out::println);
        c.sortBySalaryDivKoef().forEach(System.out::println);
        System.out.println(c.returnCompanies());
        System.out.println(c.averageSalary("asd"));
    }
}