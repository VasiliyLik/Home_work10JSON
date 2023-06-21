package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import model.Patient;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class GitHubFileActions {
    private static Patient[] base;

    public void deserializeFileFromGitHub() throws JsonProcessingException {

        String strJson = getJSONFromURL(
                "https://raw.githubusercontent.com/VasiliyLik/Home_work10JSON/main/src/makejacksonfileForGitHub.json");
        ObjectMapper objectMapper = new ObjectMapper();

        base = objectMapper.readValue(strJson, Patient[].class);
        System.out.println(Arrays.asList(base));
        TreeSet<Patient> patientTreeSet = new TreeSet<>();
        Collections.addAll(patientTreeSet, base);
        System.out.println(patientTreeSet);
        base = patientTreeSet.toArray(new Patient[0]);
    }

    public void createLocalFileFromGitHub() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Boolean.class, new BooleanHealthySerializer());
        String jsonLocalFile = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(base);
        System.out.println(jsonLocalFile);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("jacksonfileFromGitHub.json"), base);
    }

    public static String getJSONFromURL(String strUrl) {
        StringBuilder jsonText = new StringBuilder();

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }
            is.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }
}
