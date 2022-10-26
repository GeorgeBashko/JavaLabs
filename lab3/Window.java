import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    private final JLabel label = new JLabel();
    Window(String s)
    {
        super(s);
        setBounds(400,400,400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(label,BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        add(panel,BorderLayout.CENTER);
        JButton button = new JButton("Click");
        button.setBounds(200,50,100,40);
        panel.setLayout(null);
        panel.add(button);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                setStatus(e.getX(),e.getY());
                button.setBounds(e.getX(),e.getY(),100,40);
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setStatus(e.getX(),e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mouseDragged(e);
            }
        });
        button.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int buttonX = panel.getLocationOnScreen().x;
                int buttonY = panel.getLocationOnScreen().y;
                if(e.isControlDown())
                    button.setLocation(e.getXOnScreen() - buttonX,e.getYOnScreen() - buttonY);
                setStatus(e.getXOnScreen() - buttonX,e.getYOnScreen() - buttonY);
            }
            @Override
            public void mouseMoved(MouseEvent e)
            {
                setStatus(e.getXOnScreen()-panel.getLocationOnScreen().x,e.getYOnScreen() - panel.getLocationOnScreen().y);
            }
        });
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (button.getText().length() > 0)
                        button.setText(button.getText().substring(0, button.getText().length() - 1));
                }
                    else button.setText(button.getText() + e.getKeyChar());
            }
        });
    }
    void setStatus(int x,int y)
    {
        label.setText("x: " + x + "y: " + y);
    }
}
