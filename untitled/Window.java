import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    private final JButton button2 = new JButton("Да");
    private final JButton button1 = new JButton("Да,но...");
    private final JLabel label = new JLabel("Вы довольны своей стипендией?");
    private final JLabel answer = new JLabel("");
    Window(String s)
    {
        super(s);
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label.setBounds(200,50,200,50);
        answer.setBounds(200,150,200,50);
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
                answer.setText("Это правильный ответ!");
                answer.setVisible(true);
                button2.setEnabled(false);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int x = (int)(Math.random() * 500);
                int y = (int)(Math.random() * 320) + 150;
                if(button1.getX() + 20 >= x || button1.getY() + 20 >= y || button1.getY() - 20 <= y || button1.getX() - 20 <= x) {
                    y += 50;
                    x += 50;
                }
                    button1.setLocation(x,y);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                answer.setText("Учитесь лучше!");
                answer.setVisible(true);
            }
        });

    }
}
