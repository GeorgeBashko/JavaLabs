import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Window extends JFrame {
    private Series s1;
    public static void main(String[] args) {
    }
    Window(String str) throws IOException {
        super(str);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JFrame f1 = new JFrame("Example");
        f1.setSize(500,500);
        JTextField name1 = new JTextField("First element");
        JTextField name2 = new JTextField("Raznost");
        JTextField name3 = new JTextField("Count of elements");
        JTextField name4 = new JTextField("File name");
        JRadioButton rb1 = new JRadioButton("Linear");
        JRadioButton rb2 = new JRadioButton("Exponential");
        JButton b1 = new JButton("Create");
        JButton b2 = new JButton("Write");
        ButtonGroup bg = new ButtonGroup();
        name1.setBounds(90,100,110,30);
        name2.setBounds(200,100,110,30);
        name3.setBounds(310,100,110,30);
        name4.setBounds(200,240,110,40);
        rb1.setSelected(true);
        rb1.setBounds(190,150,100,30);
        rb2.setBounds(300,150,100,30);
        bg.add(rb1);
        bg.add(rb2);
        f1.add(rb1);
        f1.add(rb2);
        f1.add(b1);
        f1.add(b2);
        f1.add(name1);
        f1.add(name2);
        f1.add(name3);
        f1.add(name4);
        b1.setBounds(90,200,110,40);
        b2.setBounds(310,200,110,40);
        f1.setLayout(null);
        f1.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    double f = Double.parseDouble(name1.getText());
                    double d = Double.parseDouble(name2.getText());
                    int n = Integer.parseInt(name3.getText());
                    if(rb1.isSelected())
                        s1 = new Linear(f,d,n);
                    else
                        s1 = new Exponential(f,d,n);
                }
                catch (NumberFormatException e1)
                {
                    JOptionPane.showMessageDialog(Window.this,"Error",e1.getMessage(),0);
                    b2.setEnabled(false);
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String s2 = name4.getText();
                File ff = new File("src\\" + s2 +".txt");
                try {
                    s1.save(ff);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
