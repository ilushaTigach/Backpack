import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataRecorder {

    public void writeItem(String json)  {
        File file = new File("src/main/java/package.json");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.println(json);
        pw.close();
        System.out.println("Запись произведена успешно!");
    }
}

