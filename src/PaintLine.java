import java.awt.*;
import java.util.ArrayList;

public class PaintLine {
    private ArrayList<Integer> listX;
    private ArrayList<Integer> listY;
    private Color color;
    public PaintLine(Color c)
    {
        this.color = c;
        this.listX = new ArrayList<>();
        this.listY = new ArrayList<>();
    }
    public void addPoint(int x,int y)
    {
        this.listX.add(x);
        this.listY.add(y);
    }
    void draw(Graphics g)
    {
        for(int i = 0;i < listY.size() - 1;i++) {
            g.setColor(this.color);
            g.drawLine(listX.get(i),listY.get(i),listX.get(i + 1),listY.get(i + 1));
        }
    }
}
