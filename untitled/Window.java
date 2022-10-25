import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Window extends JFrame {
    private final JLabel label = new JLabel();
    Window(String s)
    {
        super(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(label,BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel,BorderLayout.CENTER);
        JButton button = new JButton();
        panel.add(button);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                setStatus(e.getX(),e.getY());
                button.setBounds(e.getX(),e.getY(),20,20);
            }
        });
        panel.addMouseMotionListener(new MyMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        button.add(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e)
            {
                setStatus(button.getX(),button.getY());

            }
        });
    }
    void setStatus(int x,int y)
    {
        label.setText("x: " + x + "y: " + y);
    }
}
