import java.util.ArrayList;
import java.util.Collections;

public class MyCollections<T extends Automobile> extends ArrayList<T> {
    public T max() throws EmptyException{
        if(this.isEmpty())
            throw new EmptyException("Empty!");
        return Collections.max(this);
    }
    public T min() throws EmptyException {
        if (this.isEmpty())
            throw new EmptyException("Empty!");
        return Collections.min(this);
    }
    public int amount(T auto) throws EmptyException
    {
        if(this.isEmpty())
            throw new EmptyException("Empty!");
        return Collections.frequency(this,auto);
    }
    public T binarySearch(T el) throws EmptyException
    {
        if(this.isEmpty())
            throw new EmptyException("Empty!");
        MyCollections<T> mcl = (MyCollections<T>) this.clone();
        Collections.sort(mcl);
        int i = Collections.binarySearch(mcl,el);
        if(i < 0)
            return null;
        return mcl.get(i);
    }
    public void printContainer()
    {
        System.out.println("-------------------------"+'\n'+"Your container: ");
        for (int i = 0;i < this.size();i++)
            this.get(i).print();
        System.out.println("-------------------------");
    }
}
