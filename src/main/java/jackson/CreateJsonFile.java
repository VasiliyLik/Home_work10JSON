package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import model.Patient;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateJsonFile {
    public void createPatientsJsonlFile() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("19-01-1985");
        Patient patient = new Patient("Sara", "Cortny", date, false);
        date = simpleDateFormat.parse("01-12-1972");
        Patient patient2 = new Patient("Zack", "Boom", date, false);
        date = simpleDateFormat.parse("14-03-1994");
        Patient patient3 = new Patient("Ben", "Archi", date, true);
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        patientArrayList.add(patient);
        patientArrayList.add(patient2);
        patientArrayList.add(patient3);

      //  System.out.println(patientArrayList);
        SimpleModule module = new SimpleModule();
        module.addSerializer(Boolean.class, new BooleanHealthySerializer());
        String jsonLocalFile = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patientArrayList);
        System.out.println(jsonLocalFile);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\User\\Desktop\\data\\makejacksonfileForGitHub.json"), patientArrayList);
    }
}
