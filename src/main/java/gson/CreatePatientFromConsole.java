package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Patient;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CreatePatientFromConsole {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input patient's name:");
        final String name = scanner.nextLine();
        System.out.println("Input surName:");
        final String surName = scanner.nextLine();
        System.out.println("Input birthdate: dd-MM-yyyy:");
        final String birthDate = (scanner.nextLine());
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date newDate = simpleDateFormat.parse(birthDate);
        System.out.println("Input state of health - true or false:");
        boolean healthy = scanner.nextBoolean();
        Patient patient = new Patient(name, surName, newDate, healthy);
        ArrayList<Patient> base = new ArrayList<>();
        base.add(patient);

        String filePath = "patientFromConsoleGsonFile.json";
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))) {

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanHealthySerializer());
            Gson gson = gsonBuilder.setPrettyPrinting().setDateFormat("dd-MM-yyyy").create();
            String json = gson.toJson(base);
            printWriter.write(json);
            System.out.println(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
