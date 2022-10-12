import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Series s1 = new Linear(1,2,10);
        File file  = new File("src\\Output.txt");
        s1.Save(file);
        Series s2 = new Exponential(1,2,10);
        s2.Save(file);
    }
}