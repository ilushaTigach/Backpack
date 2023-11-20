import java.io.*;

public class DataRecorder {

    public void writeItem(String json)  {
        File file = new File("src/main/java/package.json");

        try(PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            pw.println(json);
            System.out.println("Запись произведена успешно!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

