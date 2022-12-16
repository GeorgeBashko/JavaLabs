import javax.swing.*;
import java.awt.*;
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