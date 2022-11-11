import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
        public static void main(String[] args) {
            Window w = new Window("Lab8");
    }
    Window(String s)
    {
        super(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Task1",new Task1());
        tabbedPane.addTab("Task2",new Task2());
        tabbedPane.addTab("Task3",new Task3());
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);
        tabbedPane.setMnemonicAt(2,KeyEvent.VK_3);
        add(tabbedPane);
        setVisible(true);
    }
    class Task1 extends JPanel
    {
        private final String[] DATA1 = {"New York      ","Chicago","Washington","Colorado","Pittsburgh","New Jersey","Seattle","Tampa Bay","Arizona","Nashville"};
        private final String[] DATA2 = {"Minsk     ","Moscow","Omsk","Khabarovsk","Ufa    ","Novgorod    ","Helsinki   ","Yaroslavl  ","Riga  ","Zagreb"};
        public Task1() {
            setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            DefaultListModel rightModalList = new DefaultListModel<>();
            DefaultListModel leftModalList = new DefaultListModel<>();
            JButton rightButton = new JButton(new ImageIcon("src\\right.png"));
            rightButton.setBackground(Color.white);
            JButton leftButton = new JButton(new ImageIcon("src\\left.png"));
            leftButton.setBackground(Color.white);
            panel.add(rightButton,BorderLayout.NORTH);
            panel.add(leftButton,BorderLayout.SOUTH);
            add(panel,BorderLayout.CENTER);
            for(String s:DATA1)
                leftModalList.add(0,s);
            for (String s:DATA2)
                rightModalList.add(0,s);
            JList leftList = new JList<>(leftModalList);
            JList rightList = new JList<>(rightModalList);
            leftList.setFont(new Font("Serif",Font.ITALIC,30));
            rightList.setFont(new Font("Serif",Font.ITALIC,30));
            add(rightList,BorderLayout.EAST);
            add(leftList,BorderLayout.WEST);
            rightButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!leftList.isSelectionEmpty())
                    {
                        rightModalList.add(0,leftList.getSelectedValue());
                        leftModalList.remove(leftList.getSelectedIndex());
                        if(!leftModalList.isEmpty())
                            leftList.setSelectedIndex(0);
                    }
                }
            });
            leftButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!rightList.isSelectionEmpty())
                    {
                        leftModalList.add(0,rightList.getSelectedValue());
                        rightModalList.remove(rightList.getSelectedIndex());
                        if(!rightModalList.isEmpty())
                            rightList.setSelectedIndex(0);
                    }
                }
            });
        }

    }
    class Task2 extends JPanel
    {
        private String name;
        private Color color;
        private final int N = 8;
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    JButton temp = (JButton) e.getSource();
                    name = temp.getText();
                    temp.setText("Clicked!");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    JButton temp = (JButton) e.getSource();
                    temp.setText(name);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JButton temp = (JButton)e.getSource();
                color = temp.getBackground();
                temp.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton temp = (JButton)e.getSource();
                temp.setBackground(color);
            }
        };
        Task2()
        {
            setLayout(new GridLayout(N,N));
            for(int i = 0;i < N*N;i++)
            {
                JButton button = new JButton(i + 1 + "");
                button.addMouseListener(mouseListener);
                add(button);
            }
        }
    }
    class Task3 extends JPanel
    {
        private final ImageIcon[] imageIcons = new ImageIcon[]{new ImageIcon("src/a.png"),new ImageIcon("src/b.png"),new ImageIcon("src/c.png"),new ImageIcon("src/d.png")};
        public Task3()
        {
          ButtonGroup buttonGroup = new ButtonGroup();
          Box box = new Box(1);
          for (int i = 0;i < 3;i++)
          {
              JRadioButton radioButton = new JRadioButton(imageIcons[3]);
              radioButton.setPressedIcon(imageIcons[0]);
              radioButton.setRolloverIcon(imageIcons[1]);
              radioButton.setSelectedIcon(imageIcons[2]);
              buttonGroup.add(radioButton);
              box.add(radioButton);
          }
          add(box);
        }
    }
}
