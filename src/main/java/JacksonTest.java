import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JacksonTest {

    ObjectMapper objectMapper = new ObjectMapper();

    public String pojoToJsonString(Backpack backpack) throws JsonProcessingException {

        objectMapper.enableDefaultTyping();

        String json = objectMapper.writeValueAsString(backpack);

        System.out.println(json);
        return json;
    }
    public void jsonToPojoString() throws IOException {
        File file = new File("package.json");

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
//        Item item = objectMapper.readValue(file, Item.class); по умному так, но так не робит
//        System.out.println(item);

    }
}
