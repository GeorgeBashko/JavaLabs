import java.util.*;
import java.util.stream.Collectors;

public class MyContainer<T extends Comparable<Employe>> extends ArrayList<T> {
    public MyContainer<T> sortBySalary() {
        MyContainer<T> collect = (MyContainer<T>) stream().sorted().collect(Collectors.toCollection(MyContainer::new));
        return collect;
    }

    public MyContainer<T> sortBySalaryDivKoef() {
        MyContainer<T> col = (MyContainer<T>) stream().sorted((first, second) -> {
            if (first instanceof Employe && second instanceof Employe) {
                var firstE = (Employe) first;
                var secondE = (Employe) second;
                var firstR = firstE.calculateSalary() / firstE.getKoef();
                var secondR = secondE.calculateSalary() / secondE.getKoef();
                return Double.compare(firstR, secondR);
            }
            return 0;
        }).collect(Collectors.toCollection(MyContainer::new));
        return col;
    }

    public ArrayList<String> returnCompanies() {
        ArrayList<String> c = new ArrayList<>();
        stream().forEach(ob -> {
            if (ob instanceof Employe) {
                var ob1 = (Employe) ob;
                String comp = ob1.getCompany();
                if (c.stream().noneMatch(comp::equals))
                    c.add(comp);
            }
        });
        return c;
    }

    public double averageSalary(String c) {
        double sum = stream().map(element -> {
            if (element instanceof Employe) {
                if(((Employe) element).getCompany().equals(c))
                    return (((Employe) element).calculateSalary());
            }
            return 0.0;
        }).reduce(0.0, (f, s) -> f + s);
        double count = stream().filter(element -> {
            if (element instanceof Employe) {
                return ((Employe) element).getCompany().equals(c);
            }
            return false;
        }).count();

        return sum/count;
    }
}
