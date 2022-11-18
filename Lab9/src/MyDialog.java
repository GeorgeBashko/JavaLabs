import javax.swing.*;
import java.awt.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.DataFormatException;

public class MyDialog extends JDialog {
    private JButton button = new JButton("Ok");
    private JLabel nameLabel = new JLabel("Surname: ");
    private JLabel idLabel = new JLabel("Card number: ");
    private JLabel subLabel = new JLabel("Subject: ");
    private JLabel markLabel = new JLabel("Mark: ");
    private JTextField name = new JTextField("",5);
    private JTextField num = new JTextField("",5);
    private JTextField subj = new JTextField("",5);
    private JTextField mark = new JTextField("",5);
    private Student student;
    public MyDialog(JFrame f,String s)
    {
        super(f,s,true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.student = new Student();
        setLayout(new GridLayout(5,2));
        add(nameLabel);
        add(name);
        add(idLabel);
        add(num);
        add(subLabel);
        add(subj);
        add(markLabel);
        add(mark);
        add(button);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button)
                {
                    try {
                        if(name.getText().equals("") || num.getText().equals("") || subj.getText().equals("") || mark.getText().equals(""))
                        {
                            throw new DataFormatException("Incorrect data!");
                        }
                        student.setSurname(name.getText());
                        student.setCardNumber(Integer.parseInt(num.getText()));
                        student.setSubjectName(subj.getText());
                        student.setSubjectMark(Integer.parseInt(mark.getText()));
                        setVisible(false);
                    } catch (DataFormatException | NumberFormatException ex) {
                        JOptionPane.showMessageDialog(MyDialog.this,ex,"Error!",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        };
        button.addActionListener(actionListener);
        pack();
        setVisible(true);
    }
    public Student getStudent()
    {
        return this.student;
    }
}
//import java.awt.event.*;
//import java.awt.*;
//import java.util.zip.DataFormatException;
//import javax.swing.*;
//
///**
// * Created by Drapegnik on 27.11.15.
// */
//public class MyDialog extends JDialog{
//    private JButton ok = new JButton("<html><i><font color=\"green\">ok</font></i></html>");
//    private JLabel labelName = new JLabel("  Name:");
//    private JLabel labelCourse = new JLabel("  Course:");
//    private JLabel labelGroup = new JLabel("  Group:");
//    private JLabel labelNumber = new JLabel("  Number:");
//    private JTextField inputName = new JTextField("", 5);
//    private JTextField inputCourse = new JTextField("", 5);
//    private JTextField inputGroup = new JTextField("", 5);
//    private JTextField inputNumber = new JTextField("", 5);
//    private Student student;
//
//    public MyDialog(JFrame parent, String title, Student o) {
//        super(parent, title, true);
//        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        //setResizable(false);
//        this.student = o;
//
//        Container container = this.getContentPane();
//        container.setLayout(new GridLayout(5, 2));
//
//        container.add(labelName);
//        inputName.setText(student.getSurname());
//        container.add(inputName);
//
//        container.add(labelNumber);
//        inputNumber.setText(student.getCardNumber() + "");
//        container.add(inputNumber);
//
//        container.add(labelCourse);
//        inputCourse.setText(student.getCardNumber() + "");
//        container.add(inputCourse);
//
//        container.add(labelGroup);
//        inputGroup.setText(student.getCardNumber() + "");
//        container.add(inputGroup);
//
//        //container.add(MyJFrame.empty);
//        //ok.addActionListener(this);
//        container.add(ok);
//        pack();
//        setVisible(true);
//    }
//}