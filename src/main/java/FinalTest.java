public class FinalTest {
    public static void main(String[] args) {
        CreateFinalPatientsBase patientsBase = new CreateFinalPatientsBase();
        patientsBase.readtemporaryFile();
        patientsBase.readLocalConsolePatientFile();
        patientsBase.createFinalBase();
    }
}
