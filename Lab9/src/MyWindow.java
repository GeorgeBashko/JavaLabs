import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyWindow extends JFrame {
    public static void main(String[] args) {
        MyWindow w = new MyWindow("Lab9");
    }
    private JButton addItems = new JButton("Add");
    private JButton showItems = new JButton("Show");
    private JLabel label = new JLabel("Students: ");
    private MenuBar menuBar = new MenuBar();
    private MenuItem menuItem = new MenuItem("Open");
    private Menu menu = new Menu("File");
    private List list = new List();
    private List list1 = new List();
    private ArrayList<Student> arrayList = new ArrayList<>();
    private TreeSet<Integer> arrayListBad = new TreeSet<>();
    private HashMap<Integer,String> hashMap = new HashMap<>();
    public MyWindow(String s)
    {
        super(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750,600);
        menu.add(menuItem);
        menuBar.add(menu);
        setMenuBar(menuBar);
        Box b2 = new Box(BoxLayout.LINE_AXIS);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        JPanel panel11 = new JPanel();
        panel11.add(label);
        panel1.add(panel11);
        JPanel panel12 = new JPanel();
        panel12.add(showItems);
        panel1.add(panel12);
        JPanel panel14 = new JPanel();
        panel14.add(addItems);
        panel1.add(panel14);
        b2.add(panel1);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        panel2.add(list);
        panel2.add(list1);
        b2.add(panel2);
        add(b2);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == showItems) {
                    try {
                        list1.removeAll();
                        hashMap.entrySet().stream().filter(x->!arrayListBad.contains(x.getKey())).sorted(Map.Entry.comparingByValue()).forEach(y-> {
                            list1.add(y.getValue() + " " + y.getKey());
                        });
                    }
                    catch (NullPointerException e1)
                    {
                        JOptionPane.showMessageDialog(MyWindow.this, "No such element!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (e.getSource() == menuItem)
                {
                    File f = new File("");
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("./"));
                    int actionDialog = fileChooser.showSaveDialog(MyWindow.this);
                    if (actionDialog == JFileChooser.APPROVE_OPTION) {
                        f = new File(fileChooser.getSelectedFile() + "");
                        readStudents(f);
                        showStudents(list,arrayList);
                    }
                    list1.removeAll();
                }
                else if(e.getSource() == addItems)
                {
                    MyDialog myDialog = new MyDialog(MyWindow.this,"Add Student");
                    Student newStudent = myDialog.getStudent();
                    if(!newStudent.equals(new Student()))
                    {
                        arrayList.add(newStudent);
                        if(newStudent.getSubjectMark() < 9)
                        {
                            arrayListBad.add(newStudent.getCardNumber());
                        }
                        hashMap.put(newStudent.getCardNumber(),newStudent.getSurname());
                        showStudents(list,arrayList);
                    }
                }
            }
        };
        showItems.addActionListener(actionListener);
        addItems.addActionListener(actionListener);
        menuItem.addActionListener(actionListener);
        setVisible(true);
    }
    public void readStudents(File f)
    {
        Scanner s = null;
        try
        {
            arrayList = new ArrayList<>();
            arrayListBad = new TreeSet<>();
            hashMap = new HashMap<>();
            s = new Scanner(f);
            while (s.hasNext())
            {
                String str = s.next();
                int n = s.nextInt();
                String str1 = s.next();
                int d = s.nextInt();
                if(d < 9)
                {
                    arrayListBad.add(n);
                }
                arrayList.add(new Student(str,n,str1,d));
                hashMap.put(n,str);
            }
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(this,"File error!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void showStudents(List l,ArrayList<Student> arrayList) throws NullPointerException
    {
        if(arrayList.size() == 0)
            throw new NullPointerException();
        else {
            l.removeAll();
            for (Student s : arrayList)
                l.add(s.toString());
        }
    }
}