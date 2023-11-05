import lombok.SneakyThrows;

import java.io.File;
import java.io.PrintWriter;

public class DataRecorder {
    @SneakyThrows
    public void writeItem(String json)  {
        File file = new File("package.json");
        PrintWriter pw = new PrintWriter(file);
        pw.println(json);
        pw.close();
        System.out.println("Запись произведена успешно!");
    }
}

