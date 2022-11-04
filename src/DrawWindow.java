import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DrawWindow extends JFrame {
    private JButton openButton = new JButton("Open");
    private JButton saveButton = new JButton("Save");
    private JRadioButton redButton = new JRadioButton("Red");
    private JRadioButton greenButton = new JRadioButton("Green");
    private JRadioButton blueButton = new JRadioButton("Blue");
    private PaintLine paintLine;
    private DrawPanel panel;
    private ArrayList<PaintLine> lineList = new ArrayList<>();
    public static void main(String[] args) {
        new DrawWindow("Paint");
    }
    public DrawWindow(String s)
    {
        super(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new DrawPanel();
        setPreferredSize(new Dimension(800,800));
        setResizable(false);
        panel.setPreferredSize(new Dimension(1100,900));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Color color = redButton.isSelected() ? Color.red : greenButton.isSelected() ? Color.green : blueButton.isSelected() ? Color.blue : Color.black;
                paintLine = new PaintLine(color);
                paintLine.addPoint(e.getX(),e.getY());
                lineList.add(paintLine);
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                paintLine.addPoint(e.getX(),e.getY());
                repaint();
            }
        });
        Box b1 = new Box(BoxLayout.Y_AXIS);
        Box b2 = new Box(BoxLayout.LINE_AXIS);
        b1.add(panel);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(blueButton);
        buttonGroup.add(redButton);
        buttonGroup.add(greenButton);
        b2.add(redButton);
        b2.add(greenButton);
        b2.add(blueButton);
        b2.add(saveButton);
        b2.add(openButton);
        b1.add(new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        b1.add(b2);
        add(b1);
        pack();
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BufferedImage im = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
                panel.paint(im.getGraphics());
                try {
                    File f = new File("");
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("./"));
                    int actionDialog = fileChooser.showSaveDialog(DrawWindow.this);
                    if (actionDialog == JFileChooser.APPROVE_OPTION)
                        f = new File(fileChooser.getSelectedFile() + ".png");
                    ImageIO.write(im, "png", f);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(DrawWindow.this, ex, "Error!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        openButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                File f = new File("");
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("./"));
                int actionDialog = fileChooser.showSaveDialog(DrawWindow.this);
                if (actionDialog == JFileChooser.APPROVE_OPTION)
                    f = new File(fileChooser.getSelectedFile() + "");
                try {
                    BufferedImage bufferedImage = ImageIO.read(f);
                    JLabel jLabel = new JLabel(new ImageIcon(bufferedImage));
                    panel.add(BorderLayout.CENTER,jLabel);
                } catch (IOException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(DrawWindow.this, ex, "Error!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        setVisible(true);
    }
    public class DrawPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(PaintLine l: lineList)
                l.draw(g);
            setBackground(Color.white);
        }
    }
}
