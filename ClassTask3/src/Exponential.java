public class Exponential extends Series{
    public Exponential(double f,double d,int n)
    {
        super(f, d, n);
    }

    @Override
    public double GetElement(int i) {
        return (firstElement * Math.pow(de,(i - 1)));
    }
}
