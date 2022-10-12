public class Linear extends Series {
    public Linear(double el,double d,int num)
    {
        super(el,d,num);
    }
    @Override
    public double GetElement(int i)
    {
        return (firstElement + (i - 1)*de);
    }
}
