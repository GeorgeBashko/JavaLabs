import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Series implements Comparable<Series>{
    private double firstElement;
    private double de;
    private double numOfElements;
    Series(double f,double d,int n)
    {
        this.firstElement = f;
        this.de = d;
        this.numOfElements = n;
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
    public abstract double GetElement(int i);
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return Double.compare(series.firstElement, firstElement) == 0 && Double.compare(series.de, de) == 0 && Double.compare(series.numOfElements, numOfElements) == 0;
    }
    public double getFirstElement()
    {
        return this.firstElement;
    }
    public double getNumOfElements()
    {
        return this.numOfElements;
    }
    public double getDe()
    {
        return this.de;
    }

    @Override
    public int compareTo(Series o) {
        return -Double.compare(this.firstElement,o.firstElement);
    }
        public double Sum()
    {
        double sum = 0;
        for(int i = 1;i <= numOfElements;i++)
        {
            sum += GetElement(i);
        }
        return sum;
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
