import java.util.ArrayList;
import java.util.stream.Collectors;

public class MyContainer<T extends Comparable<Series>> extends ArrayList<T> {
    public MyContainer<Series> sortByFirstElement()
    {
        return (MyContainer<Series>) stream().sorted().collect(Collectors.toCollection(MyContainer::new));
    }
    public MyContainer<Series> sortByOtn()
    {
        return (MyContainer<Series>) stream().sorted((o,m) ->{
            if(o instanceof Series && m instanceof Series) {
                var a = (Series) o;
                var b = (Series) m;
                double f1 = a.getFirstElement();
                double f2 = b.getFirstElement();
                return -Double.compare(f1 / a.getDe(), f2 / b.getDe());
            }
            return 0;
        }).collect(Collectors.toCollection(MyContainer::new));
    }
    public void printContainer()
    {
        stream().forEach(System.out::println);
    }
    public double getAverageDe(Double fi)
    {
        double sum = stream().map(f ->{
            Series a = (Series) f;
            if(Double.compare(a.getFirstElement(),fi) == 0)
                return a.getDe();
            return 0.0;
        }).reduce(0.0,(x,z)->x+z);
        long count = stream().filter(a->{
            Series b = (Series) a;
            return Double.compare(b.getFirstElement(),fi) == 0;
        }).count();
        return sum/count;
    }
}
