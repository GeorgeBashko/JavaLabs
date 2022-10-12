import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    protected double firstElement;
    protected double de;
    protected double numOfElements;
    Series(double f,double d,int n)
    {
        firstElement = f;
        de = d;
        numOfElements = n;
    }
    public abstract double GetElement(int i);
    public double Sum()
    {
        double sum = 0;
        for(int i = 1;i <= numOfElements;i++)
        {
            sum += GetElement(i);
        }
        return sum;
    }
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        for(int i = 1;i <= numOfElements;i ++)
        {
            s.append(GetElement(i));
            s.append(" ");
        }
        return s.toString();
    }
    public void Save(File file) throws IOException, FileNotFoundException
    {
        FileWriter fw = new FileWriter(file);
        String s = toString();
        fw.write(s,0,s.length());
        fw.write('\n');
        fw.write("Sum is " + Sum());
        fw.close();
    }
}