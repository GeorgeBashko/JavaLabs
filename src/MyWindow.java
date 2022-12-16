import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MyWindow extends JFrame {
    private static ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Student> arrayList = new ArrayList<>();
    private TreeSet<Integer> arrayListBad = new TreeSet<>();
    private HashMap<Integer, String> hashMap = new HashMap<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        MyWindow w = new MyWindow("Lab9");
    }

    private JButton addItems = new JButton("Add");
    private JButton showItems = new JButton("Show");
    private JLabel label = new JLabel("Students: ");
    private MenuBar menuBar = new MenuBar();
    private MenuItem menuItem = new MenuItem("Open");
    private MenuItem menuItem1 = new MenuItem("Save");
    private Menu menu = new Menu("File");
    private List list = new List();
    private List list1 = new List();

    public MyWindow(String s) {
        super(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 600);
        menu.add(menuItem);
        menu.add(menuItem1);
        menuBar.add(menu);
        setMenuBar(menuBar);
        Box b2 = new Box(BoxLayout.LINE_AXIS);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
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
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(list);
        panel2.add(list1);
        b2.add(panel2);
        add(b2);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == showItems) {
                    try {
                        list1.removeAll();
                        hashMap.entrySet().stream().filter(x -> !arrayListBad.contains(x.getKey())).sorted(Map.Entry.comparingByValue()).forEach(y -> {
                            list1.add(y.getValue() + " " + y.getKey());
                        });
                    } catch (NullPointerException e1) {
                        JOptionPane.showMessageDialog(MyWindow.this, "No such element!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (e.getSource() == menuItem) {
                    File f = new File("");
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("./"));
                    int actionDialog = fileChooser.showOpenDialog(MyWindow.this);
                    if (actionDialog == JFileChooser.APPROVE_OPTION) {
                        f = new File(fileChooser.getSelectedFile() + "");
                        try {
                            readByDOM(f);
                        } catch (ParserConfigurationException | IOException | SAXException ex) {
                            throw new RuntimeException(ex);
                        }
                        showStudents(list, arrayList);
                    }
                    list1.removeAll();
                } else if (e.getSource() == addItems) {
                    MyDialog myDialog = new MyDialog(MyWindow.this, "Add Student");
                    Student newStudent = myDialog.getStudent();
                    if (!newStudent.equals(new Student())) {
                        arrayList.add(newStudent);
                        if (newStudent.getSubjectMark() < 9) {
                            arrayListBad.add(newStudent.getCardNumber());
                        }
                        hashMap.put(newStudent.getCardNumber(), newStudent.getSurname());
                        showStudents(list, arrayList);
                    }
                }else if(e.getSource() == menuItem1)
                {
                    File f = new File("");
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("./"));
                    int actionDialog = fileChooser.showSaveDialog(MyWindow.this);
                    if (actionDialog == JFileChooser.APPROVE_OPTION) {
                        f = new File(fileChooser.getSelectedFile() + "");
                        try {
                            saveAsXML(f);
                        } catch (ParserConfigurationException | TransformerException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        };
        showItems.addActionListener(actionListener);
        addItems.addActionListener(actionListener);
        menuItem.addActionListener(actionListener);
        menuItem1.addActionListener(actionListener);
        setVisible(true);
    }

    public void readStudents(File f) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();
        SaxParser saxParser = new SaxParser();
        parser.parse(new File("src/" + f.getName()), saxParser);
//        Scanner s = null;
//        try
//        {
//            arrayList = new ArrayList<>();
//            arrayListBad = new TreeSet<>();
//            hashMap = new HashMap<>();
//            s = new Scanner(f);
//            while (s.hasNext())
//            {
//                String str = s.next();
//                int n = s.nextInt();
//                String str1 = s.next();
//                int d = s.nextInt();
//                if(d < 9)
//                {
//                    arrayListBad.add(n);
//                }
//                arrayList.add(new Student(str,n,str1,d));
//                hashMap.put(n,str);
//            }
//        }
//        catch (FileNotFoundException e)
//        {
//            JOptionPane.showMessageDialog(this,"File error!","Error",JOptionPane.ERROR_MESSAGE);
//        }
    }

    private void showStudents(List l, ArrayList<Student> arrayList) throws NullPointerException {
        if (arrayList.size() == 0)
            throw new NullPointerException();
        else {
            l.removeAll();
            for (Student s : arrayList)
                l.add(s.toString());
        }
    }

    class SaxParser extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("student")) {
                String name = attributes.getValue("name");
                String number = attributes.getValue("number");
                String subject = attributes.getValue("subject");
                String mark = attributes.getValue("mark");
                if (Integer.parseInt(mark) < 9) {
                    arrayListBad.add(Integer.parseInt(number));
                }
                arrayList.add(new Student(name, Integer.parseInt(number), subject, Integer.parseInt(mark)));
                hashMap.put(Integer.parseInt(number), name);
            }
        }
    }

    public void readByDOM(File f) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/" + f.getName()));
        System.out.println("asd");
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("student");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node student = nodeList.item(i);
            NamedNodeMap attributes = student.getAttributes();
            if (Integer.parseInt(attributes.getNamedItem("mark").getNodeValue()) < 9) {
                arrayListBad.add(Integer.parseInt(attributes.getNamedItem("number").getNodeValue()));
            }
            arrayList.add(new Student(attributes.getNamedItem("name").getNodeValue(), Integer.parseInt(attributes.getNamedItem("number").getNodeValue()), attributes.getNamedItem("subject").getNodeValue(), Integer.parseInt(attributes.getNamedItem("mark").getNodeValue())));
            hashMap.put(Integer.parseInt(attributes.getNamedItem("number").getNodeValue()), attributes.getNamedItem("name").getNodeValue());
        }
    }

    public void saveAsXML(File f) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElementNS(null, "students");
        document.appendChild(root);
        for(Student student:arrayList) {
            root.appendChild(getStudent(document, student.getCardNumber(), student.getSurname(), student.getSubjectName(), student.getSubjectMark()));
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult file = new StreamResult(new File("src/" + f.getName() + ".xml"));
        transformer.transform(source, file);
    }
    public Node getStudent(Document doc, int id, String name, String subj, int mark) {
        Element language = doc.createElement("Student");
        language.setAttribute("name",name);
        language.setAttribute("number", String.valueOf(id));
        language.setAttribute("subject",subj);
        language.setAttribute("mark",String.valueOf(mark));
        return language;
    }
}