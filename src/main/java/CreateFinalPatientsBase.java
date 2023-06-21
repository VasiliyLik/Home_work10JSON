import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.BooleanHealthyDeserializer;
import gson.BooleanHealthySerializer;
import gson.DateBirthdateDeserializer;
import model.Patient;

import java.io.*;
import java.util.*;

public class CreateFinalPatientsBase {
    static Patient[] patients;
    static Patient[] patients2;

    public void readtemporaryFile() {
        File file = new File("jacksonfileFromGitHub.json");
        try (FileReader reader = new FileReader(file)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new DateBirthdateDeserializer());
            gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanHealthyDeserializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();//setDateFormat("dd-MM-yyyy").

            patients = gson.fromJson(reader, Patient[].class);

            System.out.println(Arrays.asList(patients));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLocalConsolePatientFile() {
        File file = new File("patientFromConsoleGsonFile.json");
        try (FileReader reader = new FileReader(file)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new DateBirthdateDeserializer());
            gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanHealthyDeserializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();//setDateFormat("dd-MM-yyyy").

            patients2 = gson.fromJson(reader, Patient[].class);

            System.out.println(Arrays.asList(patients2));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFinalBase() {
        ArrayList<Patient> base = new ArrayList<>();
        base.addAll(List.of(patients));
        base.addAll(List.of(patients2));

        TreeSet<Patient> set = new TreeSet<>(base);
        System.out.println(set);

        String filePath = "finalFilePatientsBase.json";
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanHealthySerializer());
            Gson gson = gsonBuilder.setPrettyPrinting().setDateFormat("dd-MM-yyyy").create();
            String json = gson.toJson(set);
            printWriter.write(json);
            System.out.println(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
