public class Main {
    public static void main(String[] args) {
        MyContainer<Student> c = new MyContainer<>();
        c.add(new Student("asd","assdd",2.3,3));
        c.add(new Student("abc","asdf",5.3,1));
        c.add(new Student("asd","dddff",2.3,1));
        c.add(new Student("a1d","dddff",5.3,1));
        c.add(new Student("vvv","asdf",3.4,2));
        c.printInformationByAverageMark();
        System.out.println(c.countOfLeaner(new Student("asd","dddff",5.3,1)));
        System.out.println(c.averageMark("dddff"));
        c.twoMaxLeaners().stream().forEach(System.out::println);
        MyContainer<Schoolboy> s = new MyContainer<>();
    }
}