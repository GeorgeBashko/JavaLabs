public class Main {
    public static void main(String[] args) {
        MyContainer<Linear> c = new MyContainer<>();
        c.add(new Linear(12.0,3.0,9,"AAA"));
        c.add(new Linear(12.0,8.0,9,"AAA"));
        c.add(new Linear(8.0,5.0,2,"AAB"));
        c.add(new Linear(17.0,32.0,5,"AAV"));
        c.add(new Linear(11.0,6.0,3,"AAC"));
        c.printContainer();
        System.out.println(c.getAverageDe(12.0));
        c.sortByFirstElement().printContainer();
        System.out.println();
        c.sortByOtn().printContainer();
        Window w1 = new Window("KR");
        //w1.setVisible(true);
    }
}