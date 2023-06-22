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
    static Patient[] patients3;

    public void readtemporaryFile() {
        File file = new File("jacksonfileFromGitHub.json");
        try (FileReader reader = new FileReader(file)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new DateBirthdateDeserializer());
            gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanHealthyDeserializer());

            Gson gson = gsonBuilder.setPrettyPrinting().create();

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

            Gson gson = gsonBuilder.setPrettyPrinting().create();

            patients2 = gson.fromJson(reader, Patient[].class);

            System.out.println(Arrays.asList(patients2));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createBuferBase() {
        ArrayList<Patient> base = new ArrayList<>();
        base.addAll(List.of(patients));
        base.addAll(List.of(patients2));

        TreeSet<Patient> set = new TreeSet<>(base);
        System.out.println(set);

        String filePath = "buferFilePatientsBase.json";

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

    public void createFinalPatientsBase() {
        File file = new File("finalPatientsBase.json");
        try (FileReader reader = new FileReader(file)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new DateBirthdateDeserializer());
            gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanHealthyDeserializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();

            patients3 = gson.fromJson(reader, Patient[].class);

            System.out.println(Arrays.asList(patients3));
            ArrayList<Patient> finalBase = new ArrayList<>();
            finalBase.addAll(List.of(patients));
            finalBase.addAll(List.of(patients2));
            finalBase.addAll(List.of(patients3));

            TreeSet<Patient> set = new TreeSet<>(finalBase);
            System.out.println(set);

            String filePath = "finalPatientsBase.json";
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))) {
                gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanHealthySerializer());
                gson = gsonBuilder.setPrettyPrinting().setDateFormat("dd-MM-yyyy").create();
                String json = gson.toJson(set);
                printWriter.write(json);
                System.out.println(json);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
