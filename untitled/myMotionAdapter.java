import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class myMotionAdapter extends MouseMotionAdapter {
    public void mouseMoved(MouseEvent e)
    {
        setStatus(e.getX(),e.getY());
    }
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }
}
