import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Window extends JFrame {
    private MyContainer<Linear> l = new MyContainer<>();
    private File f;
    private JButton b1 = new JButton("readLinearFromFile");
    private JButton b12 = new JButton("Write Leaner");
    private JButton b2 = new JButton("Obrabotat linear");
    private JRadioButton m1 = new JRadioButton("m1");
    private JRadioButton m2 = new JRadioButton("m2");
    private JRadioButton m3 = new JRadioButton("m3");
    private JRadioButton m4 = new JRadioButton("m4");

    Window(String s) {
        super(s);
        JFrame f1 = new JFrame();
        f1.setSize(900, 900);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setLayout(null);
        JTextArea printLinear = new JTextArea();
        JTextArea obrLinear = new JTextArea();
        printLinear.setEditable(false);
        obrLinear.setEditable(false);
        JLabel label1 = new JLabel("Your container");
        JLabel label2 = new JLabel("Obrabot container");
        label2.setBounds(200,280,150,20);
        printLinear.setBounds(200,50,500,200);
        obrLinear.setBounds(200,300,500,200);
        label1.setBounds(200,30,150,20);
        f1.add(printLinear);
        b1.setBounds(30,50,100,40);
        b2.setBounds(30,100,100,40);
        b12.setBounds(30,150,100,40);
        m1.setBounds(30,300,100,40);
        m2.setBounds(30,350,100,40);
        m3.setBounds(30,400,100,40);
        m4.setBounds(30,450,100,40);
        ButtonGroup bg = new ButtonGroup();

        bg.add(m1);
        bg.add(m2);
        bg.add(m3);
        bg.add(m4);

        f1.add(m1);
        f1.add(m2);
        f1.add(m3);
        f1.add(m4);

        f1.add(b1);
        f1.add(b2);
        f1.add(b12);

        f1.add(obrLinear);
        f1.add(label1);
        f1.add(label2);
        f1.setVisible(true);
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("./"));
                int actionDialog = fileChooser.showSaveDialog(Window.this);
                if (actionDialog == JFileChooser.APPROVE_OPTION) {
                    f = new File(fileChooser.getSelectedFile() + "");
                    Scanner s = null;
                    try {
                        s = new Scanner(f);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    double first, de;
                    int num;
                    String name1;
                    while (s.hasNext()) {
                        first = Double.parseDouble(s.next());
                        de = Double.parseDouble(s.next());
                        num = Integer.parseInt(s.next());
                        name1 = s.next();
                        l.add(new Linear(first, de, num, name1));
                    }
                    System.out.println("Linear was read!");
                }
            }
        });
        b12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (b12.isEnabled()) {
                    int i = 0;
                    while (i < l.toArray().length) {
                        printLinear.append(l.get(i).toString() + '\n');
                        i++;
                    }
                }
                b12.setEnabled(false);
            }
        });
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(m1.isSelected())
                {
                    obrLinear.setText("");
                    int i = 0;
                    while (i < l.toArray().length) {
                        obrLinear.append(l.sortByFirstElement().get(i).toString() + '\n');
                        i++;
                    }
                }
                else if(m2.isSelected())
                {
                    obrLinear.setText("");
                    int i = 0;
                    while (i < l.toArray().length) {
                        obrLinear.append(l.sortByOtn().get(i).toString() + '\n');
                        i++;
                    }
                }
                else if(m4.isSelected())
                {
                    obrLinear.setText("");
                    obrLinear.append(String.valueOf(l.getAverageDe(12.0)));
                }

            }
        });
    }
}
