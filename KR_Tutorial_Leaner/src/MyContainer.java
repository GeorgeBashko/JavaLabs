import java.util.ArrayList;
import java.util.stream.Collectors;

public class MyContainer<T extends Comparable<Leaner>> extends ArrayList<Leaner> {
    public void printInformationByAverageMark()
    {
        stream().sorted((a,b) -> Double.compare(b.getAverageMark(),a.getAverageMark())).forEach(Leaner::print);
    }
    public long countOfLeaner(Leaner l)
    {
        return stream().filter(o->o.equals(l)).count();
    }
    public MyContainer<Leaner> twoMaxLeaners() {
        MyContainer<Leaner> c = stream().sorted().collect(Collectors.toCollection(MyContainer::new));
        MyContainer<Leaner> out = new MyContainer<>();
        out.add(c.get(0));
        out.add(c.get(1));
        return out;
    }
    public double averageMark(String s)
    {
        double sum = stream().map((first) ->
        {
            if(first.getNameOfSchool().equals(s))
          return  first.getAverageMark();
            else return 0.0;
        }).reduce(0.0,(f,c)->f + c);
        long count = stream().filter(o ->o.getNameOfSchool().equals(s)).count();
        return sum/count;
    }
}
