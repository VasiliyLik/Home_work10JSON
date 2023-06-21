package jackson;

import java.io.IOException;
import java.text.ParseException;

public class JacksonTest {
    public static void main(String[] args) throws IOException, ParseException {
        CreateJsonFile jsonFile = new CreateJsonFile();
        jsonFile.createPatientsJsonlFile();
    }
}
