import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

interface Observable
{
    void update(EventObject eventObject);
}
interface Subject
{
    void attach(Observable o);
    void notify(EventObject eventObject);
}
public class Observer implements Observable {
    private JLabel label;
    public Observer(JLabel j)
    {
        label = j;
    }
    @Override
    public void update(EventObject eventObject) {
        KeyEvent keyEvent = (KeyEvent) eventObject;
        label.setText(keyEvent.getKeyChar() + "");
    }
}
class ObserverLog implements Observable
{
    private JTextArea textArea;
    public ObserverLog(JTextArea t)
    {
        textArea = t;
    }
    @Override
    public void update(EventObject eventObject) {
        KeyEvent keyEvent = (KeyEvent)eventObject;
        textArea.append("Key " + "\"" + keyEvent.getKeyChar() + "\"" + " was pressed!" + '\n');
    }
}
class mySubject implements Subject
{
    private List<Observable> list;
    public mySubject()
    {
        list = new ArrayList<>();
    }

    @Override
    public void attach(Observable o) {
        list.add(o);
    }

    @Override
    public void notify(EventObject eventObject) {
        for(Observable o:list)
        {
            o.update(eventObject);
        }
    }
}
