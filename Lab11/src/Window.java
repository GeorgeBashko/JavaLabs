import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JFrame {
    private JLabel jLabel = new JLabel("");
    private JTextArea jTextArea = new JTextArea("");
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Window window = new Window();
    }
    public Window()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        setSize(600,600);
        mySubject mySubject = new mySubject();
        ObserverLog observer1 = new ObserverLog(jTextArea);
        Observer observer = new Observer(jLabel);
        mySubject.attach(observer);
        mySubject.attach(observer1);
        jTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                    mySubject.notify(e);
            }
        });
        jLabel.setFont(new Font("Courier",Font.BOLD,350));
        jTextArea.setEditable(false);
        add(jLabel);
        add(jTextArea);
        setVisible(true);
    }
}