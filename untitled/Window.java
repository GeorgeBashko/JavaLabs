import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    private final JButton button1 = new JButton("No");
    private final JButton button2 = new JButton("Yes");
    private final JLabel label = new JLabel("Are you gay?");
    private final JLabel answer = new JLabel("");
    Window(String s)
    {
        super(s);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label.setBounds(200,50,100,50);
        answer.setBounds(200,150,100,50);
        answer.setVisible(false);
        add(answer);
        add(label);
        setLayout(null);
        button1.setBounds(100,100,100,40);
        button2.setBounds(300,100,100,40);
        add(button1);
        add(button2);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                answer.setText("C'est la vie");
                answer.setVisible(true);
                button2.setEnabled(false);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int x = (int)(Math.random() * 450);
                int y = (int)(Math.random() * 300) + 150;
                if(button1.getX() + 50 >= x || button1.getY() + 50 >= y || button1.getY() - 50 <= y || button1.getX() <= x) {
                    y += 50;
                    x += 50;
                }
                    button1.setLocation(x,y);
            }
        });

    }
}
